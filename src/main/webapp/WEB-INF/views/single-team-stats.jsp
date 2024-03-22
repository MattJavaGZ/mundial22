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
    <section class="stats">
    <c:choose>
        <c:when test="${empty requestScope.team}">
            <h2>Podana drużyna nie została odnaleziona</h2>
        </c:when>
        <c:otherwise>
            <h2>Statystyki drużyny:</h2>
            <p><b><c:out value="${fn:toUpperCase(requestScope.team.name)}"/></b></p>
            <p>Bramki zdobyte: ${requestScope.team.goalsScored}</p>
            <p>Bramki stracone: ${requestScope.team.goalsConceded}</p>
            <p>Bilans bramek: ${requestScope.team.goalsBalance}</p>
            <p>Zwycięstwa: ${requestScope.team.winValue}</p>
            <p>Remisy: ${requestScope.team.drwaValue}</p>
            <p>Porażki: ${requestScope.team.lostValue}</p>

                <h2>Mecze drużyny:</h2>
                <%@include file="../segments/matches.jspf"%>
        </c:otherwise>
    </c:choose>
    </section>

</div>
</body>
</html>
