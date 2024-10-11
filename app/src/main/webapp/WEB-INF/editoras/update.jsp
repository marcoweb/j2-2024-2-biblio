<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Editar Editora</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <h1>Editar Editora</h1>
            <form action="/editoras/update" method="post">
                <input type="hidden" name="id" value="${editora.id}" />
                <div>
                    <label for="nome">Nome:</label>
                    <input type="text" name="nome" value="${editora.nome}" />
                </div>
                <div>
                    <label for="cidade">Cidade:</label>
                    <input type="text" name="cidade" value="${editora.cidade}" />
                </div>
                <br />
                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>
</html>