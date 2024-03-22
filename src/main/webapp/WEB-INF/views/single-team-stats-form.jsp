<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="pl">
<head>
    <title>Statystyki drużyny formularz</title>
    <%@include file="../segments/stylesheets.jspf" %>
</head>
<body>
<div class="container">
    <%@include file="../segments/header.jspf" %>

    <form action="${pageContext.request.contextPath}/stats" class="form">
        <label for="teamname">Wybierz nazwę drużyny:</label>
        <select id="teamname" name="teamname">
            <c:forEach items="${requestScope.names}" var="name">
                <option>${fn:toUpperCase(name)}</option>
            </c:forEach>
        </select>
        <button>Wczytaj statystyki</button>
    </form>
</div>
</body>
</html>