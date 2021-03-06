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
  <link href="css/style1.css" rel="stylesheet">
  <link href="css/style9.css" rel="stylesheet" type="text/css" media="all"/><!--style_sheet-->
<style>
body{
	background-image:url(img/bike.jpg);
}

</style>
</head>
<body>
<header id="header">
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
<br>

<section id>
<div class="group">
<form action="Servlet1" method="post">
<div class="sub-group">
<h2><span class="label success">Select a Manufacturer</span></h2><br>
      <div class="row">
        <div class="col-lg-12">
          <p>
            <button type="submit" class="btn btn-sq-lg btn-primary" name="manufacturer2" value="honda">
                <img vspace="20" src="img/v/hondabike.jpg"/></i><br>
                HONDA
             </button>
             <button type="submit" class="btn btn-sq-lg btn-success" name="manufacturer2" value="bajaj">
              <img vspace="20" src="img/v/bajaj.jpg"/></i><br>
                BAJAJ
            </button>
            <button type="submit" class="btn btn-sq-lg btn-info" name="manufacturer2" value="herohonda">
              <img vspace="20" src="img/v/herohonda.jpg"/></i><br>
                HERO HONDA
            </button>
            <button type="submit" class="btn btn-sq-lg btn-danger" name="manufacturer2" value="yamaha">
              <img vspace="23" src="img/v/yamaha.jpg"/></i><br>
                YAMAHA
            </button>
            </a>
          </p>
        </div>
	</div><br>
	<div class="row">
        <div class="col-lg-12">
          <p>
          
          <button type="submit" class="btn btn-sq-lg btn-primary" name="manufacturer2" value="tvs">
              <img vspace="18" src="img/v/tvs.jpg"/></i><br>
                TVS
            </button>
            <button type="submit" class="btn btn-sq-lg btn-success" name="manufacturer2" value="hero">
              <img vspace="22" src="img/v/heromotocrop.jpg"/></i><br>
                HERO
            </button>
            <button type="submit" class="btn btn-sq-lg btn-info" name="manufacturer2" value="royalenfield">
              <img vspace="22" src="img/v/royal.jpg"/></i><br>
                ROYAL<br>ENFIELD
            </button>
            <button type="submit" class="btn btn-sq-lg btn-danger" name="manufacturer2" value="ktm">
              <img vspace="18" src="img/v/ktm.jpg"/></i><br>
                KTM
           </button>            
          </p>
        </div>
	</div><br>
	<div class="row">
        <div class="col-lg-12">
          <p>
            <button type="submit" class="btn btn-sq-lg btn-primary" name="manufacturer2" value="suzuki">
              <img vspace="22" src="img/v/suzuki.jpg"/></i><br>
                SUZUKI
            </button>
                        <button type="submit" class="btn btn-sq-lg btn-success" name="manufacturer2" value="harleydevidson">
              <img vspace="20" src="img/v/harley.jpg"/></i><br>
                HARLEY<br>DEVIDSON
            </button>
            <button type="submit" class="btn btn-sq-lg btn-info" name="manufacturer2" value="lml">
              <img vspace="23" src="img/v/lml.jpg"/></i><br>
                LML
            </button>
            <button type="submit" class="btn btn-sq-lg btn-danger" name="manufacturer2" value="mahindra">
              <img vspace="22" src="img/v/mahindra.jpg"/></i><br>
                MAHINDRA
            </button>
          </p>
        </div>
	</div>
</div><br>
</form>
	<button class="button button2">Others</button><br>
</div>
</section>
 <!--==========================
    Footer
  ============================-->
<footer>&copy; Copyright <strong>PolicyMaster.com</strong>. All Rights Reserved.</footer> 
  <!-- Contact Form JavaScript File -->
  <script src="contactform/contactform.js"></script>

<script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Template Main Javascript File -->
  <script src="js/main.js"></script>
 



 
</body>
</html>