<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
    <html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
        <title>Document</title>
    </head>
    <body>
        <div class="container">
            <h1>Remover Editora</h1>
            <p>
                Tem certeza que deseja remover a editora ${editora.nome} ?
            </p>
            <form action="/editoras/delete" method="post">
                <input type="hidden" name="id" value="${editora.id}" />
                <button type="submit" class="btn btn-danger">Remover</button>
            </form>
        </div>
    </body>
</html>