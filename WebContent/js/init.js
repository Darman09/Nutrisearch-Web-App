
$(document).ready(
		function() {
			$("#searchProduct").on(
					"keyup",
					function() {
						var value = $(this).val().toLowerCase();
						$("#bodyTable .rowElement .nameElement").filter(
								function() {
									$(this).parent().toggle(
											$(this).text().toLowerCase()
													.indexOf(value) > -1);
								});
						if ($('#searchProduct').children().length === 0) {
							console.log("Pas de résultat");
						} else {
						
						}
					});
			$("#searchCat").on(
					"keyup",
					function() {
						var value = $(this).val().toLowerCase();
						$("#bodyTable .rowElement .gradeElement").filter(
								function() {
									$(this).parent().toggle(
											$(this).text().toLowerCase()
													.indexOf(value) > -1);
								});
						if ($('#searchCat').children().length === 0) {
							console.log("Pas de résultat");
						} else {
						
						}
					});
		});