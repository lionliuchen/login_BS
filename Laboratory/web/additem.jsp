<%-- 
    Document   : additem
    Created on : 2018-3-23, 10:09:08
    Author     : Tom
--%>

<%@page import="java.sql.*"%>
<%@page import="src.DB.DBPool"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Integer roomid = Integer.parseInt(request.getParameter("para"));
    Connection con = DBPool.getInstance().getConnection();
    Statement cstmt = con.createStatement();
    ResultSet crs = cstmt.executeQuery("select * from class");
    Statement sstmt = con.createStatement();
    ResultSet srs = sstmt.executeQuery("select * from section");
%>
<!DOCTYPE html>
<link href="css/flat/red.css" rel="stylesheet">
<script src="js/icheck.min.js"></script>
<div class="form-group">
    <input id="roomid" type="text" value="<%=roomid%>" class="hidden">
    <div class="row">
        <label for="week"><h3>星期</h3></label>

        <select id="week" class="form-control">
            <option value="100">请选择</option>
            <option value="1">星期一</option>
            <option value="2">星期二</option>
            <option value="3">星期三</option>
            <option value="4">星期四</option>
            <option value="5">星期五</option>
            <option value="6">星期六</option>
            <option value="7">星期日</option>
        </select>

    </div>
    <div class="row">
        <label for="section"><h3>课节</h3></label>
        <select id="section" class="form-control">
            <option value="100">请选择</option>
            <%
                while (srs.next()) {
            %>
            <option value="<%=srs.getInt(1)%>"><%=srs.getString(2)%></option>
            <%
                }
            %>            
        </select>
    </div>
    <div class="row">
        <label for="class"><h3>授课对象</h3></label>
        <select id="class" class="form-control">
            <option value="100">请选择</option>
            <%
                while (crs.next()) {
            %>
            <option value="<%=crs.getInt(1)%>"><%=crs.getString(2)%></option>
            <%
                }
            %>
        </select>
    </div>
    <div class="row">
        <label for="kcm"><h3>课程名</h3></label>
        <input id="kcm" type="text" placeholder="" class="form-control">
    </div>
    <div class="row">
        <label for="cycle"><h3>周期</h3></label>        
    </div>
        <div class="row">
            <input type="checkbox" id="c1" value="1"><label for="c1" checked>第1周</label>
            <input type="checkbox" id="c1" value="2"><label for="c1">第2周</label>
            <input type="checkbox" id="c1" value="3"><label for="c1">第3周</label>
            <input type="checkbox" id="c1" value="4"><label for="c1">第4周</label>
            <input type="checkbox" id="c1" value="5"><label for="c1">第5周</label>
            <input type="checkbox" id="c1" value="6"><label for="c1">第6周</label>
            <input type="checkbox" id="c1" value="7"><label for="c1">第7周</label>
            <input type="checkbox" id="c1" value="8"><label for="c1">第8周</label>
            <input type="checkbox" id="c1" value="9"><label for="c1">第9周</label>
            <input type="checkbox" id="c1" value="10"><label for="c1">第10周</label>
            <input type="checkbox" id="c1" value="11"><label for="c1">第11周</label>
            <input type="checkbox" id="c1" value="12"><label for="c1">第12周</label>
            <input type="checkbox" id="c1" value="13"><label for="c1">第13周</label>
            <input type="checkbox" id="c1" value="14"><label for="c1">第14周</label>
            <input type="checkbox" id="c1" value="15"><label for="c1">第15周</label>
            <input type="checkbox" id="c1" value="16"><label for="c1">第16周</label>
        </div>
</div>
<button id="addkb" type="button" class="btn btn-primary" onclick="commitkb();">确认</button>

<script>
    $(document).ready(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_flat-red',
            radioClass: 'iradio_flat-red'
        });
    });

    function commitkb() {
        var str="";
        $.each($('input:checkbox'),function(){
            if(this.checked){str=str+$(this).val()+"-";}
        });
        var len=str.length;
        var week = $("#week option:selected").val();
        var section = $("#section option:selected").val();
        var classid = $("#class option:selected").val();
        var kcm = document.getElementById("kcm").value;
        var cycle = str.substring(0,len-1);
        var roomid = document.getElementById("roomid").value;
        $.ajax({
            url: "commitkb",
            data: {"para1": week, "para2": section, "para3": classid, "para4": kcm, "para5": cycle, "para6": roomid},
            type: "get",
            dataType: "html",
            success: function (htmlstr) {
                alert(htmlstr);
            }
        });
    }
</script>