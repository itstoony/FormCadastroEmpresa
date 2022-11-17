<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List" %>
<%@ page import="br.com.caelum.gerenciador.modelo.Empresa" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Empresas</title>
</head>
<body>
<h2>Lista de Empresas</h2>

    <h4>Usuario logado: ${usuarioLogado.login}</h4>
    <ul>
        <c:forEach items="${listaDeEmpresas}" var="empresa">
            <li>
                    ${empresa.nome} <fmt:formatDate value="${empresa.dataDeAbertura}" pattern="dd/MM/yyyy"/>
                    <a href="entrada?acao=RemoveEmpresa&id=${empresa.id}">Remover</a>
            </li>
        </c:forEach>
    </ul>

    <c:import url="logout-parcial.jsp"/>

</body>
</html>
