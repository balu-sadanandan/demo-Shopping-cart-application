<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>random shopping site</title>
</head>
<body>
    <center>
        <h1>New user registration</h1>
        <h2>
            <a href="new">Add New User</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Users</a>
            
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${user != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
            <form action="ninsert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${user != null}">
                        Edit User
                    </c:if>
                    <c:if test="${user == null}">
                        Add New User
                    </c:if>
                </h2>
            </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.uid}' />" />
                </c:if>           
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="40"
                            value="<c:out value='${user.name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Password </th>
                <td>
                    <input type="text" name="pwd" size="40"
                            value="<c:out value='${user.pwd}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>emailid: </th>
                <td>
                    <input type="text" name="mid" size="50"
                            value="<c:out value='${user.mailid}' />"
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