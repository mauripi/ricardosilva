<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="pt-br">
<head>
    <link href="<c:url value="/resources/css/jquery-ui.min.css" />" rel="stylesheet"/>
    <script src="<c:url value="/resources/js/jquery-3.1.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
    
<script>
$( function() {
    $( "#dataFinalizacao" ).datepicker({
        dateFormat: 'dd/mm/yy',
        dayNames: ['Domingo','Segunda','Ter�a','Quarta','Quinta','Sexta','S�bado'],
        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','S�b','Dom'],
        monthNames: ['Janeiro','Fevereiro','Mar�o','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
        nextText: 'Pr�ximo',
        prevText: 'Anterior'
    });
  } );
</script>
</head>
<body>
  <h3>Alterar tarefa - ${tarefa.id}</h3>
  <form action="alteraTarefa" method="post">

    <input type="hidden" name="id" value="${tarefa.id}" />
  
    Descri��o:<br />
    <textarea name="descricao" cols="100" rows="5"> ${tarefa.descricao} </textarea>
    <br />      

    Finalizado? <input type="checkbox" name="finalizado" 
      value="true" ${tarefa.finalizado? 'checked' : '' }/> <br />      

    Data de finaliza��o: <br />
    <input type="text" name="dataFinalizacao" id="dataFinalizacao"
      value="<fmt:formatDate value="${tarefa.dataFinalizacao}" pattern="dd/MM/yyyy" />"/> 
    <br />
  
    <input type="submit" value="Alterar"/>
  </form>
</body>
</html>