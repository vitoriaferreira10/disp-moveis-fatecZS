<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Filmes"%>
<%@page import="controller.ControllerFilmes"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Filmes filme = new Filmes(id,"","",0);
    ControllerFilmes filmeCont = new ControllerFilmes();
    filme = filmeCont.buscaFilmesPorId(filme);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Alterar Filme</title>
    <body>
       <div class="container"/>
       <h1>Alterar Filme</h1>
        <form name="alterarFilme" action="validaAlterarFilme.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=filme.getNome()%>"> <br>
            Genero: <input type="text" name="GENERO" value="<%=filme.getGenero()%>"> <br>
            Ano: <input type="text" name="ANO" value="<%=filme.getAno()%>"> <br>
         
            <input type="HIDDEN" name="ID" value="<%=filme.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>
