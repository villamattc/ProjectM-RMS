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
       SHOW USERSSXXZZZ
<!-- 
    <form action="<%=request.getContextPath()%>/add" method="POST" >
        Roomname:<input type = "text" name = "roomName"/><br>
        RoomStatus:<input type = "number" name = "roomStatus"/><br>
        roomisclean: <input name = "roomClean" value="true"><br>
        <button type="submit">uwu</button>
    </form> -->
    <table border="1px">
        <c:forEach items="${user}" var="item">
            <tr>
                <td>
                    ${item.lastName}
                </td>
                <td>
                    ${item.firstName}
                </td>
                <td>
                    ${item.checkin}
                </td>
                <td>
                    ${item.checkout}
                </td>
                <td>
                    ${item.nationality}
                </td>
                <td>
                    ${item.age}
                </td>
                <td>
                    ${item.occupation}
                </td>
                <td>
                    ${item.businessOrvacay}
                </td>

            </tr>
        </c:forEach>
    </table>

</body>
</html>