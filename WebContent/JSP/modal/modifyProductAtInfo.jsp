<div id="editElement" class="modal">
	<div class="modal-content">
		<div class="row">
			<div class="col s12">
				<h4>Modifier le produit ${element.getNomProduit()}</h4>
			</div>
			<div class="col s6 input-field">
				<label for="modifyName">Nom du produit</label> <input
					value="${element.getNomProduit()}" type="text" id="modifyName"
					name="modifyName">
			</div>
			<div class="col s6 input-field">
				<label for="modifyPackaging">Nom du pakage</label> <input
					type="text" value="${element.getPackaging()}" id="modifyPackaging"
					name="modifyPackaging">
			</div>
			<div class="col s12">
				<select class="browser-default" id="modifyGrade" name="modifyGrade">
					<option value="" disabled selected>Choisissez votre grade</option>
					<option onclick="$('#button').val('modify');">A</option>
					<option onclick="$('#button').val('modify');">B</option>
					<option onclick="$('#button').val('modify');">C</option>
					<option onclick="$('#button').val('modify');">D</option>
					<option onclick="$('#button').val('modify');">E</option>
				</select>
			</div>
			<div class="col s6 input-field">
				<label for="modifyQuantity">Quantité du produit</label> <input
					type="text" value="${element.getQuantity()}" id="modifyQuantity"
					name="modifyQuantity">
			</div>
			<div class="input-field col s12">
				<textarea id="modifyCategorie" name="modifyCategorie" class="materialize-textarea">${element.getCategorie()}</textarea>
				<label for="modifyCategorie">Catégorie du produit</label>
			</div>
		</div>
		<div class="row">
			<div class="col s12">
				<a
					class="col s12 modal-action modal-close btn-flat dark-purple-outline center-align"
					onclick="">Modifier</a>
			</div>
		</div>
	</div>
</div>