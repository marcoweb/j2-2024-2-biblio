<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Editar Gênero</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
        <h1>Editar Gênero</h1>
            <form action="/generos/update" method="post">
                <input type="hidden" name="id" value="${genero.id}" />
                <div>
                    <label for="nome">Nome:</label>
                    <input type="text" name="nome" value="${genero.nome}" />
                </div>
                <br />
                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>
</html>