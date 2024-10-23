<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Editar Livro</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <h1>Editar Livro</h1>
            <form action="/livros/update" method="post">
                <input type="hidden" name="id" value="${livro.id}" />
                <div class="mb-3">
                    <label class="form-label">Título</label>
                    <input type="text" class="form-control" name="titulo" value="${livro.titulo}" />
                </div>
                <div class="mb-3">
                    <label class="form-label">Genero</label>
                    <select name="genero" class="form-select">
                        <c:forEach var="g" items="${generos}">
                            <option ${livro.genero.id == g.id ? "selected" :""} value="${g.id}">${g.nome}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Editora</label>
                    <select name="editora" class="form-select">
                        <c:forEach var="e" items="${editoras}">
                            <option ${livro.editora.id == e.id ? "selected" : ""} value="${e.id}">${e.nome}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>
</html>