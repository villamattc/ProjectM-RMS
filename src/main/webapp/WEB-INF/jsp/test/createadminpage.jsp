<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        hgelppeepelepflpl
<!-- 
    <form action="<%=request.getContextPath()%>/add" method="POST">
        Roomname:<input type = "text" name = "roomName"/><br>
        RoomStatus:<input type = "number" name = "roomStatus"/><br>
        roomisclean: <input name = "roomClean" value="true"><br>
        <button type="submit">uwu</button>
    </form> -->

    <form:form action= "/createadmin" method ="POST" modelAttribute = "admin">

        <form:label path = "username">Username:</form:label><form:input path="username" /><br>
        <form:label path = "password">Password</form:label><form:input type="password" path="password" /><br>
        <form:label path = "adminName">Admin Name:</form:label><form:input path="adminName"/><br>
        <input type="submit" value="Submit"/>

    </form:form>

    
</div>
</body>
</html>

