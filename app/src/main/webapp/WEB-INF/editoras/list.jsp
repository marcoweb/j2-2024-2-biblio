<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Editoras</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <h1>Editoras</h1>
            <a href="/editoras/insert" class="btn btn-primary">Nova Editora</a>
            <table class="table">
                <tr>
                    <th>id</th>
                    <th>nome</th>
                    <th>cidade</th>
                </tr>
                <c:forEach var="g" items="${editoras}">
                    <tr>
                        <td>${g.id}</td>
                        <td>${g.nome}</td>
                        <td>${g.cidade}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>