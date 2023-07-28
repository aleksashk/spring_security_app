<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 28.07.2023
  Time: 00:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information for employee</title>
</head>
<body>

<h2>Information about all employees</h2>
<br>
<br>

<security:authorize access="hasRole('HR')">

<input type="button" value="Salary"
       onclick="window.location.href = 'hr_info'">
Only for HR staff

</security:authorize>

<br>
<br>

<security:authorize access="hasRole('MANAGER')">

<input type="button" value="Performance"
       onclick="window.location.href = 'manager_info'">
Only for MANAGERS

</security:authorize>

<br>
<br>

</body>
</html>
