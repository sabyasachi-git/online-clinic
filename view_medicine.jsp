<%@page import="java.util.List"%>
<%@page import="com.entity.Specialist"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.entity.Medicine"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.SpecialistDao"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.dao.MedicineDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medicine</title>
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
font-weight: bold;
}
.paint-card {
		box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
	}

</style>
</head>
<body>
	<%@include file="navbar.jsp"%>	
	<div class="container-fluid p-4">	
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
				
					<div class="card-body">
						<p class="fs-3 text-center">Medicine Details</p>
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
									<th scope="col">Manufacturer Name</th>
									<th scope="col">Medicine Name</th>
									<th scope="col">Batch_No</th>
									<th scope="col">MFD</th>
									<th scope="col">EXP</th>
									<th scope="col">MRP</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								MedicineDao dao = new MedicineDao(DBConnect.getConn());
								List<Medicine> list1 = dao.getAllMedicine();
								for (Medicine md : list1) {
								%>
								<tr>
									<td><%=md.getMf_name()%></td>
									<td><%=md.getMed_name()%></td>
									<td><%=md.getBatch_no()%></td>
									<td><%=md.getMf_date()%></td>
									<td><%=md.getExp_date()%></td>
									<td><%=md.getMed_mrp()%></td>
									<td>
										<a href="edit_medicine.jsp?id=<%=md.getMed_id()%>" 
										class="btn btn-sm btn-primary">Edit</a>										
										
										<a href="../deleteMedicine?id=<%=md.getMed_id()%>"
										class="btn btn-sm btn-danger">Delete</a>										
								    </td>
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