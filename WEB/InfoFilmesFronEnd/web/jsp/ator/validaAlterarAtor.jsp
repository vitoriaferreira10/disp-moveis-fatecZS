<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Atores"%>
<%@page import="controller.ControllerAtores"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String idade = request.getParameter("IDADE");
    int idadeN = Integer.parseInt(idade);
    String sexo = request.getParameter("SEXO");
   
    String pbusca = request.getParameter("PBUSCA");

    Atores ator = new Atores(id,nome,idadeN,sexo);
    ControllerAtores atorCont = new ControllerAtores();
    ator = atorCont.alteraAtores(ator);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarAtor.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>
