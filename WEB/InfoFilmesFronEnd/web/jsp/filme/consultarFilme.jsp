<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Consultar Filme</title>
    <body>
       <div class="container"/>
       <h1>Consultar Filme</h1>
       <form name="consultarFilme" action="validaConsultarFilme.jsp" method="post">
           Nome: <input type="text" name ="NOME" value=""> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>