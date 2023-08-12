<%@page import="com.rdschool.entity.UserEntity"%>
<%@page import="com.rdschool.dao.UserDao"%>

<%@page import="com.rdschool.entity.CourseEntity"%>
<%@page import="com.rdschool.dao.CourseDao"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User Acess</title>
<%@include file="../componet/allcss.jsp"%>
<link rel="stylesheet" href="../componet/style.css">
<%@page isELIgnored="false"%>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container-fluid p-3">
		<div class="row">

			<div class="col-md-5 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Add User Acess</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form action="../grantAccess" method="post" enctype="multipart/form-data">
							<div class="mb-3">
								<label class="form-label">User Email</label> <select
									name="email" id="category" size="1" required
									class="form-control">
									<option>--select--</option>

									<%
									UserDao dao = new UserDao();
									List<UserEntity> list = dao.getAllUser();
									for (UserEntity s : list) {
									%>
									<option><%=s.getEmail()%></option>
									<%
									}
									%>


								</select>
							</div>


							<div class="mb-3">
								<label class="form-label">Course Name</label> <select
									name="courseName" id="category" size="1" required
									class="form-control">
									<option>--select--</option>

									<%
									CourseDao dao1 = new CourseDao();
									List<CourseEntity> list1 = dao1.getAllCourse();
									for (CourseEntity s : list1) {
									%>
									<option><%=s.getcoursename()%></option>
									<%
									}
									%>


								</select>
							</div>

							<div class="mb-3">
								<label class="form-label">Coourse Image</label> <input
									type="file" required name="image" class="form-control">
							</div>


							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>



		</div>
	</div>
</body>
</html>