<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<c:forEach items="${cars}" var="car">
    ${cars.id} ${cars.model} ${cars.year} ${cars.cost} <br>
</c:forEach>
</body>
</html>
