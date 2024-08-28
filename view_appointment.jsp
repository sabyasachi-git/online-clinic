<%@page import="com.entity.User"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
body{ 
	background-image: linear-gradient(
      to right,
      rgba(18, 103, 172, 0.74),
      rgba(18, 172, 141, 0.37)
    ),
 url('img/adm.jpg');
background-size: cover;
}
.card {
background-color: #e9f3f73d;
color: white;
font-weight: bold;
}
tr {
color: white;
text-align: center;
}
.paint-card {
		box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
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
	<c:if test="${empty userObj }">
		<c:redirect url="user_login.jsp"></c:redirect>
	</c:if>
	<%@include file="component/navbar.jsp"%>

	<%--<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>--%>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-2 fw-bold text-center">Appointment
							List</p>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Email</th>
									<th scope="col">Doctor Name</th>
									<th scope="col">Specialist</th>
									<th scope="col">Appointment Day</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Appointment Time</th>
									<th scope="col">Consultation fees</th>
									<th scope="col">LINK</th>
								</tr>
							</thead>
							<tbody>
								<%
								User user = (User) session.getAttribute("userObj");
								AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
								DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
								List<Appointment> list = dao.getAllAppointmentByLoginUser(user.getId());
								for (Appointment ap : list) {
									//Doctor d = dao2.getDoctorById(ap.getDoctorId());
								%>
								<tr>
									<th><%=ap.getUfullName()%></th>
									<td><%=ap.getUemail()%></td>
									<td><%=ap.getDocName()%></td>
									<td><%=ap.getDocSpec()%></td>
									<td><%=ap.getDocvDay()%></td>
									<td><%=ap.getUappointmentDate()%></td>
									<td><%=ap.getApptimeslot()%></td>
									<td><%=ap.getDocCons_fee()%></td>
									<td><%=ap.getApnLink()%></td>
									
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