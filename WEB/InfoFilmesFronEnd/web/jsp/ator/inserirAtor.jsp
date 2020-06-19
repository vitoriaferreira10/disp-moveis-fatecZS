<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Inserir Ator</title>
    <body>
       <div class="container"/>
        <h1>Inserir Ator</h1>
        <form name="inserirAtor" action="validaInserirAtor.jsp" method="post">
            Nome: <input type="text" name="NOME" value=""> <br>
            Idade <input type="number" name="IDADE" value=""> <br>
            Sexo <input type="text" name="SEXO" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>

