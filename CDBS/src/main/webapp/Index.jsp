<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Operations</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #ecf0f1;
	margin: 0;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

.button-container {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	align-items: center;
	gap: 20px;
	margin-top: 20px;
}

.operation-button, .database-button {
	background-color: #3498db;
	color: #fff;
	padding: 15px 30px;
	border: none;
	border-radius: 5px;
	font-size: 18px;
	cursor: pointer;
}

.customer-image {
	max-width: 100%;
	height: auto;
	margin: 20px;
	border-radius: 10px;
}

</style>
</head>
<body>

   
	<h1 style="color: red">CUSTOMER DATABASE MANAGEMENT SYSTEM</h1>
	<div class="button-container">
		<form action="Featch.jsp">
			<input class="operation-button" type="submit"
				value="Check Database" />
		</form>
		<div>
			<img src="1.jpeg" alt="Customer Image" class="customer-image">
		</div>

		<form action="addCustomer.jsp">
			<input class="operation-button" type="submit" value="Add Customer" />
		</form>
	</div>
	
	<div class="button-container">
		<form action="delete"><fieldset><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
		
		<input type="number" name="cid" required
				placeholder="Enter Customer ID" /><br><br>&nbsp;&nbsp;&nbsp; 
			<input class="operation-button" value="Delete Customer" type="submit" /><br>
			</fieldset>
		</form>
	</div>
</body>
</html>


