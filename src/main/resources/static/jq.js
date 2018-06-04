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
/*
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
*/


$( "#searchMemberByNameForm" ).submit(function( event ) {
	var dataArray = $( this ).serializeArray(),
  dataObj = {};

  $(dataArray).each(function(i, field){
	  dataObj[field.name] = field.value;
  });

   console.log( $( this ).serializeArray());
   $.ajax({
			type : "get",
			dataType : "text",
			url : $( this ).attr('action')+dataObj['name'],
			success : function(data) {
				console.log(data);
				createMemberResultsTable(JSON.parse(data));
			},
			failure : function(errMsg) {
				$("#res").html(errMsg);
			}
		});
	   
	  event.preventDefault();
	});


function fillRespRows(rrDiv, headers, sizes) {
	
	var n=$("#"+rrDiv).children().length;
	var evenOdd=(n%2==1)?"rrdivodd":"rrdiveven";
	$( "#"+rrDiv ).append( '<div id="'+rrDiv+'row'+n+'" class="row '+evenOdd+'"></div>' );
	$.each(headers, function(i, str) {
		$( "#"+rrDiv+"row"+n ).append( '<div class="'+sizes[i]+'" id="rrdiv'+n+'_'+i+'" >'+str+'</div>' );
	});

}


function createBookResultsTable(data) {
	var content=[];
	if (data==null) {
		; // do nothing, empty array will be passed to DataTable constructor.
	} else if (data.books == undefined) {
		// single row with book data
		var cRow = [];
		cRow.push('<nobr><button class="rtbtndelete btn btn-default" data-id="'+data.id+'">X</button>'
				+'<button class="rtbtnupdate btn btn-default" data-id="'+data.id+'">*</button>'
				+'<button class="rtbtnclone btn btn-default" data-id="'+data.id+'">+</button></nobr>');
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
			cRow.push('<nobr><button class="rtbtndelete btn" data-id="'+value.id+'">X</button>'
					+'<button class="rtbtnupdate btn" data-id="'+value.id+'">*</button>'
					+'<button class="rtbtnclone btn" data-id="'+value.id+'">+</button></nobr>');
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

	$.each(content, function(i, cRow) {
		console.log("????");
		fillRespRows("rrdivtest", cRow, ["col-md-1","col-md-1","col-md-2","col-md-2","col-md-2","col-md-2", "col-md-1", "col-md-1"]);
	
	
});
/*	
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
*/

}




function createMemberResultsTable(data) {
	var content=[];
	if (data==null) {
		; // do nothing, empty array will be passed to DataTable constructor.
	} else if (data.members == undefined) {
		// single row with book data
		var cRow = [];
		cRow.push('<span><button class="deleteButton btn btn-default" data-id="'+data.id+'">Delete</button>'
				+'<button class="updateButton btn btn-default" data-id="'+data.id+'">Update</button>'
				);
		cRow.push(data.id);
		content.push(cRow);
	} else {
		// Array of books.
		$.each(data.members, function(key, value) {
			var cRow = [];
			cRow.push('<span><button class="deleteButton btn btn-default" data-id="'+value.id+'">Delete</button>'
					+'<button class="updateButton btn btn-default" data-id="'+value.id+'">Update</button>'
					);
			cRow.push(value.id);
			cRow.push(value.name);
			cRow.push(value.contactInfo.adress);
			cRow.push(value.contactInfo.phone);
			cRow.push(value.contactInfo.email);
//			cRow.push(value.libraryCard);
			content.push(cRow);
		});		
	}
	
	
	
	$('#memberResultsTable').DataTable({
		destroy : true,
		data : content,
		columns : [ {
			title : "Operations"
		}, {
			title : "Id"
		}, {
			title : "Name"
		}, {
			title : "Adress"
		}, {
			title : "Phone"
		}, {
			title : "Email"
		}
		
		]
	});


}



$( "#searchBookByIdForm" ).submit(function( event ) {
	var dataArray = $( this ).serializeArray(),
  dataObj = {};

  $(dataArray).each(function(i, field){
	  dataObj[field.name] = field.value;
  });
console.log(JSON.stringify(dataObj));

//fillRespRows("rrdivtest", ["ops", "id", "title", "author", "isbn", "genre", "loc", "per"], ["col-sm-1","col-sm-1","col-sm-2","col-sm-2","col-sm-2","col-sm-2", "col-sm-1", "col-sm-1"]);
fillRespRows("rrdivtest", ["ops", "id", "title", "author", "isbn", "genre", "loc.", "period"], ["col-md-1","col-md-1","col-md-2","col-md-2","col-md-2","col-md-2", "col-md-1", "col-md-1"]);
	$.ajax({
		type : "get",
		dataType : "text",
		url : "http://localhost:8080/book/findbyid/" + +dataObj['id'],
		success : function(data) {
			createBookResultsTable(data=="null" ? null : JSON.parse(data));
		},
		failure : function(errMsg) {
			$("#res").html(errMsg);
		}
	});
	event.preventDefault();
});

/* the following two are same function different way */

$( "#searchBooksByITAForm" ).submit(function( event ) {
	var dataArray = $( this ).serializeArray(),
  dataObj = {};

  $(dataArray).each(function(i, field){
	  dataObj[field.name] = field.value;
  });

console.log(JSON.stringify(dataObj));
	body=JSON.stringify(dataObj);
	// also try dataType json och dataObj as body
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

	  event.preventDefault();
});




$("#searchITA").click(

		// TODO Http error handling Bad request etc. Empty result is ok though.
		function() {
console.log($( this ).serializeArray());
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



$('#rrdivtest').on("click", ".deleteButton", function(){
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


$('#memberResultsTable').on("click", ".rtbtndelete", function(){
    console.log($(this).parent());

    // global scoped flag to make use of this-relative traversing possible instead of DOM search.
    memberResultsTableDelete=true;
	$.ajax({
		type : "delete",
		dataType : "text",
		url : "http://localhost:8080/member/delete/" + $(this).attr('data-id'),
		success : function(data) {
		},
		failure : function(errMsg) {
			bookResultsTableDelete=false;
			$("#res").html(errMsg);
		}
	});

	if (memberResultsTableDelete) {
		$(this).parents('tr').remove();
	}
	
});




$('#rrdivtest').on("click", ".rtbtnupdate", function(){
    console.log($(this).parent()+"update");

    // Load Thymeleaf page
    location.href="http://localhost:8080/book/findToUpdate/" + $(this).attr('data-id');
	
});


$('#memberResultsTable').on("click", ".rtbtnupdate", function(){
    console.log($(this).parent()+"update");

    // Load Thymeleaf page
    location.href="http://localhost:8080/member/findToUpdate/" + $(this).attr('data-id');
	
});



$('#rrdivtest').on("click", ".rtbtnclone", function(){
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
			cRow.push('<span><button class="rtbtndelete btn btn-default" data-id="'+value.id+'">Delete</button>'
					+'<button class="rtbtnupdate btn btn-default" data-id="'+value.id+'">Update</button>'
					+'<button class="rtbtnclone btn btn-default" data-id="'+value.id+'">Clone</button></span>');
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


