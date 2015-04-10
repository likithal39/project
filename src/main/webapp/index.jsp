<%-- 
    Document   : index
    Created on : Apr 9, 2015, 7:15:34 PM
    Author     : Likitha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    
        <title>Online Clothing store</title>
        <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="container">

<div class="jumbotron">
        <h1>Welcome to Online Clothing store</h1>
        <h2> Please select the below options</h2>
        <ul>
            <li> If you are a customer select the below link </li>
            <li><a href="${pageContext.request.contextPath}/customerPortal/">Customer</a></li>
            
            <li> If you are a manufacturer select the below link</li>
            <li><a href = "${pageContext.request.contextPath}/productPortal/"> manufacturer</a></li>
            
        </ul>
</div>
        </div>
  
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
