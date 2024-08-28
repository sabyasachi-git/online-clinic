<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDao"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.entity.Appointment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Appointment Section</title>
<%@include file="../component/allcss.jsp"%>
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
color: #13099bec;
}
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

</style>
</head>
<body>
	<c:if test="${empty doctObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>


	<%@include file="navbar.jsp"%>
	<div class="container-fluid p-3">
		<div class="row">

			<div class="col-md-5 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Patient Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<%
								Doctor d = (Doctor) session.getAttribute("doctObj");
								AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
								//Appointment apn = dao.getAppointmentById(dao.);
								List<Appointment> list = dao.getAllAppointmentByDoctorLogin(d.getDid());
						%>
						<%								
							for (Appointment ap : list) {
						%>		
						<form action="../generateLink" method="post">
																			
						<div class="form-group"><label>Patient Name</label>
							<input class="form-control" readonly="readonly" name="pn" value="<%=ap.getUfullName()%>">
						</div>	
						
						<div class="form-group"><label>Patient's Email</label>
							<input class="form-control" readonly="readonly" name="pe" value="<%=ap.getUemail()%>">
						</div>					
						
						<div class="form-group"><label>Patient's Phone No</label>
							<input class="form-control" readonly="readonly" name="ppno" value="<%=ap.getUphNo()%>">
						</div>
						
						<div class="form-group"><label>Patient's Age</label>
							<input class="form-control" readonly="readonly" name="page"	value="<%=ap.getUage()%>">
						</div>	
						
						<div class="form-group"><label>Patient's Gender</label>
						<input class="form-control" readonly="readonly" name="pg" value="<%=ap.getUgender()%>">
						</div>
												
						<div class="form-group"><label>Doctor Name</label>
						<input class="form-control" readonly="readonly" name="docname" value="<%=ap.getDocName()%>">
						</div>
						
						<div class="form-group"><label>Appointment Day</label>
						<input class="form-control" readonly="readonly" name="paday" value="<%=ap.getDocvDay()%>">
						</div>
						
						<div class="form-group"><label>Appointment Date</label>
						<input class="form-control" readonly="readonly" name="padate" value="<%=ap.getUappointmentDate()%>">
						</div>
						
						<div class="form-group"><label>Appointment Time</label>
						<input class="form-control" readonly="readonly" name="paptime" value="<%=ap.getApptimeslot()%>">
						</div>
						
						<div class="form-group"><label>Appointment Link</label>
							<input class="form-control" required name="apn_link">
						</div>
						
						<input type="hidden" class="form-control" name="uid" value="<%=ap.getApnid()%>">
																						
						<div class="text-center mt-3">
							<button type="submit" class="btn btn-primary">Update</button>
						</div>
			
					</form>
					<%
					}
					%>
				</div>
			</div>
			</div>
		</div>
	</div>

</body>
</html>