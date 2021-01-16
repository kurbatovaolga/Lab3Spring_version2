<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page session="false" %>
<html>
<head>
    <title>Departments</title>
</head>
<body>

<h3>Список Отделов</h3>
<c:if test="${!empty departments}">
    <table>
        <tr>
            <th>№</th>
            <th>Название</th>
        </tr>
        <c:forEach items="${departments}" var="department">
            <tr>
                <td>${department.id}</td>
                <td>${department.name}</td>

            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>