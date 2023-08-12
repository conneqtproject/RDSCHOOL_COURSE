<%@page import="com.rdschool.entity.UserEntity"%>
<%@page import="com.rdschool.dao.UserDao"%>



<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	    <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Customer</title>
<%@include file="../componet/allcss.jsp"%>
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


			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Customer Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Phone No</th>
									<th scope="col">Email</th>
									<th scope="col">Password</th>
									<th scope="col">Full Address</th>
									<th scope="col">Action</th>
									
								</tr>
							</thead>
							<tbody>
								<%
								UserDao dao2 = new UserDao();
								List<UserEntity> list2 = dao2.getAllUser();
								for (UserEntity c : list2) {
								%>
								<tr>
									<td><%=c.getFullname()%></td>
									<td><%=c.getGender()%></td>
									<td><%=c.getAge()%></td>
									<td><%=c.getPhno()%></td>
									<td><%=c.getEmail()%></td>
									<td><%=c.getPassword()%></td>
									<td><%=c.getAddress()%></td>
									<td><a href="edit_user.jsp?id=<%=c.getId()%>"
										class="btn btn-sm btn-primary">Edit</a> <a href="../deleteUser?id=<%=c.getId()%>"
										class="btn btn-sm btn-danger">Delete</a></td>
								</tr>
								<%
								}
								%>



							</tbody>
						</table>

					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>