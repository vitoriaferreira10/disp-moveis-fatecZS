<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Filmes"%>
<%@page import="controller.ControllerFilmes"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Filmes filme = new Filmes(id, "", "", 0);
    ControllerFilmes atorCont = new ControllerFilmes();
    filme = atorCont.excluiFilmes(filme);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarFilme.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>