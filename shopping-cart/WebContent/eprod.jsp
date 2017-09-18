<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Awesome shopping site</title>
</head>
<body>
    <center>
        <h1>Review Product details</h1>
        <h2>
           <!--  <a href="new">Add New User</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Users</a> -->
            
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${prod != null}">
            <form action="updatep" method="post">
        </c:if>
        <c:if test="${prod == null}">
            <form action="insertp" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${prod != null}">
                        Edit Product
                    </c:if>
                    <c:if test="${prod == null}">
                        Add New Product
                    </c:if>
                </h2>
            </caption>
              
                    
            <tr>
                <th>Product ID: </th>
                <td>
                    <input type="text" name="id" size="40"
                            value="<c:out value='${prod.prodid}' />"
                        />
                </td>
            </tr>
                           
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="40"
                            value="<c:out value='${prod.name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Price </th>
                <td>
                    <input type="text" name="price" size="40"
                            value="<c:out value='${prod.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>description: </th>
                <td>
                    <input type="text" name="desc" size="50"
                            value="<c:out value='${prod.desc}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>       
    </div>   
</body>
</html>