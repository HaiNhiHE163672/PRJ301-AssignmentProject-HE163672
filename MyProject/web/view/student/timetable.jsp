<%-- 
    Document   : timetable
    Created on : Oct 13, 2022, 10:39:39 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap -->
        <link href="../../bootstrap.min.csss" rel="stylesheet">
	<!-- Embed css link here-->
        <link href="../../bootstrap.min.css" rel="stylesheet" type="text/css"/>
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
                
                .a {
                    margin-top:10px;
                    margin-bottom: 50px;
                    
                }
                .a1 {
                    float: right; 
                    margin-right: 20px;
                }
                .a1 a, .a1 span {
                    border: none;
                    outline: none;
                    padding: 4px;
                    color: white;
                    background-color: #0fcc45;
                    border-radius: 5px;
                }
              
                .a2 {
                    text-decoration: none;
                }
                
            </style>

            <div class="a">
                <div class="a1">
                    <a href="">
                        <span>${requestScope.student.name}</span>
                    </a> | 
                    <a href="">logout</a> |
                    <span> CAMPUS: FPTU-Hòa Lạc</span>
                </div>
                <div class="a2">
                    <span>
                        <a href='#'>Home</a>|
                        <b>View Schedule</b>
                    </span>
                </div>
            </div>
            
            
            
        <div>
            <h1>Activities for username</h1>  
        </div>
            <p>
        <b>Note</b>: These activities do not include extra-curriculum activities, such as
        club activities ...
    </p>
    <p>
        <b>Chú thích</b>: Các hoạt động trong bảng dưới không bao gồm hoạt động ngoại khóa,
        ví dụ như hoạt động câu lạc bộ ...
    </p>
    <div>
                <p>Các phòng bắt đầu bằng AL thuộc tòa nhà Alpha. VD: AL...</p>
                <p>Các phòng bắt đầu bằng BE thuộc tòa nhà Beta. VD: BE,..</p>
                <p>Các phòng bắt đầu bằng G thuộc tòa nhà Gamma. VD: G201,...</p>
                <p>Các phòng tập bằng đầu bằng R thuộc khu vực sân tập Vovinam.</p>
                <p>Các phòng bắt đầu bằng DE thuộc tòa nhà Delta. VD: DE,..</p>
                <p>Little UK (LUK) thuộc tầng 5 tòa nhà Delta</p>
                    
            </div>
    
    <style>
            .b table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
            td {
                text-align: left;
                padding: 8px;
            }
            .b td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            .b th {
                background-color: rgb(124, 156, 190);
            } 
            .b tbody span {
                    padding: 2px;
                    color: white;
                    background-color: #0fcc45;
                    border-radius: 5px;
            }
        </style>
        <div class="b">
        <table>
            <thead>
                <tr>

                    <th rowspan="2">
                        <form action="timetable" method="GET">
                            <input type="hidden" name="lid" value="${param.lid}"/>
                            <c:forEach items="${requestScope.dates}" var="d">
                            Year: ${d}<br/>${helper.getYear(d)}<br/>
                            From: <input type="date" name="from" value="${requestScope.from}"/>
                            To: <input type="date" name="to" value="${requestScope.to}"/>  
                            </c:forEach>
                        </form>
                    </th>

                    <th  align='center'>Mon</th>
                    <th  align='center'>Tue</th>
                    <th  align='center'>Wed</th>
                    <th  align='center'>Thu</th>
                    <th  align='center'>Fri</th>
                    <th  align='center'>Sat</th>
                    <th  align='center'>Sun</th>
                </tr>
                <tr>
                    <th  align='center'>10/10</th>
                    <th  align='center'>11/10</th>
                    <th  align='center'>12/10</th>
                    <th  align='center'>13/10</th>
                    <th  align='center'>14/10</th>
                    <th  align='center'>15/10</th>
                    <th  align='center'>16/10</th>

                </tr>
            </thead>
            <tbody>
            
                <tr>
                    <td>Slot 1 </td>
                    <td>
                        <a href=""> IOT102</a>
                        <p>at DE-311</p>
                        <p>(<font color="green">attended</font>)</p>
                        <p> <span>(7:30-9:10)</span></p>
                       
                        
                    </td>
                    <td>-</td>
                    <td>
                         <a href=""> IOT102</a>
                        <p>at DE-311</p>
                        <p>(<font color="red">absent</font>)</p>
                        <p> <span>(7:30-9:10)</span> </p>
                    </td>
                    <td>-</td>
                    <td>
                         <a href=""> IOT102</a>
                        <p>at DE-311</p>
                        <p>(<font color="red">not yet</font>)</p>
                        <p> <span>(7:30-9:10)</span> </p>
                    </td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td>Slot 2 </td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td>Slot 3 </td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td>Slot 4 </td>
                    <td>-</td>
                    <td>
                         <a href=""> PRJ301</a>
                        <p>at DE-203</p>
                        <p>(<font color="red">absent</font>)</p>
                        <p> <span>(12:50-14:10)</span> </p>
                    </td>
                    <td>-</td>
                    <td>
                        <a href=""> PRJ301</a>
                        <p>at DE-203</p>
                        <p>(<font color="red">not yet</font>)</p>
                        <p> <span>(12:50-14:10)</span> </p>
                    </td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td>Slot 5 </td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td>Slot 6 </td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td>Slot 7 </td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td>Slot 8 </td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
            </tbody>    
        </table>
            <div class="c">
                    <b>More note / Chú thích thêm</b>:
                    <ul>
                        <li>
                            (<font color="green">attended</font>):
                            username had attended this activity / username đã tham gia hoạt động này.
                        </li>
                        <li>
                            (<font color="red">absent</font>):
                            username had NOT attended this activity / username đã vắng mặt buổi này.
                        </li>
                        <li>
                            (-): no data was given / chưa có dữ liệu.
                        </li>
                    </ul>
                
            </div>
            <div>
                <b>Mọi góp ý, thắc mắc xin liên hệ</b>:
                <span>Phòng dịch vụ sinh viên:</span> Email:
                <a href="">dichvusinhvien@fe.edu.vn</a>.
                <span> Điện thoại</span>: 09290133454
                
            </div>
    
            
    </div>
    </div>
        
    </body>
</html>
