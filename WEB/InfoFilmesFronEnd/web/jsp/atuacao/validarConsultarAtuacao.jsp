<%@page import="bean.Atores"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Usuario"%>
<%@page import="bean.Atuacao"%>
<%@page import="controller.ControllerAtuacao"%>

<%
    String nome = request.getParameter("NOME");
    Atuacao atuacao = new Atuacao (0, null, null);
    atuacao.setA(new Atores(0, nome));
    ControllerAtuacao atuacaoCont = new ControllerAtuacao();
    List<Atuacao> atuacaoList = atuacaoCont.listaAtuacao(atuacao);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + atuacao.getA().getNome() + "&ID=";
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Lista Usuários</title>
    <body>
        <table class="striped responsive-table">
            <thead>
                <tr>
                    <th data-field="Id">Id</th>
                    <th data-field="Nome Ator">NomeAtor</th>   
                    <th data-field="Nome Filme">NomeFilme</th>
                    <th data-field="Excluir">Excluir</th>
                    <th data-field="Alterar">Alterar</th>
                </tr>
            </thead>
            <% if (!(atuacaoList.isEmpty())) { %>    
            <tbody>
                <% for (Atuacao listaAtuacao : atuacaoList) {%>
                <tr>
                    <td><%=listaAtuacao.getId()%></td>
                    <td><%=listaAtuacao.getA().getNome()%></td>
                    <td><%=listaAtuacao.getF().getNome()%></td>
                    <% if (usuLogado.getTipo().equals("ADM")) {%>
                    <td><a href="excluirAtuacao.jsp?<%=url + listaAtuacao.getId()%>">Excluir</a></td>
                    <td><a href="alterarAtuacao.jsp?<%=url + listaAtuacao.getId()%>">Alterar</a></td>
                    <% } %>
                </tr>
                <% } %>
            </tbody>
            <% }%>
        </table>    
    </body>
</html>
