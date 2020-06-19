<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Usuario"%>
<%@page import="controller.ControllerUsuario"%>

<%
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    Usuario usu = new Usuario(0, "", login, senha, "", "");
    ControllerUsuario usucont = new ControllerUsuario();
    usu = usucont.validaUsuario(usu);
    session.setAttribute("UsuarioLogado", usu);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>InfoFilmes</title>
    <body>
        <% if (!usu.getStatus().equals("")) { %>
        <!-- Dropdown1 Trigger -->
        <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown1'>Manter Controle de Usuário</a>     
        <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown2'>Manter Controle de Atores</a>
        <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown3'>Manter Controle de Filmes</a>
        <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown4'>Manter Controle de Atuação</a>

        <% if (usu.getTipo().equals("ADM")) { %>
        <!-- Dropdown1 Structure -->
        <ul id='dropdown1' class='dropdown-content'>
            <li><a href="../usuario/inserirUsuario.jsp"> Inserir Usuário </a></li>
            <li><a href="../usuario/consultarUsuario.jsp"> Consultar Usuário </a></li>
        </ul>

        <% } else { %>
        <ul id='dropdown1' class='dropdown-content'>
            <li><a href="../usuario/consultarUsuario.jsp"> Consultar Usuário </a></li>
        </ul>
        <% }%>

        <% if (usu.getTipo().equals("ADM")) { %>
        <ul id='dropdown2' class='dropdown-content'>
            <li><a href="../ator/inserirAtor.jsp"> Inserir Ator </a></li>
            <li><a href="../ator/consultarAtor.jsp"> Consultar Ator </a></li>
        </ul>

        <% } else { %>
        <ul id='dropdown2' class='dropdown-content'>
            <li><a href="../ator/consultarAtor.jsp"> Consultar Ator </a></li>
        </ul>
        <% }%>

        <% if (usu.getTipo().equals("ADM")) { %>
        <ul id='dropdown3' class='dropdown-content'>
            <li><a href="../filme/inserirFilme.jsp"> Inserir Filme </a></li>
            <li><a href="../filme/consultarFilme.jsp"> Consultar Filme </a></li>
        </ul>

        <% } else { %>
        <ul id='dropdown3' class='dropdown-content'>
            <li><a href="../filme/consultarFilme.jsp"> Consultar Filme </a></li>
        </ul>
        <% }%>
        <% if (usu.getTipo().equals("ADM")) { %>
        <ul id='dropdown4' class='dropdown-content'>
            <li><a href="../atuacao/inserirAtuacao.jsp"> Inserir Atuação </a></li>
            <li><a href="../atuacao/consultarAtuacao.jsp"> Consultar Atuação </a></li>
        </ul>

        <% } else { %>
        <ul id='dropdown4' class='dropdown-content'>
            <li><a href="../atuacao/consultarAtuacao.jsp"> Consultar Atuação </a></li>
        </ul>
        <% }%>

        <% } else { %>
        <h1>USUÁRIO INVÁLIDO</h1>
        <% }%>
    </body>
</html>
