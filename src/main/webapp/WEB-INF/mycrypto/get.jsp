<div class="card col-4 offset-4">
	<div class="card-header bg-transparent border-success">
	    <c:out value="${ money.nom}" /> <c:out value="${ money.label}" />
		<a class="badge bg-success btn-sm" data-placement="top" data-toggle="tooltip" href="<c:out value="money/${moneys.get(i).id}" ></c:out>" data-original-title="Modifier"><i class="fa fa-pencil"></i></a> 
		<a class="badge bg-danger btn-sm" data-placement="top" data-toggle="tooltip" href="<c:out value="money/${moneys.get(i).id}"></c:out>" data-original-title="Supprimer"><i class="fa fa-trash"></i></a>
	</div>
	<div class="card-body">
		  <h1>
		  <c:out value="${ money.prix}" /> <i class="fas fa-euro-sign"></i>
		  </h1>   
	</div>
</div>

