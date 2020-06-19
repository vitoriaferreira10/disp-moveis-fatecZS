<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Inserir Filme</title>
    <body>
       <div class="container"/>
        <h1>Inserir Filme</h1>
        <form name="inserirFilme" action="validaInserirFilme.jsp" method="post">
            Nome: <input type="text" name="NOME" value=""> <br>
            Genero: <input type="text" name="GENERO" value=""> <br>
            Ano: <input type="number" name="ANO" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
