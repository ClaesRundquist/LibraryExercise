/* JQuery functions for LibraryExercise project */
function populate(frm, data) {
	$.each(data, function(key, value) {
		$('[name=' + key + ']', frm).val(value);
	});
}


function clearBookResultsTable() {
	$('#bookResultsTable').DataTable({
		destroy : true,
		data : [],
		columns : [ {
			title : "Id"
		}, {
			title : "Title"
		}, {
			title : "Author"
		}, {
			title : "Genre"
		}, {
			title : "ISBN"
		}, {
			title : "Loacation"
		}, {
			title : "LoanPeriod"
		} ]
	});
}

$("#searchId").click(
// TODO Http error handling Bad request etc. Empty result is ok though.

function() {
	$.ajax({
		type : "get",
		dataType : "text",
		url : "http://localhost:8080/book/findbyid/" + $('#id').val(),
		success : function(data) {
			if (data == "null") {
				clearBookResultsTable();
			} else {

				var jsData = [];
				value = JSON.parse(data);
				var jsRow = [];
				jsRow.push(value.id);
				jsRow.push(value.isbn);
				jsRow.push(value.title);
				jsRow.push(value.author);
				jsRow.push(value.genre);
				jsRow.push(value.location);
				jsRow.push(value.loanPeriod);
				jsData.push(jsRow);
				
				$('#bookResultsTable').DataTable({
					destroy : true,
					data : jsData,
					columns : [ {
						title : "Id"
					}, {
						title : "Title"
					}, {
						title : "Author"
					}, {
						title : "Genre"
					}, {
						title : "ISBN"
					}, {
						title : "Loacation"
					}, {
						title : "LoanPeriod"
					} ]
				});
			}
		},
		failure : function(errMsg) {
			$("#res").html(errMsg);
		}
	});

});

$("#searchITA").click(

		// TODO Http error handling Bad request etc. Empty result is ok though.
		function() {
			var body = '{"isbn":"' + $('#isbn').val() + '","title":"'
					+ $('#title').val() + '","author":"' + $('#author').val()
					+ '"}';
			$.ajax({
				type : "post",
				contentType : "application/json; charset=utf-8",
				dataType : "text",
				data : body,
				url : "http://localhost:8080/book/findlike",
				success : function(data) {
					if (JSON.parse(data).books == "") {
						clearBookResultsTable();
					} else {
						var jsData = [];
						$.each(JSON.parse(data).books, function(key, value) {
							var jsRow = [];
							jsRow.push(value.id+'<button data-id="'+value.id+'">delete</button>');
							jsRow.push(value.isbn);
							jsRow.push(value.title);
							jsRow.push(value.author);
							jsRow.push(value.genre);
							jsRow.push(value.location);
							jsRow.push(value.loanPeriod);
							jsData.push(jsRow);
						});

						$('#bookResultsTable').DataTable({
							destroy : true,
							data : jsData,
							columns : [ {
								title : "Id"
							}, {
								title : "Title"
							}, {
								title : "Author"
							}, {
								title : "Genre"
							}, {
								title : "ISBN"
							}, {
								title : "Loacation"
							}, {
								title : "LoanPeriod"
							} ]
						});
					}
				}
			});

		});



$('#bookResultsTable').on("click", "button", function(){
    console.log($(this).parent());
    alert("deleting row w id="+$(this).attr('data-id'));
    $(this).parents('tr').remove();
});


