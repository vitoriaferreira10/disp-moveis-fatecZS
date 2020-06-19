<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Usuario"%>
<%@page import="bean.Filmes"%>
<%@page import="controller.ControllerFilmes"%>

<%
    String nome = request.getParameter("NOME");
    Filmes  filme = new Filmes(0,nome,"",0);
    ControllerFilmes filmecont = new ControllerFilmes();
    List<Filmes> filmeList = filmecont.listaFilmes(filme);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + filme.getNome() +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Lista Filmes</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="Genero">Genero</th>
                  <th data-field="Ano">Ano</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(filmeList.isEmpty())) { %>    
                <tbody>
                    <% for (Filmes listaFilmes : filmeList) { %>
                        <tr>
                            <td><%=listaFilmes.getId()%></td>
                            <td><%=listaFilmes.getNome()%></td>
                            <td><%=listaFilmes.getGenero()%></td>
                            <td><%=listaFilmes.getAno()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirFilme.jsp?<%=url + listaFilmes.getId()%>">Excluir</a></td>
                                <td><a href="alterarFilme.jsp?<%=url + listaFilmes.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>
