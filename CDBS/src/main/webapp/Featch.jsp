<%@page import="com.DAO.CustomerDAOImp"%>

<%@page import="com.entity.CustomerEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Colorful Table</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	text-align: left;
	
}


th {
	padding: 15px;
	background-color: #4CAF50;
	color: white;
}
input{
border-collapse: collapse;
}

.id {

	width: 20pt;
	height: 20pt;
}

.id1 {
	width: 50pt;
	height: 20pt;
}

.id1x {
	width: 60pt;
	height: 20pt;
}

.id2 {
	width: 80pt;
	height: 20pt;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #ddd;
}
</style>
</head>
<h1>
	<CENTER>
		<i>CUSTOMER DATABASE</i>
	</CENTER>
</h1>
<body style="margin-left: 100px; margin-right: 100px">
	<span>
		<form action="FeatchSearch.jsp">
			<select id="car" name="search" required>
				<option value="SearchByName">Search By Name</option>
				<option value="SearchById">Search By CustID</option>
				<option value="SearchByEmail">Search By Email</option>
				<option value="SearchByPhone">Search By Phone</option>
			</select> <input type="Text" name="name" placeholder="Search" required>

		</form>
	</span>
	<br>
	<span>
		<form action="addCustomer.jsp">
			<input
				style="height: 30pt; border: 4px solid black; border-radius: 15px;"
				type="submit" value="Add Customer">
		</form>
	</span>


	<table border=10px style="padding-right: 200px; padding-left: 200px">
		<tr>
			<th>CustomerId</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Street</th>
			<th>Address</th>
			<th>City</th>
			<th>State</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th colspan="2">Delete &nbsp;/ &nbsp;Update</th>


		</tr>

		<%
		List<CustomerEntity> list = CustomerDAOImp.featch();
		for (CustomerEntity x : list) {
		%>
		<tr>

			<form action="/process" method="post">
				<td><input class="id" type="number" name="cid" permanent
					important value="<%=x.getCid()%>" placeholder="<%=x.getCid()%>"></td>
				<td><input class="id1" type="text" name="fname"
					placeholder="<%=x.getFname()%>"></td>
				<td><input class="id1" type="text" name="lname"
					placeholder="<%=x.getLname()%>"></td>
				<td><input class="id1" type="text" name="street"
					placeholder="<%=x.getStreet()%>"></td>
				<td><input class="id2" type="text" name="address"
					placeholder="<%=x.getAddress()%>"></td>
				<td><input class="id1" type="text" name="city"
					placeholder="<%=x.getCity()%>"></td>
				<td><input class="id1" type="text" name="state"
					placeholder="<%=x.getState()%>"></td>
				<td><input class="id2" type="text" name="email"
					placeholder="<%=x.getEmail()%>"></td>
				<td><input class="id1x" type="tel" name="phone"
					placeholder="<%=x.getPhone()%>" maxlength=10 minlength=10 size=10>
				</td>
				<td><button style="background: orange" type="submit"
						formaction="update">Update</button></td>
				<td>
					<button style="background: red; color: white" type="submit"
						formaction="delete">Delete</button>
				</td>


			</form>

		</tr>
		<%}%>
	</table>
	<br>
	<form action="Index.jsp">
		<input type=submit value="Go to Home Page"
			style="border: 4px solid black; border-radius: 15px; padding-bottom: 8px; padding-Top: 8px; gray; color: Blue; text: bold paddin-topg:200px; font-size: 20px">
	</form>

	</script>

</body>
</html>
