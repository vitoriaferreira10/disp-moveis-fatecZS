<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Atores"%>
<%@page import="controller.ControllerAtores"%>



<%
    String nome = request.getParameter("NOME");
    
    String idade = request.getParameter("IDADE");
    int idadeN = Integer.parseInt(idade);
  
    String sexo = request.getParameter("SEXO");
    
    Atores ator = new Atores(0,nome,idadeN,sexo);
    ControllerAtores atorcont = new ControllerAtores();
    ator = atorcont.inserirAtores(ator); 

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirAtor.jsp";
    response.sendRedirect(url);
%>