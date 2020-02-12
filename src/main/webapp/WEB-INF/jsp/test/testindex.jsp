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

    <form:form action= "/add" method ="POST" modelAttribute = "room">

        <form:label path = "roomName">RoomName:</form:label><form:input path="roomName" /><br>
        <form:label path = "roomStatus">RoomStatus</form:label><form:input type="number" path="roomStatus" /><br>
        <form:label path = "roomClean">Is room clean:</form:label><form:input path="roomClean" value="true"/><br>
        <input type="submit" value="Submit"/>

    </form:form>

    



    <table border="1px">
        <c:forEach items="${roomlist}" var="item">
            <tr>
                <td>
                    ${item.roomName}
                </td>
                <td>
                    ${item.roomStatus}
                </td>
                <td>
                    ${item.roomClean}
                </td>
                <td>
                    ${item.roomId}
                </td>
                <td>
                    <a href= "/testroom/${item.roomId}"> ${item.roomName}</a>
                </td>
                <td>
                    <a href= "/testroom/${item.roomId}/showusers"> USERRRRSSZZZXXXX</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</body>
</html>

