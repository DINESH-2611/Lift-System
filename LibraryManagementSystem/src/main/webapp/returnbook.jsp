<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    // Prevent caching to ensure a fresh page is served
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String email2 = (String) session.getAttribute("user");
    // If email is null (session is invalid), redirect to the homepage
    if (email2 == null) {
        response.sendRedirect("index.html");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Get Book</title>
    <link rel="stylesheet" href="bootstrap.min.css">
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: flex-start; /* Align form to the top */
            height: 100vh; /* Full viewport height */
            background-color: #f8f9fa; /* Light background for contrast */
        }
        .form-container {
            margin-top: 20px; /* Space from the top */
            width: 300px; /* Set a consistent width for the form */
        }
        .form-container .form-group {
            margin-bottom: 15px;
        }
        .form-container .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-container .form-group input {
            width: 100%;
            padding: 8px;
            font-size: 14px;
        }
        .form-container button {
            display: block;
            margin: 20px auto 0; /* Center the button horizontally */
        }
    </style>
</head>
<body>
<div class="form-container">
    <form id="bookForm" action="ReturnBook" method="post">
        <div class="form-group">
            <label for="name1">Book Name</label>
            <input type="text" class="form-control" name="name" id="name1" placeholder="Enter book name" required/>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<script src="jquery.min.js"></script>
<script src="bootstrap.min.js"></script>
</body>
</html>
