<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/entrada?acao=NovaEmpresa" method="POST">
  Nome: <input type="text" name="nome">
  Data: <input type="date" name="data"> <br>
    <a href="/entrada?acao=ListaEmpresa">Empresas Cadastradas</a> <br>
  <input type="submit">
</form>
<c:import url="logout-parcial.jsp"/>
</body>
</html>