<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Dodaj mecz</title>
    <%@include file="../segments/stylesheets.jspf" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/add-form.css">
</head>
<body>
<div class="container">
    <div class="title">
        <h1> <a href="${pageContext.request.contextPath}">Mundial</a> </h1>
    </div>

    <form action="${pageContext.request.contextPath}/add" method="post" class="add-form">
        <h1 class="add-form-title">Dodaj mecz</h1>
        <input type="text" name="team1name" placeholder="Nazwa drużyny" required>
        <input type="number" name="team1goals" required step="1" value="0">
        <input type="text" name="team2name" placeholder="Nazwa drużyny" required>
        <input type="number" name="team2goals" required step="1" value="0">

        <button class="add-form-button">Zapisz</button>
    </form>
</div>


</body>
</html>
