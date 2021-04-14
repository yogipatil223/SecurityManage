<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Security Login</title>
 <link href="angularcss/allOnePage.css" rel="stylesheet" />
         <link href="build/css/custom.css" rel="stylesheet" />
         <link href="build/css/custom.min.css" rel="stylesheet" />
         <link href="angularcss/bootstrap.min.css" rel="stylesheet" />

</head>
<body style="color: #428bca">
        <div class="container titleColor" align="center">
            <table>
                <tbody>
                    <tr>
                        <td>
<!--                            <img alt="" src="images/maha_shadow.png" width="110" height="110">-->
                        </td>
                        <td>
                            <div>
                                <h1>ManPower Management in Security System</h1>
                            </div>
                        </td>
                        <td>
<!--                            <img alt="" src="images/mahapolice.png" width="110" height="110">-->
                        </td>
                    </tr>                    
                </tbody>
            </table>
        </div>
        
        
        <div class="login_wrapper">
                <div class="animate form login_form">
                   
                    <section class="login_content">
                    
                        <form action="\login" method="post">
                            <h1 class="titleColor">Login Form</h1>
                            <div>
                                <input type="text" class="form-control" id="username" name="username" placeholder="Mobile number" required  autofocus autocomplete="off">
                            </div>
                            <div>
                                <input type="password" class="form-control" name="password" id="password" placeholder="Password" required autocomplete="off">
                            </div>
                             <div id="invalid">
                                <label style="color:red"><%=request.getAttribute("invalid") %></label>
                            </div>

                            <input type="Submit" name="Login" value="Login" class="btn btn-lg  btn-primary" >&nbsp;
                                <input type="reset" name="reset" class="btn btn-lg  btn-primary" value="Reset">
                        </form>
                       
                        <form action="\register" method="post" style="margin-left: 23px;">                                            
                       <span> <input type="Submit" style="border:none;background:white" name="register" value="No Account?  Register here"  /></span>                       
                        </form>
                       
                    </section>
                </div>

            </div>
        
        
                            <script>
                                
                                var invalida = document.getElementById("invalid").textContent;
                                console.log(invalida.trim()=="null");
                                if(invalida.trim()==="null"){
                                   document.getElementById("invalid").style.display="none";
                                }
                                
                            </script>                            
                            
    </body></html>