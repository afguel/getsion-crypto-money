<br>
<div class="card col-md-4 col-sm-12 offset-md-4 offset-sm-none">
	<div class="card-header bg-transparent border-success">
		<c:out value="${ money.nom}" />
		<c:out value="${ money.label}" />
		<a	class="badge bg-danger float-right" data-placement="top"
			data-toggle="tooltip" title="Supprimer"
			href="?action=del&id=<c:out value="${money.id}"></c:out>"
			data-original-title="Supprimer"><i class="fa fa-trash fa-blanc"></i></a>
		<a class="badge bg-success float-right" data-placement="top"
			data-toggle="tooltip" title="Modifier"
			href="?action=set&id=<c:out value="${money.id}" ></c:out>"
			data-original-title="Modifier"><i class="fa fa-pencil fa-blanc"></i></a>  
		
	</div>
	<div class="card-body">
		<h1>
			<c:out value="${ money.prix}" />
			<i class="fas fa-euro-sign"></i>
		</h1>
	</div>
</div>

<a href="?action=add" data-toggle="tooltip" data-placement="left"
	title="Ajouter une crypto money"
	class="btn btn-primary btn-lg post-free-add-btn"><i
	class="fa fa-pencil"></i></a>