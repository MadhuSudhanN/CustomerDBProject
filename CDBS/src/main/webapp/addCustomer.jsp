<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title >Customer Details Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ecf0f1;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
            width: 600px;
            margin: 20px;
            box-sizing: border-box;
        }

        h2 {
            color: #333;
        }

        .form-group {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            margin: 10px 0;
        }

        .form-group input {
            flex: 1;
            padding: 10px;
            margin: 10px 5px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #3498db;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1 style="color:red">Customer Detail Form</h1>
        <form action="addCust" method="post">
        
            <div class="form-group">
                <input type="text" name="firstName" placeholder="First Name" required>
                <input type="text" name="lastName" placeholder="Last Name" required>
            </div>
            <div class="form-group">
                <input type="text" name="street" placeholder="Street" required>
                <input type="text" name="address" placeholder="Address" required>
            </div>
            <div class="form-group">
                <input type="text" name="city" placeholder="City" required>
                <input type="text" name="state" placeholder="State" required>
            </div>
            <div class="form-group">
                <input type="email" name="email" placeholder="Email" required>
                <input type="tel" name="phone" placeholder="Phone" required>
            </div>
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
