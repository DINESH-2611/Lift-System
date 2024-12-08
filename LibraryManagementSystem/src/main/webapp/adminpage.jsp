<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%
    // Set cache-control headers to prevent the page from being cached
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    // Retrieve the email session attribute
    String email2 = (String) session.getAttribute("admin");
    // If email is null (session is invalid), redirect to the homepage
    if (email2 == null) {
        response.sendRedirect("index.html");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Portal</title>
    <link rel="stylesheet" href="bootstrap.min.css"/>
    <style>
        body {
            background-color: #f8f9fa; /* Light background for contrast */
            margin: 0; /* Remove default body margin */
            padding: 0; /* Remove default body padding */
        }
        .top-container {
            text-align: center; /* Center the text horizontally */
            margin-top: 20px; /* Space from the top of the screen */
        }
        .nav-menu {
            list-style-type: disc; /* Bulleted list */
            padding: 0; /* Remove default padding */
            margin: 20px auto; /* Center list and add spacing from heading */
            text-align: left; /* Align text to the left for bullets */
            display: inline-block; /* Keep list items compactly centered */
            color: black; /* Black text color */
            font-size: 18px; /* Adjust font size */
        }
        .nav-menu a {
            text-decoration: none; /* Remove underline */
            color: black; /* Black text color */
        }
        .nav-menu a:hover {
            text-decoration: underline; /* Underline on hover */
        }
    </style>

</head>
<body>


    <div class="top-container">
        <h1>Welcome to Admin Portal</h1>
        <ul class="nav-menu">
            <li><a href="adduser.jsp">Add User</a></li>
            <li><a href="viewuser.html">View Users</a></li>
            <li><a href="addbook.jsp">Add Book</a></li>
            <li><a href="viewbook.html">View Books</a></li>
            <li><a href="viewissuebook.html">View Issued Books</a></li>
            <li><a href="Logout">Logout</a></li>
        </ul>
    </div>


<script src="jquery.min.js"></script>
<script src="bootstrap.min.js"></script>

</body>
</html>
