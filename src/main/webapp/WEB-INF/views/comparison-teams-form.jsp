<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Porównanie drużyn formularz</title>
    <%@include file="../segments/stylesheets.jspf" %>
</head>
<body>
<div class="container">
    <%@include file="../segments/header.jspf" %>

    <form action="${pageContext.request.contextPath}/comparison" class="form">
        <label >Wybierz nazwy drużyn:</label>
        <select  name="teamname1">
            <c:forEach items="${requestScope.names}" var="name">
                <option>${fn:toUpperCase(name)}</option>
            </c:forEach>
        </select>

        <select name="teamname2">
            <c:forEach items="${requestScope.names}" var="name">
                <option>${fn:toUpperCase(name)}</option>
            </c:forEach>
        </select>
        <p><button>Wczytaj Porównanie drużyn</button></p>
    </form>

</div>
</body>
</html>
