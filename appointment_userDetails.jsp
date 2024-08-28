<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.DoctorDao"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.entity.Doctor"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Appointment</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}
body{

background-image: linear-gradient(
      to right,
      rgba(18, 172, 141, 0.39),
      rgba(18, 172, 141, 0.37)
    ),
    url('img/f.jpg');
background-size: cover;
}
.card {
background-color: #e9f3f75e;
}
.p-3{
padding:4rem !important;
color:#FFD43B;
}
.p-4{
color:#ffffff;
}
<%--.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/hospital.jpg");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}--%>
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<%-- <div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>--%>
	<div class="container p-2">
		<div class="row">
			<div class="col-md-5 p-3">
				<h1>Providing an Exceptional Patient Experience</h1>
          <h5 class="col-md-10 p-4">
            Welcome, with compassionate care, and a patient-centered approach, we're dedicated to your well-being. Trust
            us with your health and experience the difference.
          </h5>
			</div>

			<div class="col-md-7">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3">User Appointment</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form class="row g-3" action="appAppointment" method="post"> 

							<input type="hidden" name="userid" value="${userObj.id }">

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Full Name</label> <input
									type="text" class="form-control" readonly required name="fullname" value="${userObj.fullName }">
							</div>
							
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Email</label> <input
									type="email" class="form-control" readonly required name="email" value="${userObj.email }">
							</div>
							
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Phone No</label> <input
									maxlength="10" required type="number" class="form-control" name="phno">
							</div>
							
							<div class="col-md-6 p-2">
								<label>Gender</label> <select class="form-control" name="gender"
									required>
									<option>--select--</option>
									<option>Male</option>
									<option>Female</option>
									<option>Other</option>
									<option>Not yet to disclose</option>
								</select>
							</div>
							
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Age</label> <input
								maxlength="3" required type="number" class="form-control" name="age">
							</div>					
							
							<div class="col-md-6 p-2">
								<label>Address Pincode</label>
								<input required name="upc" class="form-control"
								maxlength="6" placeholder="Provide Your Address Pincode"></input>
							</div>
							
							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Doctor List</label>
								 <select required class="form-control" name="docName">
									<option>--select--</option>
									
									<%
									DoctorDao dao1 = new DoctorDao(DBConnect.getConn());
									List<Doctor> list1 = dao1.getAllDoctor();
									for (Doctor d : list1) {
									%>
									<option><%=d.getFull_name()%></option>
					 				<%
									}
									%>

								</select>
							</div>
								

						 	<c:if test="${empty userObj }">
								<a href="user_login.jsp" class="col-md-6 offset-md-3 btn btn-success">Next</a>
							</c:if>

							<c:if test="${not empty userObj }">
								<button class="col-md-6 offset-md-3 btn btn-success">Next</button>
							</c:if>	
							
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@include file="component/footer.jsp"%>

</body>
</html>