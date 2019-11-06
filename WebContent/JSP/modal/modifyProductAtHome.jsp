<div id="editElement${element.getId()}" class="modal">
	<div class="modal-content">
		<div class="row">
			<div class="col s12">
				<h4>Modifier le produit ${element.getNomProduit()}</h4>
			</div>
			<div class="col s12 input-field">
				<label for="modifyName${element.getId()}">Nom du produit</label> <input
					value="${element.getNomProduit()}" type="text" id="modifyName${element.getId()}"
					name="modifyName${element.getId()}">
			</div>
			<div class="col s12">
				<select class="browser-default" id="modifyGrade${element.getId()}" name="modifyGrade${element.getId()}">
					<option id="Grade${element.getId()}A">A</option>
					<option id="Grade${element.getId()}B">B</option>
					<option id="Grade${element.getId()}C">C</option>
					<option id="Grade${element.getId()}D">D</option>
					<option id="Grade${element.getId()}E">E</option>
				</select>
			</div>
			<div class="col s6 input-field">
				<label for="modifyQuantity${element.getId()}">Quantité du produit</label> <input
					type="text" value="${element.getQuantity()}" id="modifyQuantity${element.getId()}"
					name="modifyQuantity${element.getId()}">
			</div>
			<div class="col s6 input-field">
				<label for="modifyPackaging${element.getId()}">Nom de l'emballage</label> <input
					type="text" value="${element.getPackaging()}" id="modifyPackaging${element.getId()}"
					name="modifyPackaging${element.getId()}">
			</div>
			<div class="col s6 input-field">
				<input id="modifyPaysOrigine${element.getId()}" name="modifyPaysOrigine${element.getId()}" type="text"
					value="${element.getPaysOrigine()}"> <label
					for="modifyPaysOrigine${element.getId()}">Pays d'Origine</label>
			</div>
			<div class="col s6 input-field">
				<input id="modifyPaysVente${element.getId()}" name="modifyPaysVente${element.getId()}" type="text"
					value="${element.getPaysVente()}"> <label
					for="modifyPaysVente${element.getId()}">Pays d'Origine</label>
			</div>
			<div class="input-field col s12">
				<textarea id="modifyCategorie${element.getId()}" name="modifyCategorie${element.getId()}"
					class="materialize-textarea">${element.getCategorie()}</textarea>
				<label for="modifyCategorie${element.getId()}">Catégorie du produit</label>
			</div>
			<div class="input-field col s12">
				<textarea id="modifyDescription${element.getId()}" name="modifyDescription${element.getId()}"
					class="materialize-textarea">${element.getIngredientDescription()}</textarea>
				<label for="modifyDescription${element.getId()}">Description du produit</label>
			</div>
		</div>
		<div class="row">
			<div class="col s12">
				<a
					class="col s12 modal-action modal-close btn-flat dark-purple-outline center-align"
					onclick="$('#button').val('modify');$('#formHome').submit()">Modifier</a>
			</div>
		</div>
	</div>
</div>