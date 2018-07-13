<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Aluno</title>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>

</head>
<body style="margin-left: 5%; margin-right: 5%;">

	<c:import url="/WEB-INF/view/comum/menu.jsp" />

	<hr>
	<h3>Incluir Aluno</h3>
	<hr>

	<div style="text-align: center; color: red;">${mensagem}</div>

	<form action="update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${aluno.id}">

		<div class="form-group">
			<label for="inputNome">Nome</label> <input type="text" id="inputNome"
				class="form-control" name="nome" style="width: 500px;"
				maxlength="50" required="required" value="${aluno.nome}" />
		</div>

		<div class="form-group">
			<label for="inputEmail">Email</label> <input type="text"
				id="inputEmail" class="form-control" name="email"
				style="width: 500px;" maxlength="80" required="required"
				value="${aluno.email}" />
		</div>
		<div class="form-group">
			<label for="inputGarantia">Data de Nascimento</label> <input
				type="text" id="inputDataNascimento" class="form-control"
				name="dataNascimento" style="width: 100px;" required="required"
				value="<fmt:formatDate value="${aluno.dataNascimento}" pattern="dd/MM/yyyy" />" />
		</div>

		<div class="form-group">
			<label for="inputQuantidade">Turma</label> <input type="text"
				id="inputTurma" class="form-control" name="turma" maxlenght="1"
				style="width: 50px;" required="required" value="${aluno.turma}" />
		</div>

		<div class="form-group">
			<label for="inputImagem">Imagem do Aluno</label> <input type="file"
				id="inputImagem" name="file"> <img
				src="<%=request.getContextPath()%>/resources/img/${aluno.imagem}"
				style="width: 30%;">
		</div>

		<div class="form-group">
			<label for="curso">Curso</label> <br /> <select
				id="curso" name="curso">
				<option value="">Selecione</option>
				<c:forEach items="${listaCurso}" var="obj">
					<option value="${obj.id}"
						<c:if test="${obj.id eq aluno.curso.id}">selected="selected"</c:if>>
						${obj.nome}</option>
				</c:forEach>
			</select>
		</div>


		<br />

		<div class="form-group">
			<a href="list" class="btn btn-danger" role="button">Cancelar</a>
			&nbsp;
			<button type="reset" class="btn btn-default">&nbsp; Limpar
				&nbsp;</button>
			&nbsp;
			<button type="submit" class="btn btn-primary">&nbsp; Alterar
				&nbsp;</button>
		</div>

	</form>

</body>
</html>