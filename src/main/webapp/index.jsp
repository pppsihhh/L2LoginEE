<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Prog Academy</title>
  </head>
  <body>
    <% String login = (String) session.getAttribute("user_login"); %>
    <% String age = (String) session.getAttribute("user_age"); %>
    <% String userAccess = (String) session.getAttribute("user_older"); %>
    <% String wrongLogin = (String) session.getAttribute("wrong_login"); %>
    <% String wrongPass = (String) session.getAttribute("wrong_pass"); %>
    <% String smallPass = (String) session.getAttribute("small_pass"); %>
    <% String ageEmpty = (String) session.getAttribute("age_empty"); %>

    <% if (userAccess != null) { %>
    <h1>You are so small</h1>
    <br>Click this link to <a href="/login?a=exit">logout</a>
    <% } else if (login == null || "".equals(login)) { %>
        <form action="/login" method="POST">
            Login: <input type="text" name="login">
            <% if (wrongLogin != null) {%>
            wrong logon <br>
            <% } else {%>
            <br>
            <% } %>
            Password: <input type="password" name="password">
            <% if (wrongPass != null) {%>
            wrong password <br>
            <%} else if (smallPass != null) {%>
            It's too small password <br>
            <% } else { %>
            <br>
            <% } %>
            Age: <input type="text" name="age">
            <% if (ageEmpty != null) { %>
            these fields are required <br>
            <% } else { %>
            <br>
            <% } %>
            <input type="submit" />
        </form>
    <% } else { %>
        <h1>You are logged in as: <%= login %></h1> <br>
        <h1>You are <%= age %> years old</h1>
        <br>Click this link to <a href="/login?a=exit">logout</a>
    <% } %>
  </body>
</html>
