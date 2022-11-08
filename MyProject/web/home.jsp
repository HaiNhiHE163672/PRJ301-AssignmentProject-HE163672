<%-- 
    Document   : home
    Created on : Nov 4, 2022, 8:56:11 AM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

         <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <h1><span>FPT University Academic Portal</span> </h1>
                </div>
                <div class="col-md-4">
                <table>
                    <tr>
                        <td colspan="2" class="auto-style1"><strong>FAP mobile app (myFAP) is ready at</strong></td>

                    </tr>
                    <tr>
                        <td><a href="">
                            <img src="https://fap.fpt.edu.vn/images/app-store.svg" style="width: 120px; height: 40px" alt="apple store" />
                            </a>
                        </td>
                        <td><a href="">
                            <img src="https://fap.fpt.edu.vn/images/play-store.svg" style="width: 120px; height: 40px" alt="google store" />
                            </a>
                        </td>

                    </tr>
                </table>
                </div>
            </div>
             <style>
                .d{
                    margin-top:10px;
                    margin-bottom: 20px;
                }
                .d1{
                    float: left; 
                    margin-right: 700px;
                }
                .d2 {
                    text-decoration: none;
                }
                .a {
                    margin-top:10px;
                    margin-bottom: 50px;
                    padding: 10px;
                    
                }
                .a1 {
                    float: right; 
                    margin-right: 20px;
                }
                .a1 a, .a1 span {
                    border: none;
                    outline: none;
                    padding: 5px;
                    color: white;
                    background-color: #0fcc45;
                        
                    border-radius: 5px;
                }
              
                .a2 {
                    text-decoration: none;
                }
                
                td {
                    text-align: left;
                    padding: 8px;
                }
                
            </style>
            
            <form action="home" method="POST">

            <div class="a">
  
                    <div class="a1">
                    <c:if test="${sessionScope.account != null}">
                        <a href="">
                            <span>${sessionScope.account.displayname}</span>
                    </a> | 
                    <a href="logout">logout</a> |
                    </c:if>
                    <c:if test="${sessionScope.account eq null}">
                        click 
                        <a href="login">here</a> to login. 
                    </c:if>
                    
                    <span> CAMPUS: FPTU-Hòa Lạc</span>
                </div>

            </div>
                
                
            
            <div class="row">
                <div class="col-md-8">
                     <style>
            .box h3 {
                height: 34px;
                line-height: 34px;
                display: inline-block;
                position: absolute;
                left: 0;
                top: -34px;
                padding: 0 15px;
                color: #fff;
                border-radius: 5px 5px 0 0;
            }
            .orangeTitle {
                background-position: 0 -400px;
                background-color: #ef8d01;
            }
        </style>
        <div class="box" style="float: right; width: 60%">
            <h3 class="orangeTitle">Academic Information</h3>
        </div>
        <div class="listBoxWrapper">
            <table>
                <tr>
                    <td>
                        <table>
                            <tbody>
                                <tr>
                                    <td valign="top" style="width: 55%;">
                                        <h4>Registration/Application(Thủ tục/đơn từ)</h4>
                                        <ul>
                                            <li><a href="">Suspend one semester to take repeated course</a>&nbsp;|&nbsp; <a href="FrontOffice/RemoveApplication.aspx?code=R1">Cancel</a> (Xin tạm hoãn tiến độ một học kỳ
                                                để học lại | Hủy bỏ việc xin tạm hoãn)</li>
                                            <li><a href="">Suspend one semester</a>&nbsp;|&nbsp;
                                                <a href="">Cancel</a> (Xin tạm nghỉ một học kỳ | Hủy bỏ việc xin tạm nghỉ)</li>
                                            <li><a href="">Move out class </a>(Xin chuyển lớp)</li>
                                            <li><a href="">Register extra courses</a> (Đăng ký môn học đi chậm kỳ)</li>
                                            <li><a href="">Register to improve mark </a>&nbsp;(Đăng ký học cải thiện điểm)</li>
                                            <li><a href="">Register to repeat a course</a> (Đăng ký học lại)</li>
                                            <li><a href="">Cancel registration </a>(Hủy đăng ký học)</li>
                                            <li><a href="">Register Free Elective Courses </a>(Đăng ký môn tự chọn)</li>
                                            <li><a href="">Send Application</a> (Gửi đơn) |&nbsp; <a href="App/AcadAppView.aspx">View Application</a> (Xem đơn)</li>
                                            <li><a href="">Xin xác nhận sinh viên</a></li>
                                            <li><a href="">Choose paid items (Lựa chọn các khoản nộp)</a> - <a href="Report/DngRequests.aspx">View</a></li>
                                            <li><a href="">Yêu cầu đổi chéo lớp với sinh viên </a></li>
                                        </ul>
                                    </td>
                                    <td valign="top">
                                        <h4>Information Access(Tra cứu thông tin)</h4>
                                        <ul>
                                            <li><a href="lecturer/ltimetable?lid=${sessionScope.account.lecturer.id}">Take Attendance for Student </a></li>
                                            <li><a href="">University timetable </a>(Lịch học)</li>
                                            <li><a href="">Tuition fee per course</a> (Biểu học phí)</li>
                                            <li><a href="student/timetable?stdid=${sessionScope.account.student.id}">Weekly timetable</a> (Thời khóa biểu từng tuần)</li>
                                            <li><a href="">Blended Online Course (BLOC) Schedules </a>(Lịch học các môn theo phương pháp BLOC trong kỳ)</li>
                                            <li><a href="">Class timetable</a> (Xem thời khóa biểu của một lớp)</li>
                                        </ul>
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top">
                                        <h4>Feedback(Ý kiến)</h4>
                                        <ul>
                                            <li><a href="">Feedback about teaching</a> (Ý kiến về việc giảng dạy)</li>
                                        </ul>
                                    </td>
                                    <td valign="top">
                                        <h4>Reports(Báo cáo)</h4>
                                        <ul>
                                            <li><a href="student/attlist?stdid=${sessionScope.account.student.id}&gid=${g.id}&subid=${s.id}">Attendance report</a> (Báo cáo điểm danh)</li>
                                            <li><a href="">Mark Report</a> (Báo cáo điểm)</li>
                                            <li><a href="">Academic Transcript</a> (Báo cáo điểm)</li>
                                            <li><a href="">Curriculum</a> (Khung chương trình)</li>
                                            <li><a href="">Student Fee</a> (Tra cứu học phí đã nộp theo kỳ)</li>
                                            <li><a href="">Transaction history</a> (Lịch sử giao dịch)</li>
                                        </ul>
                                    </td>
                                </tr>
                                
                            </tbody>
                        </table>
            </table>
                </div>
               
            </div>
        
                           
       </div>
                                             </form>
</body>
</html>
