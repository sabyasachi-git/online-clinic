<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Specialist"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.SpecialistDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Details</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">

body{
background-image: linear-gradient(
      to right,
      rgba(18, 103, 172, 0.74),
      rgba(18, 172, 141, 0.37)
    ),
 url('img/doc.jpg');
background-size: cover;
}
.card{
background-color: #e9f3f73d;
font-weight: bold;
}
tr {
color: #13099bec;
}
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

</style>
<%@include file="../component/allcss.jsp"%>
<%@include file="../component/navbar.jsp"%>
</head>
<body>
	
	<div class="container-fluid p-4">
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Our Doctors</p>
						<table class="table text-center">
							<thead>
								<tr>
									<th scope="col">Full Name</th>			
									<th scope="col">Email</th>						
									<th scope="col">Qualification</th>
									<th scope="col">Specialist</th>
									<th scope="col">Visiting Day</th>
									<th scope="col">Visiting Time</th>
									<th scope="col">Consultation Fee</th>																		
								</tr>
							</thead>
							<tbody>
								<%
								DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
								List<Doctor> list = dao2.getAllDoctor();
								for (Doctor d : list) {
								%>
								<tr>
									<td><%=d.getFull_name()%></td>
									<td><%=d.getEmail()%></td>
									<td><%=d.getQualification()%></td>
									<td><%=d.getSpecialist()%></td>
									<td><%=d.getVisiting_day()%></td>
									<td><%=d.getVisiting_time()%></td>
									<td><%=d.getCons_fee()%></td>																		
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