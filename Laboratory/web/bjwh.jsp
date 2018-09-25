<%-- 
    Document   : bjwh
    Created on : 2018-3-24, 7:40:46
    Author     : Tom
--%>

<%@page import="java.sql.*"%>
<%@page import="src.DB.DBPool"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Connection con = DBPool.getInstance().getConnection();
    Statement pstmt = con.createStatement();
    ResultSet prs = pstmt.executeQuery("select * from profession");
    Statement gstmt = con.createStatement();
    ResultSet grs = gstmt.executeQuery("select * from grade");
%>
<div class="panel panel-danger panel-body">
    <div class="row">
        <div class="col-md-3">
            <lable for="profession">专业</lable>
            <select id="profession" class="form-control">
                <option value="100">请选择</option>
                <%
                    while (prs.next()) {
                %>
                <option value="<%=prs.getInt(1)%>"><%=prs.getString(2)%></option>
                <%
                    }
                %>
            </select>
        </div>
        <div class="col-md-3">
            <lable for="grade">年级</lable>
            <select id="grade" class="form-control" onchange="showclass(this.value);">
                <option value="100">请选择</option>
                <%
                    while (grs.next()) {
                %>
                <option value="<%=grs.getInt(1)%>"><%=grs.getString(2)%></option>
                <%
                    }
                %>
            </select>
        </div>
        <div class="col-md-3">
            <label for="class">班级</label>
            <div id="classcontent"></div>            
        </div>
        <div class="col-md-3">
            <input type="text" id="classname" class="form-control" value="" />
        </div>
    </div>
    <div class="row">
        <div class="col-md-9"></div>
        <div class="col-md-3"><button id="addclass" class="btn btn-primary" onclick="addclass();">添加</button></div>
    </div>
</div>
<script>
    function showclass(value) {
        var proid=$("#profession option:selected").val();
        $.ajax({
            url: "getclass.jsp",
            data: {"para1": value,"para2":proid},
            type: "get",
            dataType: "html",
            success: function (htmlstr) {
                $("#classcontent").empty();
                $("#classcontent").append(htmlstr);
            }
        });
    };
    
    function addclass(){
        var proid=$("#profession option:selected").val();
        var gradeid=$("#grade option:selected").val();
        var classname=document.getElementById("classname").value;
        $.ajax({
            url:"addclass",
            data:{"para1":proid,"para2":gradeid,"para3":classname},
            type:"get",
            dataType:"html",
            success:function(htmlstr){
                alert("添加成功！");
                showclass(gradeid);
                document.getElementById("classname").value="";
            }
        });
    };
</script>