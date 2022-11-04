<%-- 
    Document   : login
    Created on : Nov 4, 2022, 8:04:53 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/CustomTag.tld" prefix="t"%>
<a href="WEB-INF/tlds/CustomTag.tld"></a>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>


            body {
                background-image: linear-gradient( 135deg, #FAB2FF 10%, #1904E5 100%);
                background-size: cover;
                background-repeat: no-repeat;
                background-attachment: fixed;
            }


            .form-bg{
                background: linear-gradient( 135deg, #FAB2FF 10%, #1904E5 100%);
            }
            .form-horizontal{
                background: #fff;
                padding-bottom: 40px;
                margin-left: 150px;
                margin-right: 150px;
                border-radius: 15px;
                text-align: center;
            }
            .form-horizontal .heading{
                display: block;
                font-size: 35px;
                font-weight: 700;
                padding: 35px 0;
                border-bottom: 1px solid #f0f0f0;
                margin-bottom: 30px;
            }
            .form-horizontal .form-group{
                padding: 0 40px;
                margin: 0 0 25px 0;
                position: relative;
            }
            .form-horizontal .form-control{
                background: #f0f0f0;
                border: none;
                border-radius: 20px;
                box-shadow: none;
                padding: 0 20px 0 45px;
                height: 40px;
                transition: all 0.3s ease 0s;
            }
            .form-horizontal .form-control:focus{
                background: #e0e0e0;
                box-shadow: none;
                outline: 0 none;
            }
            .form-horizontal .form-group i{
                position: absolute;
                top: 12px;
                left: 60px;
                font-size: 17px;
                color: #c8c8c8;
                transition : all 0.5s ease 0s;
            }
            .form-horizontal .form-control:focus + i{
                color: #00b4ef;
            }
            .form-horizontal .fa-question-circle{
                display: inline-block;
                position: absolute;
                top: 12px;
                right: 60px;
                font-size: 20px;
                color: #808080;
                transition: all 0.5s ease 0s;
            }
            .form-horizontal .fa-question-circle:hover{
                color: #000;
            }
            .form-horizontal .main-checkbox{
                float: left;
                width: 20px;
                height: 20px;
                background: #11a3fc;
                border-radius: 50%;
                position: relative;
                margin: 5px 0 0 5px;
                border: 1px solid #11a3fc;
            }
            .form-horizontal .main-checkbox label{
                width: 20px;
                height: 20px;
                position: absolute;
                top: 0;
                left: 0;
                cursor: pointer;
            }
            .form-horizontal .main-checkbox label:after{
                content: "";
                width: 10px;
                height: 5px;
                position: absolute;
                top: 5px;
                left: 4px;
                border: 3px solid #fff;
                border-top: none;
                border-right: none;
                background: transparent;
                opacity: 0;
                -webkit-transform: rotate(-45deg);
                transform: rotate(-45deg);
            }
            .form-horizontal .main-checkbox input[type=checkbox]{
                visibility: hidden;
            }
            .form-horizontal .main-checkbox input[type=checkbox]:checked + label:after{
                opacity: 1;
            }
            .form-horizontal .text{
                float: left;
                margin-left: 7px;
                line-height: 20px;
                padding-top: 5px;
                text-transform: capitalize;
            }
            .form-horizontal .btn{
                float: right;
                font-size: 14px;
                color: #fff;
                background: #00b4ef;
                border-radius: 30px;
                padding: 10px 25px;
                border: none;
                text-transform: capitalize;
                transition: all 0.5s ease 0s;
            }
            @media only screen and (max-width: 479px){
                .form-horizontal .form-group{
                    padding: 0 25px;
                }
                .form-horizontal .form-group i{
                    left: 45px;
                }
                .form-horizontal .btn{
                    padding: 10px 20px;
                }
            }
        </style>
    </head>
    <body>
        

        <div class="form-bg">
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-3 col-md-6">
                        
                        <form class="form-horizontal" action="login" method="POST" >
                            <span class="heading">Log In</span>
                            <p><font color="red">${requestScope.error}</font></p>
                            <font color="green"><t:LoginTag/></font>
                            
                            <div class="form-group">
                                <input type="text" class="form-control" id="inputEmail3" name="user" value="${cookie.user.value}" placeholder="Username">
                                <i class="fa fa-user"></i>
                                ${requestScope.usermess}
                                
                            </div>
                            <div class="form-group help">
                                <input type="password" class="form-control" id="inputPassword3" name="pass" value="${cookie.pass.value}" placeholder="Password">
                                <i class="fa fa-lock"></i>
                                <a href="#" class="fa fa-question-circle"></a>
                                ${requestScope.passmess}
                            </div>
                            <div class="form-group">
                                <div class="main-checkbox">
                                    <input type="checkbox"${(cookie.remember.value eq 'ON')?"checked":""} value="ON" id="checkbox1" name="remember">
                                    <label for="checkbox1"></label>
                                </div>
                                <span class="text">Remember me</span>
                                <button type="submit" class="btn btn-default" id="myBtn">log in</button>
                            </div>
                        </form>
                        <script>
                            document.getElementById("myBtn").addEventListener("click",myFunction);

                            function myFunction() {
                                alert("Are you sure?");
                            }
                        </script>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
