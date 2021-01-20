<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>My team</title>
</head>
<body>
<form method="post" id="redirect"></form>
<h1 class="table_dark">Hello, mates</h1>
<table class="table_dark">
    <tr>
        <th>Redirect to</th>
    </tr>
    <tr>
        <td><button form="redirect" type="submit" name="All drivers">All drivers</button></td>
    </tr>
    <tr>
        <td><button form="redirect" type="submit" name="Add driver">Add driver</button></td>
    </tr>
    <tr>
        <td><button form="redirect" type="submit" name="All cars">All cars</button></td>
    </tr>
    <tr>
        <td><button form="redirect" type="submit" name="Add car">Add car</button></td>
    </tr>
    <tr>
        <td><button form="redirect" type="submit" name="Add driver to car">Add driver to car</button></td>
    </tr>
    <tr>
        <td><button form="redirect" type="submit" name="Add manufacturer">Add manufacturer</button></td>
    </tr>
    <tr>
        <td><button form="redirect" type="submit" name="All manufacturers">All manufacturers</button></td>
    </tr>
</table>
</body>
</html>
