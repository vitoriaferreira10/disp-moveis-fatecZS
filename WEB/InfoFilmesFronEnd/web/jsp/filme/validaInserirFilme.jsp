<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Filmes"%>
<%@page import="controller.ControllerFilmes"%>



<%
    String nome = request.getParameter("NOME");
    String genero = request.getParameter("GENERO");
    String ano = request.getParameter("ANO");
    int anoN = Integer.parseInt(ano);
    
    Filmes filme = new Filmes(0,nome,genero,anoN);
    ControllerFilmes filmecont = new ControllerFilmes();
    filme = filmecont.inserirFilmes(filme); 

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirFilme.jsp";
    response.sendRedirect(url);
%>