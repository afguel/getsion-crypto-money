
<h4 style='color: red; font-weight: bold;'>
	<c:out value="${ message }" />
</h4>

<div class="card col-4 offset-4">
	<div class="card-header bg-transparent border-success">Ajouter une crypto money</div>
	<div class="card-body">
		<h4 style='color: red; font-weight: bold;'>
			<c:out value="${ message }" />
		</h4>
		<form action='/money' method='post'>
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
					<input type="text" class="form-control" id="prix" name="prix"
						placeholder='Prix actuel' onkeyup='stoppedTyping()'>
				</div>
				<button id="submit" type="submit" class="btn btn-success float-end"
					disabled=true>Envoyer</button>
			</div>
		</form>

	</div>
</div>

