<br>
<div class="card col-4 offset-4">
	<div class="card-header bg-transparent border-success">
	   <c:out value="${ mycrypto.cryptoId.nom}" /> 
				<a class="badge bg-success float-right" data-placement="top" data-toggle="tooltip" href="?action=set&id=<c:out value="${moneys.get(i).id}" ></c:out>" data-original-title="Modifier"><i class="fa fa-pencil fa-blanc"></i></a>  
				<a class="badge bg-danger float-right" data-placement="top" data-toggle="tooltip" href="?action=del&id=<c:out value="${moneys.get(i).id}"></c:out>" data-original-title="Supprimer"><i class="fa fa-trash fa-blanc"></i></a>
				</div>
	<div class="card-body">
	      <h4>
	      Nbr d'unité : <c:out value="${ mycrypto.nombreUnite}" /> <c:out value="${ mycrypto.cryptoId.label}" /><br>
	      Date d'achat :<c:out value="${ mycrypto.date}" /> 
	      </h4>
		  <h1>
		  
		  Prix d'achat :<c:out value="${ mycrypto.prixAchat}" /> <i  class="fas fa-euro-sign"></i>
		  </h1>   
	</div>
</div>
<a href="?action=add" data-toggle="tooltip" data-placement="left" title="Ajouter une crypto money" class="btn btn-primary btn-lg post-free-add-btn"><i class="fa fa-pencil"></i></a>

