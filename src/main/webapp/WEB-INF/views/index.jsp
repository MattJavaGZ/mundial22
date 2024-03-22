<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Mundial</title>
    <%@include file="../segments/stylesheets.jspf"%>
</head>
<body>
<div class="container">

  <%@include file="../segments/header.jspf"%>

    <main>
        <h2>Wszystkie mecze</h2>
        <%@include file="../segments/matches.jspf"%>

        <a href="${pageContext.request.contextPath}/add" class="discovery-add-button">
           Dodaj mecz
        </a>

    </main>
    <footer>
        <p>Mundial by Matt</p>
    </footer>
</div>
</body>
</html>