<%@page import="bean.Filmes"%>
<%@page import="bean.Atores"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Atuacao"%>
<%@page import="controller.ControllerAtuacao"%>

<%
    int idAtor = Integer.parseInt(request.getParameter("ID_ATOR"));
    int idFilme = Integer.parseInt(request.getParameter("ID_FILME"));
    
    
    Atuacao atuacao = new Atuacao(0,new Atores(idAtor),new Filmes(idFilme));
    ControllerAtuacao atuacaoCont = new ControllerAtuacao();
    atuacao = atuacaoCont.inserirAtuacao(atuacao);
    
// REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirAtuacao.jsp";
    response.sendRedirect(url);

%>