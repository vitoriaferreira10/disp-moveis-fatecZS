<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Atores"%>
<%@page import="controller.ControllerAtores"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Atores ator = new Atores(id, "", 0, "");
    ControllerAtores atorCont = new ControllerAtores();
    ator = atorCont.excluiAtores(ator);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarAtor.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>
