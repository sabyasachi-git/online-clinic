<%@page import="com.entity.Specialist"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.entity.Qualification"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.SpecialistDao"%>
<%@page import="com.dao.QualificationDao"%>
<%@page import="com.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Doctor Profile</title>
<style type="text/css">
body{
background-image: linear-gradient(
      to right,
      rgba(18, 103, 172, 0.74),
      rgba(18, 172, 141, 0.37)
    );
background-size: cover;
}
.card {
background-color: #e9f3f73d;
font-weight: bold;
}
form {
color: #13099bec;

}
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
	color: #13099bec;
}
</style>
<%@include file="../component/allcss.jsp"%>
</head>
<body>
	<c:if test="${empty doctObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>


	<%@include file="navbar.jsp"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-4">
				<div class="card paint-card">
					<p class="text-center fs-3">Change Password</p>
					<c:if test="${not empty succMsg }">
						<p class="text-center text-success fs-3">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
					</c:if>

					<c:if test="${not empty errorMsg }">
						<p class="text-center text-danger fs-5">${errorMsg}</p>
						<c:remove var="errorMsg" scope="session" />
					</c:if>
					<div class="card-body">
						<form action="../doctChangePassword" method="post">
						
							<input type="hidden" value="${doctObj.did }" name="did">
						
							<div class="mb-3">
								<label>Enter old Password</label> <input type="password"
									name="oldPassword" class="form-control" required>
							</div>

							<div class="mb-3">
								<label>Enter New Password</label> <input type="password"
									name="newPassword" class="form-control" required>
							</div>
							
							<button class="btn btn-success col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>

			<div class="col-md-5 offset-md-2">
				<div class="card paint-card">
					<p class="text-center fs-3">Edit Profile</p>
					<c:if test="${not empty succMsgd }">
						<p class="text-center text-success fs-3">${succMsgd}</p>
						<c:remove var="succMsgd" scope="session" />
					</c:if>

					<c:if test="${not empty errorMsgd }">
						<p class="text-center text-danger fs-5">${errorMsgd}</p>
						<c:remove var="errorMsgd" scope="session" />
					</c:if>
					<div class="card-body">
					
						<form action="../doctorUpdateProfile" method="post">
						
							<input type="hidden" name="did" value="${doctObj.did }">
						
							<div class="mb-3">
								<label class="form-label">Registration No</label> <input type="text"
									required name="drn" class="form-control"
									value="${doctObj.dreg_id }">
							</div>
						
						    <div class="mb-3">
								<label class="form-label">First Name</label> <input type="text"
									required name="fname" class="form-control"
									value="${doctObj.full_name }">
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									required name="dob" class="form-control"
									value="${doctObj.dob }">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <select name="qualification"
									required class="form-control">
									<option>${doctObj.qualification }</option>

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
									<option>${doctObj.specialist }</option>

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
								<select type="text"	required name="visitDay" class="form-control">
									<option>${doctObj.visiting_day }</option>
									<option>Monday</option>
									<option>Tuesday</option>
									<option>Wednesday</option>
									<option>Thursday</option>
									<option>Friday</option>
									<option>Saturday</option>
									<option>Sunday</option>
								</select>
							</div>

							<div class="mb-3">
								<label class="form-label">Consultation Fee</label> <input type="text"
									required name="cfee" class="form-control"
									value="${doctObj.cons_fee }">
							</div>

							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text"
									required name="mobno" class="form-control"
									value="${doctObj.mobno }">
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									readonly required name="email" class="form-control"
									value="${doctObj.email }">
							</div>

							<button type="submit" class="btn btn-primary">Update</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>