<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        
        <script src="jscript/angular.min.js"></script>
        <script src="jscript/angucomplete-alt.min.js"></script>
        
        <script src="jscript/uiRouter.min.js"></script>
        <script src="jscript/onePage.js"></script>
         <script src="jscript/jquery-1.11.1.min.js"></script>
          <script src="jscript/bootstrap.min.js"></script>
        <script src="jscript/custom.js"></script>
        <script src="jscript/dashboard.js"></script>
        <script src="jscript/pdfmake.js"></script>
        <script src="jscript/htmltocanvas.js"></script>
     
          
<!--        <title>Chain Responsive Bootstrap3 Admin</title>-->

        <link href="angularcss/style.default.css" rel="stylesheet"/>
        <link href="angularcss/morris.css" rel="stylesheet"/>
        <link href="angularcss/select2.css" rel="stylesheet" />
        <link href="angularcss/allOnePage.css" rel="stylesheet" />

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body ng-app="myApp" onload = "sessionData()">
        
        <header>
            <div class="headerwrapper">
                <div class="header-left">
                    <a href="index-2.html" class="logo">
                        <img src="" alt="" /> 
                    </a>
                    <div class="pull-right">
                        <a href="#" class="menu-collapse">
                            <i class="fa fa-bars"></i>
                        </a>
                    </div> 
                </div><!-- header-left -->
                
                <div class="header-right" style="text-align: center">
                   <img alt="" src="images/maha_shadow.png" width="37" height="37">
                        <span class="mahaText">ManPower Management in Security System</span>                
                     <img alt="" src="images/mahapolice.png" width="37" height="37">
                    <div class="pull-right">
                        <form action="\logout" method="post">
                        <div class="btn-group btn-group-option">                           
                               <input class="btn" style="height:46px" type="submit" value="Sign Out">
                           
                        </div><!-- btn-group -->
                        </form>
                    </div>
                
            </div><!-- headerwrapper -->
        </header>
        
        <section>
            <div class="mainwrapper">
                <div class="leftpanel">
                    
                    
                    <h5 class="leftpanel-title"></h5>
                    <ul class="nav nav-pills nav-stacked">
                        <li id="guardManage" ui-sref="guardManagement()" class="cursor"><a><i class="fa fa-info-circle"></i> <span>Guard Management</span></a></li>
                         <li id="clientRequest" ui-sref="clientRequest()" class="cursor"><a><i class="fa fa-info-circle "></i> <span>Client's Requests </span></a></li>
                        <li id="siteManagement" ui-sref="siteManagement()" class="cursor"><a><i class="fa fa-info-circle"></i> <span>Site Management Report</span></a></li>
                         <li id="siteManagement" ui-sref="billDetail()" class="cursor"><a><i class="fa fa-info-circle"></i> <span>Bill Detail Report </span></a></li>
                          <li id="siteAddress" ui-sref="siteAddress()" class="cursor"><a><i class="fa fa-pencil"></i> <span>Send Request for Guards</span></a></li>
                           <li id="abc" ui-sref="imageupload()" class="cursor"><a><i class="fa fa-pencil"></i> <span>Image Upload</span></a></li>
                         
<!--		        <li ui-sref="vehicleExpenditure()" class="cursor"><a><i class="fa fa-pencil"></i> <span>Vehicle Expenditure</span></a></li>
					    <li ui-sref="expenditureReport()" class="cursor"><a><i class="fa fa-envelope-o"></i> <span>Expenditure Reports</span></a></li>-->
                                            
                    </ul>
                    
                </div>
                
                <div class="mainpanel">
                    
                    <div style="height:40px"></div> 
                    <div class="contentpanel">
                        
                        <ui-view></ui-view>
                        
                    </div>
                    
                </div>
            </div>
        </section>

    </body>
</html>
