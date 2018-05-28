<%@ page import="java.util.List" %>
<%@ page import="entity.Image" %>
<%@ page import="entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <form method="post" action="remove">
        <c:forEach items="${users}" var="user">
            <tr>
                <td><input type="checkbox" name="rem" value="${user.id}"><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.age}"/></td>
                <td><c:out value="${user.image.image}"/></td>
                <td><img src='/image?id=${user.id}' width='50' height='60'/></td>
            </tr>
        </c:forEach>
        <p><input type="submit" value="Remove"></p>
    </form>
</table>


</body>
</html>
