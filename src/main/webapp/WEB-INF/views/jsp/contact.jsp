<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Pradiota</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Infirmary Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery-ui.css" />
<link href="<%=request.getContextPath()%>/resources/css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/numscroller-1.0.js"></script>

<!-- //js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap-3.1.1.min.js"></script>

<!-- fonts -->
<link href='//fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Viga' rel='stylesheet' type='text/css'>

	<!-- start-smoth-scrolling -->
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/move-top.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/easing.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
		</script>
	<!-- start-smoth-scrolling -->

	<script src="<%=request.getContextPath()%>/resources/js/responsiveslides.min.js"></script>
</head>
<body>
<!-- header -->
<div class="header wow zoomIn">
	<div class="container">
		<div class="header_left" data-wow-duration="2s" data-wow-delay="0.5s">
			<ul>
				<li><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span></li>
			</ul>
		</div>
		<div class="header_right">
			<div class="login">
				<ul>
					<li><a href="#" data-toggle="modal" ><span class="glyphicon glyphicon-user" aria-hidden="true"></span>${userName}</a></li>
					<li><a href="logout"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>Logout</a></li>
					<li>
						<div class="search-bar">
							<div class="search">		
								<a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i> </a>
							</div>
							<script src="<%=request.getContextPath()%>/resources/js/jquery.magnific-popup.js" type="text/javascript"></script>
								<div id="small-dialog" class="mfp-hide">
									<div class="search-top">
										<div class="login_pop">
											<form action="#" method="post">
												<input type="submit" value="">
												<input type="text" name="Type something..." value="Type something..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
											</form>
										</div>				
									</div>
									<script>
												$(document).ready(function() {
												$('.popup-with-zoom-anim').magnificPopup({
													type: 'inline',
													fixedContentPos: false,
													fixedBgPos: true,
													overflowY: 'auto',
													closeBtnInside: true,
													preloader: false,
													midClick: true,
													removalDelay: 300,
													mainClass: 'my-mfp-zoom-in'
												});
																												
												});
									</script>				
								</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!-- //header -->
<div class="header-bottom">
		<div class="container">
			<nav class="navbar navbar-default">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
				  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
					<div class="logo grid">
						<div class="grid__item color-3">
							<h1><a class="link link--nukun" href="index.html"><i></i>Den<span>t</span>al verification portal</a> </h1>
						</div>
					</div>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse nav-wil links" id="bs-example-navbar-collapse-1">
					<nav class="menu menu--horatio">
						<ul class="nav navbar-nav menu__list">
							<li class="menu__item "><a href="index.html" class="menu__link">Details Page</a></li>
						</ul>
					</nav>
				</div>
				<!-- /.navbar-collapse -->
			</nav>
		</div>
	</div>
<div class="map_contact banner page_head">
	<div class="container">	
		<h3 class="tittle">Insurance search </h3>

		<div class="contact-grids">
			
			<div class="col-md-6 contact-grid ">
				<form action="searchPatient" method="post">
		            <input type="text" name="patientName" value="${patientDetails.patientName}" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Patient Name';}" placeholder="Patient Name" required="">
					<input type="text" name="insuranceCompany" value="${patientDetails.insuranceCompany}" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Insurance Company';}" placeholder="Insurance Company" required="">
					<input type="submit" value="Submit" >
			     </form>
			</div>
			
			<div class="col-md-6 contact-grid"  style="margin-left: -183px;">  
				<form action="exportDocument" method="post">
						<table>
							<tr>
								<td><span class="textStyle">PayerID:</span></td>
								<td><input type="text" name="payerID" value="${patientDetails.payerID}" required=""></td>
							</tr>
							<tr>
								<td><span class="textStyle">File Medical First:</span></td>
								<td><input type="text" name="fileMedicalFirst" value="${patientDetails.fileMedicalFirst}"  required=""></td>
							</tr>
							<tr>
								<td><span class="textStyle">Effective Date:</span></td>
								<td><input  type="text" name="effectiveDate" value="${patientDetails.effectiveDate}" required=""></td>
							</tr>
							<tr>
								<td><span class="textStyle">Runs On:</span></td>
								<td><input type="text" name="runsOn" value="${patientDetails.runsOn}" required=""></td>
							</tr>
							<tr>
								<td><span class="textStyle">Type Of Coverage:</span></td>
								<td><input type="text" name="typeOfCoverage" value="${patientDetails.typeOfCoverage}" required=""></td>
							</tr>
							<tr>
								<td><span class="textStyle">In Or Out Network:</span></td>
								<td><input type="text" name="inOrOutNetwork" value="${patientDetails.inOrOutNetwork}"  required=""></td>
							</tr>
							<tr>
								<td><span class="textStyle">Plan Has PPO or Premier Coverage:</span></td>
								<td><input type="text" name="plan" value="${patientDetails.plan}" required=""></td>
							</tr>
							<tr>
								<td><span class="textStyle">Coordination of Benefits:</span></td>
								<td><input type="text" name="coordination" value="${patientDetails.coordination}" required=""></td>
							</tr>
							<tr>
								<td><span class="textStyle">Plan Follows UCR/Fee Schedule:</span></td>
								<td><input type="text" name="planFollows" value="${patientDetails.planFollows}" required=""></td>
							</tr>
						</table>
	
				    <input type="submit" value="Export to Ms word/doc" >
				    <input type="hidden" name="patientName" value="${patientDetails.patientName}" >
					<input type="hidden" name="insuranceCompany" value="${patientDetails.insuranceCompany}" >
				</form>
			</div>						
			<div class="clearfix"> </div>
		</div>

	</div>
</div>
<!-- //contact -->
<!-- contact -->
<div class="contact">
	<div class="container">		
		<div class="col-md-9 contact-right wow fadeIn animated animated" data-wow-delay="0.1s" data-wow-duration="2s">
			<h3>Pradiota IT Solutions</h3>
		</div>
	</div>
</div>
<!-- //contact -->

</body>
</html>