<%@page import="bean.Filmes"%>
<%@page import="bean.Atores"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Atuacao"%>
<%@page import="controller.ControllerAtuacao"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    int idAtor = Integer.parseInt(request.getParameter("ID_ATOR"));
    int idFilme = Integer.parseInt(request.getParameter("ID_FILME"));
    

    Atuacao atuacao = new Atuacao(id,new Atores(idAtor),new Filmes(idFilme));
    ControllerAtuacao atuacaoCont = new ControllerAtuacao();
    atuacao = atuacaoCont.alteraAtuacao(atuacao);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validarConsultarAtuacao.jsp?NOME=";
    response.sendRedirect(url);
%>
