<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>random shopping site</title>
</head>
<body>
    <center>
        <h1>Awesome shopping website</h1>
    </center>
    <div align="right">
    <a href="logout">Logout</a>
</div>
      
    
    <center>    
        <h2>
            <a href="new">Add New User</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Users</a>
            &nbsp;&nbsp;&nbsp;
            <a href="vp">View products</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>email id</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="usr" items="${userlist}">
                <tr>
                    <td><c:out value="${usr.uid}" /></td>
                    <td><c:out value="${usr.name}" /></td>
                    <td><c:out value="${usr.mailid}" /></td>
                    <td>
                        <a href="edit?id=<c:out value='${usr.uid}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${usr.uid}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>