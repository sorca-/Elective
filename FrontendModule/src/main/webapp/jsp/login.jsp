<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <title>Login</title>
</head>

<body>
<!-- begin container -->
<nav role="custom-dropdown">
    <input type="checkbox" id="button">
    <label for="button" onclick></label>

    <ul>
        <li>
            <form name="loginForm" method="POST" action="controller">
                <input type="hidden" name="command" value="login" />
                <fmt:message key="menu.login" var="menuLogin"/>
                <a href="#" onclick="document.getElementById('loginForm').submit()">${menuLogin}</a>
            </form>
        </li>
        <li><a href="#"><fmt:message key="menu.about"/></a></li>
        <li><a href="#"><fmt:message key="menu.contact"/></a></li>

    </ul>
</nav>
<!-- end container -->
</body>
</html>

<%--<form name="loginForm" method="POST" action="controller">--%>
    <%--<input type="hidden" name="command" value="login" />--%>

    <%--<fmt:message key="login.login"/><br/>--%>
    <%--<input type="text" name="login" value=""/>--%>

    <%--<br/><fmt:message key="login.password"/><br/>--%>
    <%--<input type="password" name="password" value=""/>--%>
    <%--<br/>--%>

    <%--<c:if test="${not empty errorLoginPassMessage}">--%>
        <%--${errorLoginPassMessage}--%>
    <%--</c:if>--%>
    <%--<c:if test="${not empty wrongAction}">--%>
        <%--${wrongAction}--%>
    <%--</c:if>--%>
    <%--<c:if test="${not empty nullPage}">--%>
        <%--${nullPage}--%>
    <%--</c:if>--%>

    <%--<br/>--%>
    <%--<fmt:message key="menu.login" var="buttonLogin"/>--%>
    <%--<input type="submit" value="${buttonLogin}"/>--%>
<%--</form>--%>