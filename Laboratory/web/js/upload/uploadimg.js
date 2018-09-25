/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
//用户照片上传程序和图片管理中照片上传程序
    var uploader = new plupload.Uploader({//实例化一个plupload上传对象
        browse_button: 'browse',
        url: 'plupload',
//                flash_swf_url: 'js/Moxie.swf',
//                silverlight_xap_url: 'js/Moxie.xap',
        filters: {
            mime_types: [//只允许上传图片文件
                {title: "图片文件", extensions: "jpg,gif,png"}
            ]
        }
    });
    uploader.init(); //初始化

    //绑定文件添加进队列事件
    uploader.bind('FilesAdded', function (uploader, files) {
        for (var i = 0, len = files.length; i < len; i++) {
            var file_name = files[i].name; //文件名
            //构造html来更新UI
            var html = '<li id="file-' + files[i].id + '"><p class="file-name">' + file_name + '</p><p class="progress"></p></li>';
            $(html).appendTo('#file-list');
            !function (i) {
                previewImage(files[i], function (imgsrc) {
                    $('#file-' + files[i].id).append('<img src="' + imgsrc + '" />');
                })
            }(i);
        }
    });

    //绑定文件上传进度事件
    uploader.bind('UploadProgress', function (uploader, file) {
        $('#file-' + file.id + ' .progress').css('width', file.percent + '%');//控制进度条
    });

    uploader.bind('FileUploaded', function (uploader, files, responseObject) {
        var tu=responseObject.response;
        var tupath=tu.split("~");
        if(tupath[0]==="true"){
            alert("上传成功，可以注册了");
            $("#tupianpath").val(tupath[1]);
        }
        
    });

    //上传按钮
    $('#upload-btn').click(function () {
        uploader.start(); //开始上传
    });
//            图片缩略图处理部分
    function previewImage(file, callback) {//file为plupload事件监听函数参数中的file对象,callback为预览图片准备完成的回调函数
        if (!file || !/image\//.test(file.type))
            return; //确保文件是图片
        if (file.type == 'image/gif') {//gif使用FileReader进行预览,因为mOxie.Image只支持jpg和png
            var fr = new mOxie.FileReader();
            fr.onload = function () {
                callback(fr.result);
                fr.destroy();
                fr = null;
            }
            fr.readAsDataURL(file.getSource());
        } else {
            var preloader = new mOxie.Image();
            preloader.onload = function () {
                preloader.downsize(300, 300);//先压缩一下要预览的图片,宽300，高300
                var imgsrc = preloader.type == 'image/jpeg' ? preloader.getAsDataURL('image/jpeg', 80) : preloader.getAsDataURL(); //得到图片src,实质为一个base64编码的数据
                callback && callback(imgsrc); //callback传入的参数为预览图片的url
                preloader.destroy();
                preloader = null;
            };
            preloader.load(file.getSource());
        }
    }
    ;
});