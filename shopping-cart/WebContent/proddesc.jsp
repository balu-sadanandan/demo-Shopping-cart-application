<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Awesome shopping website</title>
</head>
<body>
 <div align="right">
    <a href="logout">logout</a>
    
</div>
   <div align="left">
    <a href="listp">Continue shopping</a>
    
</div>   
 <center>
        <h1>Awesome shopping website</h1>
    </center>
   </div>
   <div align="left">

    <h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.name }</h2>   
    </div>
    <div>
    <table>
<tr>
<td>
<div ><h4>Product description:</h4></div>
</td>
<td>
<div ><p>${product.desc }<p></div>
</td>
</tr>
</table>
    <%-- <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Product description:<h5>${product.desc }</h5></h3> --%> 
    
    <table>
<tr>
<td>
<div ><h3>Price:</h3></div>
</td>
<td>
<div ><h4>&nbsp;${product.price }</h4></div>
</td>
</tr>
</table>
    <%-- <h4>Price:</h4><h6>${product.price }</h6> --%>
</div>   
<div align="right">
    <!-- <a href="acart">Add to cart</a> -->
   
      <%-- <a href="acart?id=<c:out value='${product.prodid}' />">Add to cart</a> --%>
      <a href="acart?id=${product.prodid}" />Add to cart</a> 
    
</div>


</body>
</html>