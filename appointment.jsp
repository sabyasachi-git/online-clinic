<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.dao.AppointmentDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="com.entity.TimeSlots"%>
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
    url('img/joy.jpg');
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

select{
 display: none;
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<%-- <div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>--%>
						<%--<c:if test="${not empty apn}">
							<p class="fs-4 text-center text-danger">${apn}</p>
							<c:remove var="apn" scope="session" /> 
						</c:if> 	
						<c:if test="${not empty apn}">
							<p class=" fs-4 text-center text-success">${apn.docName}</p>
							<c:remove var="apn" scope="session" />
						</c:if>		--%>
	<div class="container p-2">
		<div class="row">
			<div class="col-md-5 p-3">
				<h1>Providing an Exceptional Patient Experience</h1>
          <h5 class="col-md-10 p-4">
            Welcome, with compassionate care, and a patient-centered approach, we're dedicated to your well-being. Trust
            us with your health and experience the difference.
          </h5>
			</div>

			<div class="col-md-6 p-5">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3">User Appointment</p>
						<%
							HttpSession s1 = request.getSession();
							Appointment a = (Appointment) s1.getAttribute("apn");
							AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
							
							String dn = a.getDocName();											
							List<Doctor> list = dao.getDoctorByName(dn);
																    
						%>				
						
						<form class="row g-3" action="bookAppointment" method="post">		

				 		<input type="hidden" name="userid" value="<%=a.getUid()%>">
				 		<input type="hidden" name="fullname" value="<%=a.getUfullName()%>">
				 		<input type="hidden" name="email" value="<%=a.getUemail()%>">
				 		<input type="hidden" name="phno" value="<%=a.getUphNo()%>">
				 		<input type="hidden" name="gender" value="<%=a.getUgender()%>">
				 		<input type="hidden" name="age" value="<%=a.getUage()%>">
						<input type="hidden" name="upc" value="<%=a.getUadPincode()%>">	
						<input type="hidden" name="docName" value="<%=a.getDocName()%>">				
						<input type="hidden" class="form-control" name="did"	
								 
									<%								
									for (Doctor d : list) {
									%>
									value="<%=d.getDid()%>"
									<%
									}
									%>
							>		
									
									
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Specialist</label> 
								<select required class="form-control" name="spec">
									<option>--select--</option>
									
									<%									    
									for (Doctor d : list) {
									%>
									<option><%=d.getSpecialist()%> </option>
									<%
									}
									%>
								</select>								
									
							</div>
							
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Visiting Day</label>
								 <select required class="form-control" name="vd">	
								  <option>--select--</option>
									<%
									for (Doctor d : list) {
									%>
									<option><%=d.getVisiting_day()%> </option>
									<%
									}
									%>
								</select>																			
							</div>
							
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Appointment
									Date</label> <input type="date" class="form-control" required
									name="appoint_date">
							</div>
							
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Time Slots</label>
								 <select required class="form-control" name="ts">	
								  <option>--select--</option>
									<%
									
									List<TimeSlots> lst = dao.getAllTimeSlots();
									for (TimeSlots t : lst) {
									%>
									<option><%=t.getAts_info()%></option>
									<%
									}
									%>
								</select>																			
							</div>
							
						<%-- 	<input type="hidden" class="form-control" name="ats_id"	
								 
									<%								
									for (TimeSlots t : lst) {
									%>
									value="<%=t.getAts_id()%>"
									<%
									}
									%>
							>	--%>		
							
							
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Consultation Fee</label>
								 <select required class="form-control" name="cfee">	
								   	<option>--select--</option>
									<%
									for (Doctor d : list) {
									%>
									<option><%=d.getCons_fee()%> </option>
									<%
									}
									%>
								</select>																
							</div>
							
							<button class="col-md-6 offset-md-3 btn btn-success">Submit</button>
														
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%--@include file="component/footer.jsp"--%>

</body>
</html>