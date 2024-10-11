<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Nova Editora</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <h1>Nova Editora</h1>
            <form action="/editoras/insert" method="post">
                <div>
                    <label for="nome">Nome:</label>
                    <input type="text" name="nome" />
                </div>
                <div>
                    <label for="cidade">Cidade:</label>
                    <input type="text" name="cidade" />
                </div>
                <br />
                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>
</html>