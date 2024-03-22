<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="pl">
<head>
    <title>Porónanie drużyn</title>
    <%@include file="../segments/stylesheets.jspf" %>
</head>
<body>
<div class="container">
    <%@include file="../segments/header.jspf" %>
    <c:choose>
        <c:when test="${empty requestScope.team1 or empty requestScope.team2}">
            <h2>Błędnie wybrane drużyny</h2>
        </c:when>
        <c:when test="${requestScope.team1.name eq requestScope.team2.name}">
            <h2>Wybrałem te same drużyny do porównania fujaro :)</h2>
        </c:when>
        <c:otherwise>
            <article style="display: flex" class="comparison">
                <section style="flex: 50%;">
                    <h2>Statystyki drużyny:</h2>
                    <p><b><c:out value="${fn:toUpperCase(requestScope.team1.name)}"/></b></p>
                    <p>Bramki zdobyte: ${requestScope.team1.goalsScored}</p>
                    <p>Bramki stracone: ${requestScope.team1.goalsConceded}</p>
                    <p>Bilans bramek: ${requestScope.team1.goalsBalance}</p>
                    <p>Ilość zwycięstw: ${requestScope.team1.winValue}</p>
                    <p>Ilość remisów: ${requestScope.team1.drwaValue}</p>
                    <p>Ilość porażek: ${requestScope.team1.lostValue}</p>
                </section>
                <section style="flex: 50%;">
                    <h2>Statystyki drużyny:</h2>
                    <p><b><c:out value="${fn:toUpperCase(requestScope.team2.name)}"/></b></p>
                    <p>Bramki zdobyte: ${requestScope.team2.goalsScored}</p>
                    <p>Bramki stracone: ${requestScope.team2.goalsConceded}</p>
                    <p>Bilans bramek: ${requestScope.team2.goalsBalance}</p>
                    <p>Zwycięstwa: ${requestScope.team2.winValue}</p>
                    <p>Remisy: ${requestScope.team2.drwaValue}</p>
                    <p>Porażki: ${requestScope.team2.lostValue}</p>
                </section>
            </article>
            <article>
                <h2 style="text-align: center">Bezpośrednie mecze:</h2>
                <%@include file="../segments/matches.jspf"%>
            </article>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
