/* JQuery functions for LibraryExercise project */
function populate(frm, data) {
	$.each(data, function(key, value) {
		$('[name=' + key + ']', frm).val(value);
	});
}

function createBookResultsTable(data) {
	var content=[];
	if (data=="null") {
		; // do nothing, empty array will be passed to DataTable constructor.
	} else if (data.books == undefined) {
		// single row with book data
		var cRow = [];
		cRow.push('<button data-id="'+data.id+'">delete</button>');
		cRow.push(data.id);
		cRow.push(data.isbn);
		cRow.push(data.title);
		cRow.push(data.author);
		cRow.push(data.genre);
		cRow.push(data.location);
		cRow.push(data.loanPeriod);
		content.push(cRow);
	} else {
		// Array of books.
		$.each(data.books, function(key, value) {
			var cRow = [];
			cRow.push('<button data-id="'+value.id+'">delete</button>');
			cRow.push(value.id);
			cRow.push(value.isbn);
			cRow.push(value.title);
			cRow.push(value.author);
			cRow.push(value.genre);
			cRow.push(value.location);
			cRow.push(value.loanPeriod);
			content.push(cRow);
		});		
	}
	$('#bookResultsTable').DataTable({
		destroy : true,
		data : content,
		columns : [ {
			title : "Operation"
		}, {
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
			createBookResultsTable(data=="null" ? null : JSON.parse(data));
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
					createBookResultsTable(JSON.parse(data));
				}
			});

		});



$('#bookResultsTable').on("click", "button", function(){
    console.log($(this).parent());
    alert("deleting row w id="+$(this).attr('data-id'));
    $(this).parents('tr').remove();
});


