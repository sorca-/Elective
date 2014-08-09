<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Welcome</title></head>
<body>
<h3>Welcome</h3>
<hr/>
${user}, hello!
<hr/>
<form name="studentsForm" method="post" action="controller">
    <input type="hidden" name="command" value="view_Students">
    <input type="submit" value="View students list">
</form>
<form name="logoutForm" method="post" action="controller">
    <input type="hidden" name="command" value="logout">
    <input type="submit" value="Log out">
</form>
</body></html>