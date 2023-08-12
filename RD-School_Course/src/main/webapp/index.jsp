<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<title>Rd Solution Dashboard</title>
<%@include file="componet/allcss.jsp"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="componet/style.css">
<style>

/* Full height image header */
.bgimg-1 {
	margin-top: 20px;
	background-position: center;
	background-size: cover;
	background-image: url("img/ecom1.jfif");
	height: 50vh;
	width: 100%;
	background-repeat: no-repeat; 
}

body {
	background-color: #eee
}

.mt-100 {
	margin-top: 80px;
}

.card {
	border-radius: 10px !important;
	border-color: #e1e7ec;
	position: relative;
	height: 490px;
}

.mb-30 {
	margin-bottom: 30px !important;
}

.card-img-tiles {
	display: block;
	border-bottom: 1px solid #e1e7ec;
}

a {
	color: #0da9ef;
	text-decoration: none !important;
}

.card-img-tiles>.inner {
	display: table;
	width: 100%;
}

.card-img-tiles .main-img, .card-img-tiles .thumblist {
	position: relative;
	display: table-cell;
	width: 65%;
	padding: 10px;
	vertical-align: middle;
	position: relative;
}

.card-img-tiles .main-img>img:last-child, .card-img-tiles .thumblist>img:last-child
	{
	margin-bottom: 0;
}

.card-img-tiles .main-img>img, .card-img-tiles .thumblist>img {
	display: block;
	width: 100%;
	margin-bottom: 6px;
}

.thumblist {
	width: 35%;
	border-left: 1px solid #e1e7ec !important;
	display: table-cell;
	width: 65%;
	padding: 15px;
	vertical-align: middle;
	position: relative;
}

.card-img-tiles .thumblist>img {
	display: block;
	width: 100%;
	margin-bottom: 6px;
}

.btn-group-sm>.btn, .btn-sm {
	padding: .45rem .5rem !important;
	font-size: .875rem;
	line-height: 1.5;
	border-radius: .2rem;
}
</style>
</head>
<body>
	<%@include file="componet/navbar.jsp"%>

	

	<div class="container mt-100">



<!-- Fashion -->
		<div class="row">
			<div class="col-md-4 col-sm-6">
				<div class="card mb-30">
					<a class="card-img-tiles" href="#" data-abc="true">
						<div class="inner">
							<div class="main-img">
								<img src="img/CoreJava.jpg" alt="Category">
							</div>
							
						</div>
					</a>
					<h2 class="card-title"  align="center">Core Java</h2><br>
					<div class="card-body">
					<h5 class="card-title" align="left">Duration: 3 Months</h5>
					<h5 class="card-title" align="left"> <i class="fa fa-rupee"></i> 3000</h5>
				<h6 class="card-title" align="right"><a class="btn btn-outline-primary btn-sm"href="enroll.jsp" data-abc="true">Enroll Now</a></h6>
					</div>
				</div>
			</div>
			<!-- Mobile -->
			
			<div class="col-md-4 col-sm-6">
				<div class="card mb-30">
					<a class="card-img-tiles" href="#" data-abc="true">
						<div class="inner">
							<div class="main-img">
								<img src="img/Adv Java.jpg" alt="Category">
							</div>
						</div>
					</a>
					<h2 class="card-title"  align="center">Adv Java</h2><br>
					<div class="card-body">
					<h5 class="card-title" align="left">Duration: 3 Months</h5>
					<h5 class="card-title" align="left"> <i class="fa fa-rupee"></i> 3000</h5>
				<h6 class="card-title" align="right"><a class="btn btn-outline-primary btn-sm"href="enroll.jsp" data-abc="true">Enroll Now</a></h6>
					</div>
				</div>
			</div>
			
			<!-- Electronics -->
			
			<div class="col-md-4 col-sm-6">
				<div class="card mb-30">
					<a class="card-img-tiles" href="#" data-abc="true">
						<div class="inner">
							<div class="main-img">
								<img src="img/Hibernate with JPA.jpg" alt="Category">
							</div>
							
						</div>
					</a>
					<div class="card-body text-center">
						<h4 class="card-title">Hibernet with JPA</h4><br>
						
						<a class="btn btn-outline-primary btn-sm" href="enroll.jsp" data-abc="true">Enroll Now</a>
					</div>
				</div>
			</div>
			
			<!-- Electric -->
			
				<div class="col-md-4 col-sm-6">
				<div class="card mb-30">
					<a class="card-img-tiles" href="#" data-abc="true">
						<div class="inner">
							<div class="main-img">
								<img src="img/JavaR.jpg" alt="Category">
							</div>
							
						</div>
					</a>
					<div class="card-body text-center">
						<h4 class="card-title">Java Realtime Project</h4><br>
						
							<a class="btn btn-outline-primary btn-sm" href="enroll.jsp" data-abc="true">Enroll Now</a>
					</div>
				</div>
			</div>
			
			<!-- Home -->
			
				<div class="col-md-4 col-sm-6">
				<div class="card mb-30">
					<a class="card-img-tiles" href="#" data-abc="true">
						<div class="inner">
							<div class="main-img">
								<img src="img/Oracle SQL.jpg" alt="Category">
							</div>
						</div>
					</a>
					<div class="card-body text-center">
						<h4 class="card-title">Oracle Sql</h4><br>
						
						<a class="btn btn-outline-primary btn-sm" href="enroll.jsp" data-abc="true">Enroll Now</a>
					</div>
				</div>
			</div>
			
			<!-- Appliance -->
			<div class="col-md-4 col-sm-6">
				<div class="card mb-30">
					<a class="card-img-tiles" href="#" data-abc="true">
						<div class="inner">
							<div class="main-img">
								<img src="img/Py.jpg" alt="Category">
							</div>
							
						</div>
					</a>
					<div class="card-body text-center">
						<h4 class="card-title">Python Devlopment</h4><br>
						
						<a class="btn btn-outline-primary btn-sm" href="enroll.jsp" data-abc="true">Enroll Now</a>
					</div>
				</div>
			</div>
			<!-- Baby_Kids -->
			<div class="col-md-4 col-sm-6">
				<div class="card mb-30">
					<a class="card-img-tiles" href="#" data-abc="true">
						<div class="inner">
							<div class="main-img">
								<img src="img/sb.jpg" alt="Category">
							</div>
						</div>
					</a>
					<div class="card-body text-center">
						<h4 class="card-title">SpringBoot And Microservices</h4><br>
						
						<a class="btn btn-outline-primary btn-sm" href="enroll.jsp" data-abc="true">Enroll Now</a>
					</div>
				</div>
			</div>
			
			
			<!-- Beauty & More -->
			<div class="col-md-4 col-sm-6">
				<div class="card mb-30">
					<a class="card-img-tiles" href="#" data-abc="true">
						<div class="inner">
							<div class="main-img">
								<img src="img/Wd.jpg" alt="Category">
							</div>
							
						</div>
					</a>
					<div class="card-body text-center">
						<h4 class="card-title">Web Devpolement</h4><br>
						
						<a class="btn btn-outline-primary btn-sm" href="enroll.jsp" data-abc="true">Enroll Now</a>
					</div>
				</div>
			</div>
			
		
			
			
		</div>
	</div>





	<%@include file="componet/footer.jsp"%>
</body>
</html>