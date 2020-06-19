<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Usuario"%>
<%@page import="bean.Atores"%>
<%@page import="controller.ControllerAtores"%>

<%
    String nome = request.getParameter("NOME");
    Atores  ato = new Atores(0,nome,0,"");
    ControllerAtores atorcont = new ControllerAtores();
    List<Atores> ator = atorcont.listaAtores(ato);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + ato.getNome() +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Lista Usuários</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="Idade">Idade</th>
                  <th data-field="Sexo">Sexo</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(ator.isEmpty())) { %>    
                <tbody>
                    <% for (Atores listaAtores : ator) { %>
                        <tr>
                            <td><%=listaAtores.getIdAtor()%></td>
                            <td><%=listaAtores.getNome()%></td>
                            <td><%=listaAtores.getIdade()%></td>
                            <td><%=listaAtores.getSexo()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirAtor.jsp?<%=url + listaAtores.getIdAtor()%>">Excluir</a></td>
                                <td><a href="alterarAtor.jsp?<%=url + listaAtores.getIdAtor()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>
