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
	<%@include file="navbar.jsp"%>
	<div class="container-fluid p-3">
		<div class="row">


			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Doctor Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<table class="table text-center">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">DOB</th>
									<th scope="col">Specialist</th>
									<th scope="col">Visiting Day</th>
									<th scope="col">Visiting Time</th>
									<th scope="col">Patient Visit Limit</th>
									<th scope="col">Consultation Fee</th>
									<th scope="col">Mobile No</th>
									<th scope="col">Email</th>									
									<th scope="col">Action</th>
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
									<td><%=d.getDob()%></td>
									<td><%=d.getSpecialist()%></td>
									<td><%=d.getVisiting_day()%></td>
									<td><%=d.getVisiting_time()%></td>
									<td><%=d.getPatient_visit_limit()%></td>   
									<td><%=d.getCons_fee()%></td>									
									<td><%=d.getMobno()%></td>
									<td><%=d.getEmail()%></td>
									<td><a href="edit_doctor.jsp?did=<%=d.getDid()%>"
										class="btn btn-sm btn-primary">Edit</a> 
										
										<a href="../deleteDoctor?did=<%=d.getDid()%>"
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