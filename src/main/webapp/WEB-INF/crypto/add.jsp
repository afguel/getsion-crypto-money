<c:url value="/money" var="lienMoney"></c:url>
<h4 style='color: red; font-weight: bold;'>
	<c:out value="${ message }" />
</h4>

<div class="card col-md-4 col-sm-12 offset-md-4 offset-sm-none">
	<div class="card-header bg-transparent border-success">Ajouter une crypto money</div>
	<div class="card-body">
		<h4 style='color: red; font-weight: bold;'>
			<c:out value="${ message }" />
		</h4>
		<form action='${lienMoney}' method='post'>
			<div class="">
				<div class="mb-3">
					<input type="text" class="form-control" id="nom" name="nom"
						placeholder='Nom' onkeyup='stoppedTyping()'>
				</div>
				<div class="mb-3">
					<input type="text" class="form-control" id="label" name="label"
						placeholder='Label' onkeyup='stoppedTyping()'>
				</div>
				<div class="mb-3">
					<input type="number" step="0.01" class="form-control" id="prix" name="prix"
						placeholder='Prix actuel' onkeyup='stoppedTyping()'>
				</div>
			
				<input type="hidden"  name="action" value="add"	>
				
				<button id="submit" type="submit" class="btn btn-success float-end"
					disabled=true>Envoyer</button>
			</div>
		</form>

	</div>
</div>

