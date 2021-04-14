<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
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
                    
                        <form action="\saveUser" enctype="multipart/form-data" method="post">
                            <h1 class="titleColor">Client Registration</h1>
                            <div>
                                <input type="text" class="form-control" id="username" name="username" placeholder="Client name" required  autofocus autocomplete="off">
                            </div>
                             <div>
                                <input type="text" class="form-control" id="mobilenum" name="mobilenum" placeholder="Mobile number" required  autofocus autocomplete="off">
                            </div>
                             <div>
                                <input type="text" class="form-control" id="email" name="email" placeholder="Email id" required  autofocus autocomplete="off">
                            </div>
                            <div>
                                <input type="password" class="form-control" name="password" id="password" placeholder="Password " required autocomplete="off">
                            </div>
                            <div >
                                <input type="hidden" class="form-control" name="role" id="role" value="client" required autocomplete="off">
                            </div>
                             <div>
                               <input type="file" id="mulfile" class="form-control" name="mulfile" >
                            </div>
                         
 						 <div style="text-align:center; ">
                            <input type="Submit" name="Register" style="margin-left: 123px;" value="Register" class="btn btn-lg  btn-primary" >
                            </div>   
                        </form>
                       
                       
                       
                    </section>
                </div>

            </div>
        
</body>
</html>