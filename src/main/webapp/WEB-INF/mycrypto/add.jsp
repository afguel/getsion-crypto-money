<c:url value="/" var="lienMoney"></c:url>

<br>
<div class="card col-md-4 col-sm-12 offset-md-4 offset-sm-none">
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
						placeholder="Nombre d'unités" onChange='myStoppedTyping()'>
				</div>
				<div class="mb-3"  >
					<select name="cryptoId" id="cryptoId" class="form-control" onChange='myStoppedTyping()'>
						<option value="">--Please choose an option--</option>
						<c:forEach var="crypto" items="${moneys}">
						    <option value="${ crypto.id}">${ crypto.nom}</option>
						</c:forEach>
					</select>
				</div>

				<input type="hidden" name="action" value="add">

				<button id="submit" type="submit" class="btn btn-success float-end"
					disabled=true>Envoyer</button>
			</div>
		</form>

	</div>
</div>

