<br>
<div class="card col-4 offset-4">
	<div class="card-header bg-transparent border-success">
		<c:out value="${ money.nom}" />
		<c:out value="${ money.label}" />
		<a class="badge bg-success pull-right" data-placement="top"
			data-toggle="tooltip" title="Modifier"
			href="?action=set&id=<c:out value="${money.id}" ></c:out>"
			data-original-title="Modifier"><i class="fa fa-pencil"></i></a>  
		<a	class="badge bg-danger pull-right" data-placement="top"
			data-toggle="tooltip" title="Supprimer"
			href="?action=del&id=<c:out value="${money.id}"></c:out>"
			data-original-title="Supprimer"><i class="fa fa-trash"></i></a>
	</div>
	<div class="card-body">
		<h1>
			<c:out value="${ money.prix}" />
			<i class="fas fa-euro-sign"></i>
		</h1>
	</div>
</div>

