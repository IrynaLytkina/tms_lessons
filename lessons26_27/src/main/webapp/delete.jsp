<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<form action="/delete" method="post">
    <input type="hidden" name="id" value="${car.id}">
    <th scope="row"> ${car.id} </th>
    <td> ${car.model} </td>
    <td> ${car.year} </td>
    <td> ${car.cost} </td>
    <td><input type="submit" value="Delete"></td>
</form>
</body>
</html>
