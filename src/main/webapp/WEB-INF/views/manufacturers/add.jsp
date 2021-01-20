<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>Manufacturers</title>
</head>
<body>
<form method="post" id="manufacturer"></form>
<h1 class="table_dark">Add manufacturer:</h1>
<table border="1" class="table_dark">
    <tr>
        <th>Name</th>
        <th>Country</th>
        <th>Add</th>
    </tr>
    <tr>
        <td>
            <input type="text" name="name" form="manufacturer">
        </td>
        <td>
            <input type="text" name="country" form="manufacturer">
        </td>
        <td>
            <input type="submit" name="add" form="manufacturer">
        </td>
    </tr>
</table>
</body>
</html>
