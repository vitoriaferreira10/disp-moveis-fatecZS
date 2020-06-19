<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Atores"%>
<%@page import="controller.ControllerAtores"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Atores ator = new Atores(id,"",0,"");
    ControllerAtores atorCont = new ControllerAtores();
    ator = atorCont.buscaAtoresPorId(ator);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Alterar Ator</title>
    <body>
       <div class="container"/>
       <h1>Alterar Ator</h1>
        <form name="alterarAtor" action="validaAlterarAtor.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=ator.getNome()%>"> <br>
            Idade: <input type="number" name="IDADE" value="<%=ator.getIdade()%>"> <br>
            Sexo: <input type="text" name="SEXO" value="<%=ator.getSexo()%>"> <br>
         
            <input type="HIDDEN" name="ID" value="<%=ator.getIdAtor()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>
