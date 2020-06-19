<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bean.Atores"%>
<%@page import="bean.Filmes"%>

<%@page import="controller.ControllerAtores"%>
<%@page import="controller.ControllerFilmes"%>

<%
    ControllerAtores atorCont = new ControllerAtores();
    List<Atores> atorList = atorCont.listaTodos();

    ControllerFilmes filmeCont = new ControllerFilmes();
    List<Filmes> filmeList = filmeCont.listaTodos();

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Inserir Atuação</title>
    <body>
        <div class="container"/>
            <h1>Inserir Atuação</h1>
            <form name="inserirAtuacao" action="validarInserirAtuacao.jsp" method="POST">
                <table>
                    <tr>
                        <td>Ator:</td>
                        <td>
                            <select NAME ="ID_ATOR" class="browser-default">
                                <% for (Atores ator : atorList) { %>
                                    <option value="<%=ator.getIdAtor()%>"><%=ator.getNome()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Filme</td>
                        <td>
                            <select NAME="ID_FILME" class="browser-default">
                                <% for (Filmes filme : filmeList) { %>
                                    <option value="<%=filme.getId()%>"><%=filme.getNome()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                </table>    
                <input type="submit" name="Enviar" value="Enviar">  <br>
            </form>
        </div>                     
    </body>
</html>
