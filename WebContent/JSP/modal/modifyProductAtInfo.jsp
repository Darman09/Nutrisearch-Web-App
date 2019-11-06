<div id="editElement" class="modal">
	<div class="modal-content">
		<div class="row">
			<div class="col s12">
				<h4>Modifier le produit ${element.getNomProduit()}</h4>
			</div>
			<div class="col s12 input-field">
				<label for="modifyName">Nom du produit</label> <input
					value="${element.getNomProduit()}" type="text" id="modifyName"
					name="modifyName">
			</div>
			<div class="col s12">
				<select class="browser-default" id="modifyGrade" name="modifyGrade">
					<option id="GradeA">A</option>
					<option id="GradeB">B</option>
					<option id="GradeC">C</option>
					<option id="GradeD">D</option>
					<option id="GradeE">E</option>
				</select>
			</div>
			<div class="col s6 input-field">
				<label for="modifyQuantity">Quantité du produit</label> <input
					type="text" value="${element.getQuantity()}" id="modifyQuantity"
					name="modifyQuantity">
			</div>
			<div class="col s6 input-field">
				<label for="modifyPackaging">Nom de l'emballage</label> <input
					type="text" value="${element.getPackaging()}" id="modifyPackaging"
					name="modifyPackaging">
			</div>
			<div class="col s6 input-field">
				<input id="modifyPaysOrigine" name="modifyPaysOrigine" type="text"
					value="${element.getPaysOrigine()}"> <label
					for="modifyPaysOrigine">Pays d'Origine</label>
			</div>
			<div class="col s6 input-field">
				<input id="modifyPaysVente" name="modifyPaysVente" type="text"
					value="${element.getPaysVente()}"> <label
					for="modifyPaysVente">Pays d'Origine</label>
			</div>
			<div class="input-field col s12">
				<textarea id="modifyCategorie" name="modifyCategorie"
					class="materialize-textarea">${element.getCategorie()}</textarea>
				<label for="modifyCategorie">Catégorie du produit</label>
			</div>
			<div class="input-field col s12">
				<textarea id="modifyDescription" name="modifyDescription"
					class="materialize-textarea">${element.getIngredientDescription()}</textarea>
				<label for="modifyDescription">Description du produit</label>
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