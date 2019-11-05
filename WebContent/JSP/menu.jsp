<input type="hidden" id="button" name="button" value="none">
<input type="hidden" value="none" id="nutriId" name="nutriId">
<input type="hidden" value="none" id="grade" name="grade">
<div class="nav-wrapper dark-purple">
	<ul>
		<li>
			<h5 style="margin-top: 17px !important; margin-left: 10px;cursor: pointer;:" onClick="document.getElementById('button').value ='home';$('#formHome').submit();">
				Open Food Facts
				</h5>
		</li>
	</ul>
	<ul class="right">
		<li>
			<%-- Bouton pour rediriger vers le compte de l'utilisateur --%>
			<button type="submit" class="btn-flat white-text"
				onClick="document.getElementById('button').value ='home';">Accueil</button>
		</li>
	</ul>
</div>