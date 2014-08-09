<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="Messages"/>

<!DOCTYPE HTML>
<html>
<head>
    <!-- begin meta -->
    <meta charset="utf-8">
    <!-- end meta -->

    <!-- begin CSS -->
    <link rel="stylesheet" href="/../css/menu.css" type="text/css">
    <!-- end CSS -->

    <title>Navigation Menu</title>
</head>

<body>
<!-- begin container -->
<nav role="custom-dropdown">
    <input type="checkbox" id="button">
    <label for="button" onclick></label>

    <ul>
        <li><a href="#"><fmt:message key="menu.electives"/></a></li>
        <li><a href="#"><fmt:message key="menu.students"/></a></li>
        <li><a href="#"><fmt:message key="menu.about"/></a></li>
        <li><a href="#"><fmt:message key="menu.contact"/></a></li>
        <li>
            <form id="logoutForm" name="logoutForm" method="post" action="controller">
            <input type="hidden" name="command" value="logout">
            <fmt:message key="menu.logout" var="menuLogout"/>
            <a href="#" onclick="document.getElementById('logoutForm').submit()">${menuLogout}</a>
            </form>
        </li>
    </ul>
</nav>
<!-- end container -->
</body>
</html>

<%--<form name="pickElectiveForm" method="post" action="controller">--%>
    <%--<input type="hidden" name="command" value="pick_Elective">--%>
    <%--<input type="submit" value="Pick elective">--%>
<%--</form>--%>
<%--<form name="enrollElectiveForm" method="post" action="controller">--%>
    <%--<input type="hidden" name="command" value="enroll_Elective">--%>
    <%--<input type="submit" value="Enroll in elective">--%>
<%--</form>--%>
<%--<form name="seeElectiveForm" method="post" action="controller">--%>
    <%--<input type="hidden" name="command" value="see_Elective">--%>
    <%--<input type="submit" value="See my elective">--%>
<%--</form>--%>

<%--</body></html>--%>

