<%-- 
    Document   : kcb
    Created on : 2018-3-20, 12:01:46
    Author     : Tom
--%>

<%@page import="src.DB.DBPool"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Integer cid = Integer.parseInt(request.getParameter("val"));
    Connection con = DBPool.getInstance().getConnection();
    PreparedStatement pstmt = con.prepareStatement("select * from timetable where classroom_id=? and week=? and section=?");
    pstmt.setInt(1, cid);
    ResultSet tsrs;
    String cname="",section="第",week="星期",teacher="",coursename="",cycle="",phone="";
%>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>星期</th>
                <th>课节</th>
                <th>教师</th>
                <th>授课对象</th>
                <th>课程名</th>
                <th>授课周期</th>
                <th>联系电话</th>
            </tr>
        </thead>
        <tbody>
            <%
                PreparedStatement userstmt = con.prepareStatement("select * from user where id=?");
                PreparedStatement classstmt = con.prepareStatement("select * from class where id=?");
                for (int i = 1; i < 8; i++) {
                    for (int j = 1; j < 6; j++) {
                        pstmt.setInt(2, i);
                        pstmt.setInt(3, j);
                        tsrs = pstmt.executeQuery();
                            week=week+i;
                            section=section+j+"节";
                        if(tsrs.next()){    
                            userstmt.setInt(1, tsrs.getInt(5));
                            ResultSet userrs = userstmt.executeQuery();
                            userrs.next();
                            teacher=userrs.getString(5);
                            coursename=tsrs.getString(7);
                            phone=tsrs.getString(8);
                            cycle=cycle+tsrs.getString(8);
                            do{ 
                                classstmt.setInt(1, tsrs.getInt(6));
                                ResultSet classname = classstmt.executeQuery();
                                classname.next();
                                cname=cname+classname.getString(2); 
                                cycle=cycle+tsrs.getString(8);
                            }while(tsrs.next());
                        }
            %>
            <tr>
                <td><%=week%></td>
                <td><%=section%></td>
                <td><%=teacher%></td>
                <td><%=cname%></td>
                <td><%=coursename%></td>
                <td><%=cycle%></td>
                <td><%=phone%></td>
            </tr>
            <%
                        section="第";week="星期";
                        cname="";teacher="";coursename="";cycle="";phone="";
                    }
                }                
            %>
            
        </tbody>
    </table>
</div>