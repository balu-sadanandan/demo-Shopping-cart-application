<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>My cart</title>
</head>
<body>
    <center>
        <h1> Shopping website</h1>
    </center>
    <div align="right">
    <a href="logout">Logout</a>
    
</div>
   <div align="left">
    <a href="prodcat">goback</a>
    
</div>   
    
   
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>My cart</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="uc" items="${ucList}">
                <tr>
                    <td><c:out value="${uc.prodid}" /></td>
                    <td><a href="prod?id=<c:out value='${uc.prodid}' />"><c:out value="${uc.name}" /></a></td>
                    <td><c:out value="${uc.qty}" /></td>
                    <td><c:out value="${uc.price}" /></td>
                    <td>
                        <a href="rcart?id=<c:out value='${uc.prodid}' />">Remove from cart</a>
                           
                    </td>
                </tr>
            </c:forEach>
        </table>
        
    </div>   
</body>
</html>