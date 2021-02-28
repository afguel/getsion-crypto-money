
	<c:url value="/money" var="lienDetail"></c:url>
	<table class="table table-hover ">
		<thead>
			<tr>	
			id, nom, nombre d'unit�s, prix d'achat, date d'achat, prix actuel, delta.			
				<th>Nom</th>
				<th>Nombre</th>
				<th>achat</th>
				<th>march�</th>
				<th>delta</th>
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" begin="0" end="${ moneys.size()-1}" step="1">
				<c:choose>
					<c:when test="${i%2==0 }">
						<tr class="table-success">
					</c:when>
					<c:when test="${i%2==1 }">
						<tr class="table-danger"
							onClick='window.location.href="http://localhost:8080/jeeExercice/5?id=<c:out value="${i }"></c:out>"'>
					</c:when>

				</c:choose>
				<td><c:out value="${ moneys.get(i).nom}" /></td>
				<td>
				<a class="badge bg-success btn-sm" data-placement="top" data-toggle="tooltip" href="?action=set&id=<c:out value="${moneys.get(i).id}" ></c:out>" data-original-title="Modifier"><i class="fa fa-pencil"></i></a> 
				<a class="badge bg-info btn-sm" data-placement="top" data-toggle="tooltip" href="?action=get&id=<c:out value="${moneys.get(i).id}"></c:out>" data-original-title="Visualiser"><i class="fa fa-eye"></i> </a> 
				<a class="badge bg-danger btn-sm" data-placement="top" data-toggle="tooltip" href="?action=del&id=<c:out value="${moneys.get(i).id}"></c:out>" data-original-title="Supprimer"><i class="fa fa-trash"></i></a>
				</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	