<c:url value="/" var="lienMoney"></c:url>

<br>
<div class="card col-4 offset-4">
	<div class="card-header bg-transparent border-success">Ajouter
		une crypto money</div>
	<div class="card-body">
		<h4 style='color: red; font-weight: bold;'>
			<c:out value="${ message }" />
		</h4>
		<form action='${lienMoney}' method='post'>
			<div class="">
				<div class="mb-3">
					<input type="number" class="form-control" id="nombre" name="nombre"
						placeholder="Nombre d'unités" onChange='myStopped()'
						value="${mycrypto.nombreUnite}">
				</div>		
				
				<input type="hidden"  name="id"  value= "<c:out value="${mycrypto.id}" />" >
				<input type="hidden" name="action" value="set">

				<button id="submit" type="submit" class="btn btn-success float-end"
					disabled=true>Envoyer</button>
			</div>
		</form>

	</div>
</div>

