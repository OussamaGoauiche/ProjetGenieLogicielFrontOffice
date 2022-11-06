<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>listerDeanndes</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="./css/style.css" />
<link rel="stylesheet" href="./css/forme.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>

	 <header>
        <nav>
            <div class="logo">
                ENSA KHOURIBGA
            </div>
            <div class="toggle">
                <i class="fas fa-bars ouvrir"></i>
                <i class="fas fa-times fermer"></i>
            </div>
            <ul class="menu">
                <li><a href="AcceuilChef.jsp">Home</a></li>
                <li><a href="<%=request.getContextPath()%>/recevoirDemande">Demandes</a></li>
                <li><a href="<%=request.getContextPath()%>/archiverDemande">Archives</a></li>
                <li><a class="butn" href="#"><% 
                if(session.getAttribute("nom")!=null){
                	out.println((String) session.getAttribute("nom"));
                	%>
                	<li><a class="butn" href="<%=request.getContextPath()%>/logout">
                	logout
                	</a></li>
                	<% 
                }else
                	response.sendRedirect("loginChef.jsp");
                	
                	%>
                	</a></li>
                	
                
            </ul>
        </nav>
    </header>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of des demandes</h3>
			<p style="color: red; font-size: 20px">${message}</p>

			<hr>


			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Description</th>
						<th>Documents</th>
						<th>Terminer</th>
						<th>Rejeter</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="demande" items="${listDemandes}">
						<c:out value="${demande.description}" />
						<tr>
							<td><c:out value="${demande.description}" /></td>
							<td><a href="<c:out value='${demande.url_document}'/>">Télecharger</a></td>
							<td><a
								href="<%=request.getContextPath()%>/Terminer?id=<c:out value='${demande.id}' />">Terminer</a>
							<td><a
								href="<%=request.getContextPath()%>/Rejeter?id=<c:out value='${demande.id}' />">Rejeter</a>


								<!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
          							<button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

</body>
</html>