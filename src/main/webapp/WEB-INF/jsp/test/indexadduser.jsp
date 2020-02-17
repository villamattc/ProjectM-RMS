<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       ADD USER FORM
<!-- 
    <form action="<%=request.getContextPath()%>/add" method="POST" >
        Roomname:<input type = "text" name = "roomName"/><br>
        RoomStatus:<input type = "number" name = "roomStatus"/><br>
        roomisclean: <input name = "roomClean" value="true"><br>
        <button type="submit">uwu</button>
    </form> -->
    <form:form action= "/room/${roomId}/adduser" method ="POST" 
    modelAttribute = "user">

        <form:label path = "lastName">Last Name:</form:label><form:input path="lastName" /><br>
        <form:label path = "firstName">First Name</form:label><form:input path="firstName" /><br>
        <form:label path = "checkin">Check in date:</form:label><form:input path="checkin" type="date"/><br>
        <form:label path = "checkout">Check out date:</form:label><form:input path="checkout" type="date"/><br>
        <form:label path = "nationality">Nationality: </form:label><form:input path="nationality" /><br>
        <form:label path = "age">Age:</form:label><form:input path="age" input="number"/><br>
        <form:label path = "occupation">Occupation:</form:label><form:input path="occupation" /><br>
        <form:label path = "businessOrvacay">business or vacation:</form:label><form:input path="businessOrvacay" input="number"/><br>
        <input type="submit" value="Submit"/>

    </form:form>


</body>
</html>