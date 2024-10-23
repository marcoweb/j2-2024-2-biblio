<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Livros</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <h1>Livros</h1>
            <a href="/livros/insert" class="btn btn-primary">Novo Livro</a>
            <table class="table">
                <tr>
                    <th>id</th>
                    <th>titulo</th>
                    <th>genero</th>
                    <th>editora</th>
                </tr>
                <c:forEach var="l" items="${livros}">
                    <tr>
                        <td>${l.id}</td>
                        <td>${l.titulo}</td>
                        <td>${l.genero.nome}</td>
                        <td>${l.editora.nome}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>