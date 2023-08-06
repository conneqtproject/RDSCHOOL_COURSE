<%@page import="com.rdschool.entity.CourseEntity"%>
<%@page import="com.rdschool.dao.CourseDao"%>
<%@page import="com.rdschool.entity.ManagerEntity"%>
<%@page import="com.rdschool.dao.ManagerDao"%>


<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Course</title>
<%@include file="../componet/allcss.jsp"%>
<%@page isELIgnored="false"%>
<link rel="stylesheet" href="../componet/style.css">
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

			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Course Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						CourseDao dao2 = new CourseDao();
						CourseEntity m = dao2.getCourseById(id);
						%>


						<form action="../updateCourse" method="post">
							<div class="mb-3">
								<label class="form-label">Course Name</label> <input type="text"
									required name="coursename" class="form-control"
									value="<%=m.getcoursename()%>">
							</div>

							
							<input type="hidden" name="id" value="<%=m.getId()%>">

							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>




		</div>
	</div>
</body>
</html>