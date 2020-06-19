<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Atuacao"%>
<%@page import="controller.ControllerAtuacao"%>
<%@page import="controller.ControllerAtores"%>
<%@page import="controller.ControllerFilmes"%>
<%@page import="java.util.List"%>
<%@page import="bean.Atores"%>
<%@page import="bean.Filmes"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Atuacao atuacao = new Atuacao(id,null,null);
    ControllerAtuacao atuacaoCont = new ControllerAtuacao();
    atuacao = atuacaoCont.buscaAtuacaoPorId(atuacao);
    String pbusca = request.getParameter("PBUSCA");
    
    ControllerAtores atorCont = new ControllerAtores();
    List<Atores> atorList = atorCont.listaTodos();

    ControllerFilmes filmeCont = new ControllerFilmes();
    List<Filmes> filmeList = filmeCont.listaTodos();

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Alterar Atuação</title>
    <body>
        <div class="container"/>
            <h1>Alterar Atuação</h1>
            <form name="alterarAtuacao" action="validaAlterarAtuacao.jsp" method="POST">
                <table>
                    <tr>
                        <td>Ator:</td>
                        <td>
                            <select NAME ="ID_ATOR" class="browser-default">
                                <% for (Atores ator : atorList) { %>
                                    <% if (atuacao.getA().getIdAtor() == ator.getIdAtor()) { %>
                                        <option selected value="<%=ator.getIdAtor()%>"><%=ator.getNome()%></option>
                                    <% } else { %>
                                        <option value="<%=ator.getIdAtor()%>"><%=ator.getNome()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Filme</td>
                        <td>
                            <select NAME="ID_FILME" class="browser-default">
                                <% for (Filmes filme : filmeList) { %>
                                    <% if (atuacao.getF().getId() == filme.getId()) {%>
                                        <option selected value="<%=filme.getId()%>"><%=filme.getNome()%></option>
                                    <%} else {%>
                                        <option value="<%=filme.getId()%>"><%=filme.getNome()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                </table>    
                <input type="submit" name="Enviar" value="Enviar">  <br>
                <input type="HIDDEN" name="ID" value="<%=atuacao.getId()%>"> <br>
            </form>
        </div>                     
    </body>
</html>
