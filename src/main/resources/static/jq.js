/* Javascript for menu nav from example https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_topnav  */

$('#myTopnav').on("click", ".icon", function(){
    console.log($(this).parent()+"hamburger");
    var x= $(this).parent().get(0);
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
});
    
    
/* JQuery functions for LibraryExercise project */
function populate(frm, data) {
	$.each(data, function(key, value) {
		$('[name=' + key + ']', frm).val(value);
	});
}

function createBookResultsTable(data) {
	var content=[];
	if (data==null) {
		; // do nothing, empty array will be passed to DataTable constructor.
	} else if (data.books == undefined) {
		// single row with book data
		var cRow = [];
		cRow.push('<span><button class="deleteButton btn btn-default" data-id="'+data.id+'">Delete</button>'
				+'<button class="updateButton btn btn-default" data-id="'+data.id+'">Update</button>'
				+'<button class="cloneButton btn btn-default" data-id="'+data.id+'">Clone</button></span>');
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
			cRow.push('<span><button class="deleteButton btn btn-default" data-id="'+value.id+'">Delete</button>'
					+'<button class="updateButton btn btn-default" data-id="'+value.id+'">Update</button>'
					+'<button class="cloneButton btn btn-default" data-id="'+value.id+'">Clone</button></span>');
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
			title : "Operations"
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
			title : "Location"
		}, {
			title : "Loan Period"
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



$('#bookResultsTable').on("click", ".deleteButton", function(){
    console.log($(this).parent());

    // global scoped flag to make use of this-relative traversing possible instead of DOM search.
    bookResultsTableDelete=true;
	$.ajax({
		type : "delete",
		dataType : "text",
		url : "http://localhost:8080/book/delete/" + $(this).attr('data-id'),
		success : function(data) {
		},
		failure : function(errMsg) {
			bookResultsTableDelete=false;
			$("#res").html(errMsg);
		}
	});

	if (bookResultsTableDelete) {
		$(this).parents('tr').remove();
	}
	
});

$('#bookResultsTable').on("click", ".updateButton", function(){
    console.log($(this).parent()+"update");

    location.href="http://localhost:8080/findToUpdate/" + $(this).attr('data-id');
	
});

$('#bookResultsTable').on("click", ".cloneButton", function(){
    console.log($(this).parent()+"clone");

	$.ajax({
		type : "post",
		contentType : "application/json; charset=utf-8",
		dataType : "text",
		data : $(this).attr('data-id'),
		url : "http://localhost:8080/book/clone",
		success : function(data) {
			var table = $('#bookResultsTable').DataTable();

			var value=JSON.parse(data);
			var cRow = [];
			cRow.push('<span><button class="deleteButton btn btn-default" data-id="'+value.id+'">Delete</button>'
					+'<button class="updateButton btn btn-default" data-id="'+value.id+'">Update</button>'
					+'<button class="cloneButton btn btn-default" data-id="'+value.id+'">Clone</button></span>');
			cRow.push(value.id);
			cRow.push(value.isbn);
			cRow.push(value.title);
			cRow.push(value.author);
			cRow.push(value.genre);
			cRow.push(value.location);
			cRow.push(value.loanPeriod);
			
			table.row.add(cRow).draw();

		}
	});

});


