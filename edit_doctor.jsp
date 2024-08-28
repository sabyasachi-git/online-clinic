<%@page import="com.entity.Doctor"%>
<%@page import="com.entity.Specialist"%>
<%@page import="com.entity.Qualification"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.SpecialistDao"%>
<%@page import="com.dao.QualificationDao"%>
<%@page import="com.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
.card {
background-color: #e9f3f73d;
color: white;
font-weight: bold;
}
form {
color: #13099bec;
font-weight: bold;
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
						<p class="fs-3 text-center">Edit Doctor Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<%						
						int id = Integer.parseInt(request.getParameter("did"));
						DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
						Doctor d = dao2.getDoctorById(id);
						%>


						<form action="../updateDoctor" method="post">
						
							<input type="hidden" value="<%=d.getDid()%>" required name="did"
									class="form-control">
						
							<div class="mb-3">
								<label class="form-label">Registration No</label> <input type="text"
									required name="drn" class="form-control"
									value="<%=d.getDreg_id()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fname" class="form-control"
									value="<%=d.getFull_name()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									value="<%=d.getDob()%>" required name="dob"
									class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <select name="qualification"
									required class="form-control">
									<option><%=d.getQualification()%></option>
									<%
									QualificationDao dao = new QualificationDao(DBConnect.getConn());
									List<Qualification> list = dao.getAllQualification();
									for (Qualification s : list) {
									%>
									<option><%=s.getQuali_name()%></option>
									<%
									}
									%>
								</select>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Specialist</label> <select name="spec"
									required class="form-control">
									<option><%=d.getSpecialist()%></option>

									<%
									SpecialistDao dao1 = new SpecialistDao(DBConnect.getConn());
									List<Specialist> list1 = dao1.getAllSpecialist();
									for (Specialist s : list1) {
									%>
									<option><%=s.getSpecialistName()%></option>
									<%
									}
									%>
								</select>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Visiting Day</label> 
								<select name="visitDay"	required class="form-control">
									<option><%=d.getVisiting_day()%></option>									
									<option>Monday</option>
									<option>Tuesday</option>
									<option>Wednesday</option>
									<option>Thursday</option>
									<option>Friday</option>
									<option>Saturday</option>
									<option>Sunday</option>									
								</select>
							</div>

							<%-- <div class="mb-3">
								<label class="form-label">Patient Visit Limit</label> 
								<select name="pvl"	required class="form-control">
									<option><%=d.getPatient_visit_limit()%></option>									
									<option>5</option>
									<option>10</option>
									<option>15</option>
									<option>20</option>
									<option>25</option>
									<option>30</option>							
								</select>
							</div>  --%>

							<div class="mb-3">
								<label class="form-label">Consultation Fee</label> <input type="text"
									required name="cfee" class="form-control"
									value="<%=d.getCons_fee()%>">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text"
									value="<%=d.getMobno()%>" required name="mobno"
									class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									value="<%=d.getEmail()%>" required name="email"
									class="form-control">
							</div>
						
							<%--<div class="mb-3">
								<label class="form-label">Password</label> <input required
									value="<%=d.getPassword()%>" name="password" type="text"
									class="form-control">
							</div>--%>

							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</body>
</html>