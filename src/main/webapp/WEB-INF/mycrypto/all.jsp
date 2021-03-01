
<c:url value="/money" var="lienDetail"></c:url>
<table class="table table-hover ">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>Nombre</th>
			<th>Achat</th>
			<th>Date</th>
			<th>Marché</th>
			<th>Delta</th>
			<th>Action</th>
			</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${moneys.size()>0}">
				<c:forEach var="i" begin="0" end="${ moneys.size()-1}" step="1">
					<c:choose>
						<c:when
							test="${moneys.get(i).cryptoId.prix > moneys.get(i).prixAchat}">
							<tr class="table-success">
						</c:when>
						<c:when
							test="${moneys.get(i).cryptoId.prix < moneys.get(i).prixAchat }">
							<tr class="table-danger"
								onClick='window.location.href="http://localhost:8080/jeeExercice/5?id=<c:out value="${i }"></c:out>"'>
						</c:when>

					</c:choose>
					<td><c:out value="${ moneys.get(i).id}" /></td>
					<td><c:out value="${ moneys.get(i).cryptoId.nom}" /></td>
					<td><c:out value="${ moneys.get(i).nombreUnite}" /></td>
					<td><c:out value="${ moneys.get(i).prixAchat}" /></td>
					<td><c:out value="${ moneys.get(i).date}" /></td>
					<td><c:out value="${ moneys.get(i).cryptoId.prix}" /></td>
					<td><c:out
							value="${ ( moneys.get(i).cryptoId.prix - moneys.get(i).prixAchat) * moneys.get(i).nombreUnite }" /></td>

					<td><a class="badge bg-success " data-placement="top"
						data-toggle="tooltip"
						href="?action=set&id=<c:out value="${moneys.get(i).id}" ></c:out>"
						data-original-title="Modifier"><i
							class="fa fa-pencil fa-blanc"></i></a> <a class="badge bg-info "
						data-placement="top" data-toggle="tooltip"
						href="?action=get&id=<c:out value="${moneys.get(i).id}"></c:out>"
						data-original-title="Visualiser"><i class="fa fa-eye fa-blanc"></i>
					</a> <a class="badge bg-danger " data-placement="top"
						data-toggle="tooltip"
						href="?action=del&id=<c:out value="${moneys.get(i).id}"></c:out>"
						data-original-title="Supprimer"><i
							class="fa fa-trash fa-blanc"></i></a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:when test="${moneys.size()==0}">
			     Aucun enregistrement
			</c:when>
		</c:choose>
	</tbody>
</table>
<a href="?action=add" data-toggle="tooltip" data-placement="left"
	title="Ajouter une crypto money"
	class="btn btn-primary btn-lg post-free-add-btn"><i
	class="fa fa-pencil"></i></a>

