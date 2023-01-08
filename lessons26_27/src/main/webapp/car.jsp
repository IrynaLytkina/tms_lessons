
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Car</title>
</head>
<body>

<br>
<form action="create" metod="post">
    <input type="number" name="id"><br>
    <input type="text" name="model"><br>
    <input type="text" name="year"><br>
    <input type="number" name="cost"><br>
    <input type="submit" value="Submit"><br>
</form>
<br>
<c:forEach items="${cars}" var="car">
    ${cars.id} ${cars.model} ${cars.year} ${cars.cost} <br>
</c:forEach>
</body>
</html>
