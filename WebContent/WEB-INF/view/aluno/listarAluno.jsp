<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema Escolar</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>

</head>
<body style="margin-left: 5%; margin-right: 5%;">

<br />
	<c:import url="/WEB-INF/view/comum/menu.jsp" />

<hr> 
	<h3>Filtro Alunos</h3>
	<hr>
	
	<div>
		<form action="filter">
			<div class="form-group">
				<label for="inputNome">Nome</label>
				<input type="text" id="inputNome" class="form-control" name="nome" style="width: 500px;" maxlength="50" value="${aluno.nome}" />
			</div>
			<div class="form-group">
				<label for="inputTurma">Turma</label>
				<input type="text" id="inputTurma" class="form-control" name="turma" style="width: 50px;" maxlength="1" value="${aluno.turma}" />
			</div>
			<div class="form-group">
				<button type="reset" class="btn btn-default"> &nbsp; Limpar &nbsp; </button> &nbsp;
				<button type="submit" class="btn btn-primary"> &nbsp; Filtrar &nbsp; </button>
			</div>
		</form>
	</div>

<hr>
	<h3>Lista Alunos</h3>
	<hr>
	
	<div style="text-align: center; color: red;"> ${mensagem} </div> <br/>

	<table id="tabelaListaAluno" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th style="width: 5%; vertical-align: middle; text-align: center;">Nome</th>
				<th style="width: 25%; vertical-align: middle;">Email</th>
				<th style="width: 10%; vertical-align: middle; text-align: center;">Data de Nascimento</th>
				<th style="width: 10%; vertical-align: middle; text-align: center;">Turma</th>
				<th style="width: 10%; vertical-align: middle; text-align: center;">Imagem</th>
				<th style="width: 15%; vertical-align: middle; text-align: center;">Ações</th>
			</tr>
		</thead>
		<c:forEach var="aluno" items="${listaAluno}">
				<tr>
					<td style="vertical-align: middle; text-align: center;">${aluno.nome}</td>
					<td style="vertical-align: middle;">${aluno.email}</td>
					<td style="vertical-align: middle; text-align: center;"><fmt:formatDate value="${aluno.dataNascimento}" pattern="dd/MM/yyyy" /></td>
			    	<td style="vertical-align: middle; text-align: center;">
			    	<c:choose>
							<c:when test="${not empty aluno.turma}">
								${aluno.turma}
							</c:when>
							<c:otherwise>
								Turma não definida.
							</c:otherwise>
						</c:choose>
			    	</td>
			    	<td style="vertical-align: middle; text-align: center;"> 
			    		<c:choose>
							<c:when test="${not empty aluno.imagem}">
								<img src="<%=request.getContextPath()%>/resources/img/${aluno.imagem}" style="width: 30%;">
							</c:when>
							<c:otherwise>
								Imagem não carregada.
							</c:otherwise>
						</c:choose>
			    	</td>
					<td style="vertical-align: middle; text-align: center;">
						<a href="edit?id=${aluno.id}">Alterar</a> &nbsp; &nbsp;
						<a href="delete?id=${aluno.id}">Remover</a>					
					</td>
				</tr>
		</c:forEach>
	</table>



</body>
</html>