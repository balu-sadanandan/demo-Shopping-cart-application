<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Awesome shopping site</title>
</head>
<body>
    <center>
        <h1>Shopping website</h1>
    </center>
    <div align="right">
    <a href="logout">Logout</a>
    
</div>
   <div align="left">
    <a href="lcart">view my cart</a>
    
</div>   
    
   
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Shop for items</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="prod" items="${pList}">
                <tr>
                    <td><c:out value="${prod.prodid}" /></td>
                    <td><a href="prod?id=<c:out value='${prod.prodid}' />"><c:out value="${prod.name}" /></a></td>
                    <td><c:out value="${prod.price}" /></td>
                    <td>
                        <a href="acart?id=<c:out value='${prod.prodid}' />">Add to cart</a>
                           
                    </td>
                </tr>
            </c:forEach>
        </table>
        
    </div>   
</body>
</html>