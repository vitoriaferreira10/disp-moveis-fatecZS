<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Filmes"%>
<%@page import="controller.ControllerFilmes"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String genero = request.getParameter("GENERO");
    String ano = request.getParameter("ANO");
    int anoN = Integer.parseInt(ano);
   
    String pbusca = request.getParameter("PBUSCA");

    Filmes filme = new Filmes(id,nome,genero,anoN);
    ControllerFilmes filmeCont = new ControllerFilmes();
    filme = filmeCont.alteraFilmes(filme);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarFilme.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>
