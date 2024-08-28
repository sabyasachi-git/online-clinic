<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.MedicineDao"%>
<%@page import="com.entity.Medicine"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Medicine</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
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
						<p class="fs-3 text-center">Edit Medicine Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						MedicineDao md = new MedicineDao(DBConnect.getConn());
						Medicine m = md.getMedicineById(id);
						%>

					<form action="../updateMedicine" method="post">
																			
						<div class="form-group">
							<label>Enter Manufacturer Name</label> <input type="text"
								value="<%=m.getMf_name()%>" name="mfn" class="form-control">
						</div>	
						
						<div class="form-group">
							<label>Enter Medicine Name</label> <input type="text"
							value="<%=m.getMed_name()%>" name="medName" class="form-control">
						</div>					
						
						<div class="form-group">
							<label>Enter Batch No</label> <input type="text"
								value="<%=m.getBatch_no()%>" name="bn" class="form-control">
						</div>
						
						<div class="form-group">
							<label>Enter Manufacturing Date(MFD)</label> <input type="text"
								value="<%=m.getMf_date()%>" name="mfd" class="form-control">
						</div>		
						
						<div class="form-group">
							<label>Enter Expiry Date(EXP)</label> <input type="text"
								value="<%=m.getExp_date()%>" name="exp" class="form-control">
						</div>
												
						<div class="form-group">
							<label>Enter Maximum Retail Price(MRP)</label> <input type="text"
								value="<%=m.getMed_mrp()%>" name="mrp" class="form-control">
						</div>
						
						<input type="hidden" name="id" value="<%=m.getMed_id()%>">
																						
						<div class="text-center mt-3">
							<button type="submit" class="btn btn-primary">Update</button>
						</div>
			
					</form>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</body>
</html>