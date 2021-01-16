<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page session="false" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>

<h3>Список сотрудников</h3>
<%--<c:if test="${!empty employees}">--%>
    <table>
        <tr>
            <th>№</th>
            <th>ФИО</th>
            <th>Возраст</th>
            <th>Отдел</th>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.ID}</td>
                <td>${employee.fullName}</td>
                <td>${employee.age}</td>
                <td>${employee.department.name}</td>
            </tr>
        </c:forEach>
    </table>
<%--</c:if>--%>
</body>
</html>