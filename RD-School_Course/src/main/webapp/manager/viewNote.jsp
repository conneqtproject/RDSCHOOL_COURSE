

<%@page import="com.rdschool.entity.NoteEntity"%>
<%@page import="com.rdschool.dao.NoteDao"%>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Product</title>
<%@include file="../componet/allcss.jsp"%>
<link rel="stylesheet" href="../componet/style.css">
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

body
		{
		    counter-reset: Serial; 
	       
		}

		table
		{
		    border-collapse: separate;
		}

		tr td:first-child:before
		{
		  counter-increment: Serial;      
		  content: counter(Serial); 
		}
#myBtn {
  display: none;
  position: fixed;
  bottom: 20px;
  right: 30px;
  z-index: 99;
  font-size: 18px;
  border: none;
  outline: none;
  background-color: red;
  color: white;
  cursor: pointer;
  padding: 15px;
  border-radius: 4px;
}

#myBtn:hover {
  background-color: #555;
}

</style>

</head>
<body>
	<%@include file="navbar.jsp"%>

<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
	<div class="container-fluid p-3">
		<div class="row">


			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">All Note</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<table class="table">
							<thead class="bg-success text-white">
								<tr>
									<th scope="col">SL.No</th>
									<th scope="col">Course Name</th>
									<th scope="col">Note Name</th>
									<th scope="col">NotePath</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								NoteDao dao2 = new NoteDao();
								List<NoteEntity> list2 = dao2.getAllNote();
								for (NoteEntity n : list2) {
								%>
								<tr>
								<td></td>
									<td><%=n.getCoursename()%></td>
									<td><%=n.getNotename()%></td>
									<td><%=n.getNotepath()%></td>
									

									<td><a href="edit_product.jsp?id=<%=n.getId()%>"
										class="btn btn-sm btn-primary">Edit</a> <a
										href="../deleteProduct?id=<%=n.getId()%>"
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
	
<script>
// Get the button
let mybutton = document.getElementById("myBtn");

// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    mybutton.style.display = "block";
  } else {
    mybutton.style.display = "none";
  }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}
</script>
</body>
</html>