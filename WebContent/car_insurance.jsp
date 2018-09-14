<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>PolicyMaster.com</title>
<!-- metatags-->
<meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">
<link href="img/p.jpg" rel="icon">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Montserrat:300,400,500,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Josefin+Sans:100,300,400,600,700" rel="stylesheet">
<!--online_fonts-->
<link href="//fonts.googleapis.com/css?family=Lato" rel="stylesheet"><!--online_fonts-->

<!-- Bootstrap CSS File -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Libraries CSS Files -->
  <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">

<!-- Meta tag Keywords -->
  <link href="css/style.css" rel="stylesheet">
<link href="css/style1.css" rel="stylesheet" type="text/css" media="all"/><!--style_sheet-->

<style>
body{
	background-image:url(img/motor.jpg);
}
</style>

</head>
<body>

  <!--==========================
    Header
  ============================-->
  <header id="header">
    <div class="container-fluid">

      <div id="logo" class="pull-left">
        <a href="index.jsp"><img src="img/pm3.png" alt="" title="" /></a>
      </div>

      <nav id="nav-menu-container">
        <ul class="nav-menu">
          <li class="menu-active"><a href="index.jsp">Home</a></li>
          <li class="menu-has-children"><a href="lifeinsurance.jsp">LIFE INSURANCE</a>
		<ul>
		<li><a href="#"></a></li>
              <li><a href="terminsurance.jsp">TERM INSURANCE</a></li>
              <li><a href="investmentplan.jsp">INVESTMENT INSURANCE</a></li>
		<li><a href="childplans.jsp">CHILD PLANS</a></li>
		<li><a href="pensionplans.jsp">PENSION PLANS</a></li>
		<li><a href="ulip.jsp">ULIPS</a></li>
		<li><a href="moneyback.jsp">MONEY BACK POLICY</a></li>
		<li><a href="endowment.jsp">ENDOWMENT POLICY</a></li>
		<li><a href="tax.jsp">INCOME TAX</a></li>
	</ul>
          </li>
          <li class="menu-has-children"><a href="healthinsurance.jsp">HEALTH INSURANCE</a>
		<ul>
		<li><a href="#"></a></li>
              <li><a href="healthplans.jsp">HEALTH PLANS</a></li>
              <li><a href="familyhealthplans.jsp">FAMILY HEALTH PLANS</a></li>
		<li><a href="seniorcitizen.jsp">SENIOR CITIZEN HEALTH INSURANCE</a></li>
		<li><a href="criticalillness.jsp">CRITICAL ILLNESS</a></li>
		<li><a href="mediclaim.jsp">MEDICLAIM POLICY</a></li>
		</ul>
          </li>
          <li class="menu-has-children"><a href="motorinsurance.jsp">MOTOR INSURANCE</a>
		<ul>
		<li><a href="#"></a></li>
              <li><a href="car_insurance.jsp">CAR INSURANCE</a></li>
              <li><a href="bike_insurance.jsp">BIKE INSURANCE</a></li>
		<li><a href="car_insurance.jsp">THIRD PARTY INSURANCE</a></li>
		</ul>
          </li>
		<li class="menu-has-children"><a href="otherinsurance.jsp">OTHER INSURANCE</a>
            <ul>
              <li><a href="#"></a></li>
              <li><a href="generalinsurance.jsp">GENERAL INSURANCE</a></li>
              <li><a href="groupmediclaim.jsp">GROUP MEDICLAIM INSURANCE</a></li>
              <li><a href="corporate.jsp">CORPORATE INSURANCE</a></li>
              <li><a href="#travel.jsp">TRAVEL INSURANCE</a></li>
              <li><a href="#homeinsurance.jsp">HOME INSURANCE</a></li>
              <li><a href="personalaccident.jsp">PERSONAL ACCIDENT INSURANCE</a></li>
              <li><a href="cancer.jsp">CANCER INSURANCE</a></li>
            </ul>
          </li>
        <!--  <li><a href="#team.html">CONTACT</a></li> -->
          <li><a href="login.jsp">LOGIN</a></li>
		<li><a href="#contact.html">ADMIN</a></li>
        </ul>
      </nav><!-- #nav-menu-container -->
    </div>
  </header><!-- #header -->

<section id="">
<h1>CAR INSURANCE</h1>
<div class="w3ls-main">
<!-- <p>Complete the form below to sign up for our membership service.</p> -->
<div class="w3ls-form">
<form action="Servlet1" method="post">
<ul class="fields">
<div class="Refer_w3l">
<h3>&nbsp;&nbsp;&nbsp;&nbsp;Get Free Quotes From Top Insurers</h3><br>
		
		<div class="w3ls-name">	
			<div id="regno"><i class="fa fa-car iconpos "></i> &nbsp;Reg. No.</div>
			<input type="text" name="RegNo" id="cartextbox" placeholder="E.G.: DL01AB1234" pattern="^[a-z|A-Z]{2}[0-9]{1,2}[a-z|A-Z]{1,2}[0-9]{1,4}$" required=" "/>
		</div>
	<div class="w3ls-btn">
		<input type="submit" value="Compare & Save Big">
	</div><br><br>
								<div class="dontKnow dontKnow2" id="line">
                                  "Compare plans from 15+ insurers & save up to 60%"
                                </div>
                                </div>
                                </ul>
</form>
</div>
</div>
</div>
</section>
<footer>&copy; Copyright <strong>PolicyMaster.com</strong>. All Rights Reserved.</footer> 
</body>
</html>