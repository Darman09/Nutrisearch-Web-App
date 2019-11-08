<div id="addElement" class="modal">
	<div class="modal-content">
		<div class="row">
			<div class="col s12">
				<h4>Ajouter un produit</h4>
			</div>
			<div class="col s12 input-field">
				<label for="addName">Nom du produit</label> <input required class="validate" type="text" id="addName"
					name="addName">
			</div>
			<div class="col s12">
				<select class="browser-default" id="addGrade" name="addGrade">
					<option id="GradeA">A</option>
					<option id="GradeB">B</option>
					<option id="GradeC">C</option>
					<option id="GradeD">D</option>
					<option id="GradeE">E</option>
				</select>
			</div>
			<div class="col s6 input-field">
				<label for="addQuantity">Quantité du produit</label> <input required class="validate" 
					type="text" id="addQuantity"
					name="addQuantity">
			</div>
			<div class="col s6 input-field">
				<label for="addPackaging">Nom de l'emballage</label> <input required class="validate" 
					type="text" id="addPackaging"
					name="addPackaging">
			</div>
			<div class="col s6 input-field">
				<input id="addPaysOrigine" name="addPaysOrigine" type="text" required class="validate" > <label
					for="addPaysOrigine">Pays d'Origine</label>
			</div>
			<div class="col s6 input-field">
				<input id="addPaysVente" name="addPaysVente" type="text" required class="validate" > <label
					for="addPaysVente">Pays de Vente</label>
			</div>
			<div class="input-field col s12">
				<textarea id="addCategorie" name="addCategorie" required class="validate" 
					class="materialize-textarea"></textarea>
				<label for="addCategorie">Catégorie du produit</label>
			</div>
			<div class="input-field col s12">
				<textarea id="addDescription" name="addDescription" required class="validate" 
					class="materialize-textarea"></textarea>
				<label for="addDescription">Description du produit</label>
			</div>
		</div>
		<div class="row">
			<div class="col s12">
				<a
					class="col s12 modal-action modal-close btn-flat dark-purple-outline center-align"
					onclick="$('#button').val('add');$('#formHome').submit()">Ajouter</a>
			</div>
		</div>
	</div>
</div>