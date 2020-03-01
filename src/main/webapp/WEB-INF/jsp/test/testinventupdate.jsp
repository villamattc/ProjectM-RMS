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
<!-- 
    <form action="<%=request.getContextPath()%>/add" method="POST">
        Roomname:<input type = "text" name = "roomName"/><br>
        RoomStatus:<input type = "number" name = "roomStatus"/><br>
        roomisclean: <input name = "roomClean" value="true"><br>
        <button type="submit">uwu</button>
    </form> -->
   <table border="1px">
        <form:form action= "/${id}/testupdateinvent" method ="POST" 
                modelAttribute = "attachInvents" >
            <tr>
                <th>Item Name</th>
                <th>Max</th>
                <th></th>
            <tr>
            <tr>
                <td hidden="true">
                    <%-- ${item.inventName} --%>
                    <form:input path="attach" value = "${attachInvents.attach}"/>
                </td>
            </tr>
            <c:forEach items="${attachInvents.list}" var="item" varStatus="status">
                <tr>
                    
                    <td>
                        <%-- ${item.inventName} --%>
                        <form:input path="list[${status.index}].inventName" value = "${item.inventName}"/>
                    </td>
                    <td>  
                        <%-- ${item.inventMaxQuantity} --%>
                        <form:input path="list[${status.index}].inventMaxQuantity" value = "${item.inventMaxQuantity}"/>
                    </td>
                    <td>  
                        <form:input type="number" path="list[${status.index}].inventCurrentQuantity" value = "${item.inventCurrentQuantity}"/>
                    </td>

                </tr>
            </c:forEach>
            <button type="submit" class="btn btn-primary"> Update Invetory</button>
        </form:form>
    </table>

    
</div>
</body>
</html>