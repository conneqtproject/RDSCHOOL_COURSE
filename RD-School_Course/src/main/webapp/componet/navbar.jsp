<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>




<div class="container-fluid"
	style="height: 10px; background-color: #303f9f"></div>


<div class="container-fluid p-3">
	<div class="row">
		<div class="col-md-4 text-success ">
			<h1>
				<i class="fa-solid fa-business-time"></i> RD School
			</h1>
		</div>
		<div class="col-md-5 ">
			<form class="form-inline my-2 my-lg-0" action="search.jsp" method="post">
				<input class="form-control mr-sm-2" type="search" name="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
		<div class="col-md-3">
			<c:if test="${not empty userObj}">
				<div class="dropdown">
					<button class="btn btn-success dropdown-toggle" type="button"
						id="dropdownMenuButton1" data-bs-toggle="dropdown"
						aria-expanded="false">
						<i class="fa-solid fa-circle-user"></i> ${userObj.fullname }
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						<li><a class="dropdown-item" href="change_password.jsp">Change
								Password</a></li>
						<li><a class="dropdown-item" href="cLogout">Logout</a></li>
					</ul>

					


				</div>
			</c:if>
			<c:if test="${empty userObj}">
				<div class="dropdown">
					<a href="admin_login.jsp" class="btn btn-primary"><i
						class="fa-solid fa-right-to-bracket"></i> Login</a>&nbsp
					<a href="signup.jsp" class="btn btn-success"><i
						class="fa-solid fa-user-plus"></i> Register</a>
				</div>



			</c:if> </br>
			<a href="https://chat.whatsapp.com/GvTqRZpogGh7wzLOwPVJfv"><i class="fab fa-whatsapp fa-2x" style="color: #25d366;"></i></a>&nbsp
			<a href="https://chat.whatsapp.com/GvTqRZpogGh7wzLOwPVJfv"><i class="fab fa-instagram fa-2x" style="color: #ac2bac;"></i></a>&nbsp
			<a href="https://chat.whatsapp.com/GvTqRZpogGh7wzLOwPVJfv"><i class="fab fa-facebook-f fa-2x" style="color: #3b5998;"></i></a>&nbsp
			<a href="https://chat.whatsapp.com/GvTqRZpogGh7wzLOwPVJfv"><i class="fab fa-linkedin-in fa-2x" style="color: #0082ca;"></i></a>&nbsp
			<a href="https://chat.whatsapp.com/GvTqRZpogGh7wzLOwPVJfv"><i class="fab fa-google fa-2x" style="color: #dd4b39;"></i></a>&nbsp
			<a href="https://chat.whatsapp.com/GvTqRZpogGh7wzLOwPVJfv"><i class="fab fa-twitter fa-2x" style="color: #55acee;"></i></a>&nbsp
			
			<a href="https://chat.whatsapp.com/GvTqRZpogGh7wzLOwPVJfv"><i class="fab fa-youtube fa-2x" style="color: #ed302f;"></i></a>
		</div>
		
	</div>
</div>







<nav class="navbar navbar-expand-lg navbar-dark bg-custom ">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp"><i
					class="fas fa-home"></i> DashBoard <span class="sr-only">(current)</span></a>
			</li>
					&nbsp&nbsp&nbsp
					<li class="nav-item active"><c:if test="${not empty userObj }">
			<a href="usercourse?email=${userObj.email }" class="nav-link"><i class="far fa-file-alt"></i> My Courses</a>
	

		</c:if></li>

		</ul>
		

		<a href="contactus.jsp" class="btn btn-light">	<i class="fa-solid fa-phone"></i> Contact Us</a>
		
		&nbsp<a href="https://chat.whatsapp.com/GvTqRZpogGh7wzLOwPVJfv" class="btn btn-light "><i class="fab fa-whatsapp" style="color: #25d366;"></i>Whatsapp</a>&nbsp

		
	</div>
</nav>