<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Załóż konto</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<c:import url="part/header.jsp"/>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form method="post" action="/register">
        <div class="form-group">
            <input type="text" name="login" placeholder="Podaj swój login"/>
        </div>
        <div class="form-group">
            <input type="text" name="firstName" placeholder="Imię"/>
        </div>
        <div class="form-group">
            <input type="text" name="lastName" placeholder="Nazwisko"/>
        </div>
        <div class="form-group">
            <input type="email" name="email" placeholder="Email"/>
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło"/>
        </div>
        <div class="form-group">
            <input type="password" name="password2" placeholder="Powtórz hasło"/>
        </div>

        <div class="form-group form-group--buttons">
            <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
        <sec:csrfInput/>
    </form>
</section>
<c:import url="part/footer.jsp"/>
<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>