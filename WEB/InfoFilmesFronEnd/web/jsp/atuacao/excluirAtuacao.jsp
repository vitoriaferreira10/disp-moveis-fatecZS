<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Atuacao"%>
<%@page import="controller.ControllerAtuacao"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Atuacao atuacao = new Atuacao (id, null, null);
    ControllerAtuacao atuacaoCont = new ControllerAtuacao();
    atuacao = atuacaoCont.excluiAtuacao(atuacao);
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validarConsultarAtuacao.jsp?NOME=";
    response.sendRedirect(url);
%>