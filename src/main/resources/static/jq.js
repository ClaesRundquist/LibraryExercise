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

// TODO map these...
booksTableContent=[];
membersTableContent=[];
loansTableContent=[];


function fillRespRows(rrDiv, headers, sizes) {
	
	var n=$("#"+rrDiv).children().length;
	
	$( "#"+rrDiv ).append( '<div id="'+rrDiv+'row'+n+'" class="row"></div>' );
	$.each(headers, function(i, str) {
		$( "#"+rrDiv+"row"+n ).append( '<div class="'+sizes[i]+'" id="rrdiv'+n+'_'+i+'" >'+str+'</div>' );
	});
}

function removeAllRespRows(rrDiv) {
	var n=$("#"+rrDiv).children().remove();
}

function renderRespRows(rrDiv) {
	$.each($("#"+rrDiv).children(), function(i, child) {
		var evenOdd=(i%2==1)?"rrdivodd":"rrdiveven";
		$(child).removeClass("rrdivodd");
		$(child).removeClass("rrdiveven");
		$(child).addClass(evenOdd);
	});
}

function createBookResultsTable(data) {
	var content=[];
	if (data==null) {
		; // do nothing, empty array will be passed to DataTable constructor.
	} else if (data.books == undefined) {
		// single row with book data
		var cRow = [];
		cRow.push('<nobr><button class="rtbtndelete btn" data-id="'+data.id+'">X</button>'
				+'<button class="rtbtnupdate btn" data-id="'+data.id+'">*</button>'
				+'<button class="rtbtnclone btn" data-id="'+data.id+'">+</button></nobr>');
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

	booksTableContent=content;
	
	removeAllRespRows("rrdivbooks");
	fillRespRows("rrdivbooks", ["ops", "id", "title", "author", "isbn", "genre", "loc.", "period"], ["col-md-1","col-md-1","col-md-2","col-md-2","col-md-2","col-md-2", "col-md-1", "col-md-1"]);
	$.each(booksTableContent, function(i, cRow) {
		fillRespRows("rrdivbooks", cRow, ["col-md-1","col-md-1","col-md-2","col-md-2","col-md-2","col-md-2", "col-md-1", "col-md-1"]);
	});
	// add class to color every second row.
	renderRespRows("rrdivbooks");
	
}




function createMemberResultsTable(data) {
	var content=[];
	if (data==null) {
		; // do nothing, empty array will be passed to DataTable constructor.
	} else if (data.members == undefined) {
		// single row with member data
		var cRow = [];
		cRow.push('<nobr><button class="rtbtndelete btn" data-id="'+data.id+'">X</button>'
				+'<button class="rtbtnupdate btn" data-id="'+data.id+'">*</button></nobr>'
				);
		cRow.push(data.id);
		cRow.push(data.name);
		cRow.push(data.contactInfo.adress);
		cRow.push(data.contactInfo.phone);
		cRow.push(data.contactInfo.email);
		cRow.push('fake card');
		content.push(cRow);
	} else {
		// Array of members.
		$.each(data.members, function(key, value) {
			var cRow = [];
			cRow.push('<nobr><button class="rtbtndelete btn" data-id="'+data.id+'">X</button>'
					+'<button class="rtbtnupdate btn" data-id="'+data.id+'">*</button></nobr>'
					);
			cRow.push(value.id);
			cRow.push(value.name);
			cRow.push(value.contactInfo.adress);
			cRow.push(value.contactInfo.phone);
			cRow.push(value.contactInfo.email);
			cRow.push('fake card');
			content.push(cRow);
		});		
	}
	
	memberTableContent=content;
	
	removeAllRespRows("rrdivmembers");
	fillRespRows("rrdivmembers", ["ops", "id", "name", "adress", "phone", "email","lib. card"], ["col-md-1","col-md-1","col-md-2","col-md-3","col-md-2","col-md-2","col-md-1"]);
	$.each(memberTableContent, function(i, cRow) {
		fillRespRows("rrdivmembers", cRow, ["col-md-1","col-md-1","col-md-2","col-md-3","col-md-2","col-md-2","col-md-1"]);
	});
	// add class to color every second row.
	renderRespRows("rrdivmembers");

}


function createLoanResultsTable(data) {
	var content=[];
	if (data==null) {
		; // do nothing, empty array will be passed to DataTable constructor.
	} else if (data.loans == undefined) {
		// single row with loan data
		var cRow = [];
		cRow.push(data.id);
		cRow.push(data.book.id);
		cRow.push(data.book.title);		
		cRow.push(data.dueDate);
		cRow.push(data.member.id);
		content.push(cRow);
	} else {
		// Array of loans.
		$.each(data.loans, function(key, value) {
			var cRow = [];
			cRow.push(value.id);
			cRow.push(value.book.id);
			cRow.push(value.book.title);		
			cRow.push(value.dueDate);
			cRow.push(value.member.id);
			content.push(cRow);
		});		
	}
	
	loanTableContent=content;
	
	removeAllRespRows("rrdivloans");
	fillRespRows("rrdivloans", ["id", "book id", "title", "due date", "member id"], ["col-md-1","col-md-1","col-md-3","col-md-2","col-md-1"]);
	$.each(loanTableContent, function(i, cRow) {
		fillRespRows("rrdivloans", cRow, ["col-md-1","col-md-1","col-md-3","col-md-2","col-md-1"]);
	});
	// add class to color every second row.
	renderRespRows("rrdivloans");

}





$( "#searchBookByIdForm" ).submit(function( event ) {
	var dataArray = $( this ).serializeArray(),
  dataObj = {};

  $(dataArray).each(function(i, field){
	  dataObj[field.name] = field.value;
  });
console.log(JSON.stringify(dataObj));

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





$('#rrdivbooks').on("click", ".rtbtndelete", function(){
    console.log($(this).parent());

    var id=$(this).attr('data-id');
    
    // global scoped flag to make use of this-relative traversing possible instead of DOM search.
    bookResultsTableDelete=true;
	$.ajax({
		type : "delete",
		dataType : "text",
		url : "http://localhost:8080/book/delete/" + id,
		success : function(data) {
		},
		failure : function(errMsg) {
			bookResultsTableDelete=false;
			$("#res").html(errMsg);
		}
	});

	if (bookResultsTableDelete) {
		// table.remove();
		var iToRemove;
		$.each(booksTableContent, function(i, cRow) {
			if (cRow[1]==id) {
			    iToRemove=i;
			}
		});
	    booksTableContent.splice(iToRemove,1);

		removeAllRespRows("rrdivbooks");
		fillRespRows("rrdivbooks", ["ops", "id", "title", "author", "isbn", "genre", "loc.", "period"], ["col-md-1","col-md-1","col-md-2","col-md-2","col-md-2","col-md-2", "col-md-1", "col-md-1"]);
		$.each(booksTableContent, function(i, cRow) {
			fillRespRows("rrdivbooks", cRow, ["col-md-1","col-md-1","col-md-2","col-md-2","col-md-2","col-md-2", "col-md-1", "col-md-1"]);
		});
		// add class to color every second row.
		renderRespRows("rrdivbooks");

	}
	
});


// Members ---------------------------
$( "#searchMemberByIdForm" ).submit(function( event ) {
	var dataArray = $( this ).serializeArray(),
  dataObj = {};

  $(dataArray).each(function(i, field){
	  dataObj[field.name] = field.value;
  });
console.log(JSON.stringify(dataObj));
	$.ajax({
		type : "get",
		dataType : "text",
		url : "http://localhost:8080/member/findbyid/" + dataObj['id'],
		success : function(data) {
			createMemberResultsTable(data=="null" ? null : JSON.parse(data));
		},
		failure : function(errMsg) {
			$("#res").html(errMsg);
		}
	});
	event.preventDefault();
});


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
			url : "http://localhost:8080/member/findbyname/"+dataObj['name'],
			success : function(data) {
				console.log(data);
				createMemberResultsTable(JSON.parse(data));
			},
			failure : function(errMsg) {
				createMemberResultsTable([]);
			}
		});
	   
	  event.preventDefault();
	});


$('#memberResultsTable').on("click", ".rtbtndelete", function(){
    console.log($(this).parent());

    var id=$(this).attr('data-id');

    // global scoped flag to make use of this-relative traversing possible instead of DOM search.
    memberResultsTableDelete=true;
	$.ajax({
		type : "delete",
		dataType : "text",
		url : "http://localhost:8080/member/delete/" + id,
		success : function(data) {
		},
		failure : function(errMsg) {
			bookResultsTableDelete=false;
			createMemberResultsTable([]);
		}
	});

	if (memberResultsTableDelete) {
		// table.remove();
		var iToRemove;
		$.each(membersTableContent, function(i, cRow) {
			if (cRow[1]==id) {
			    iToRemove=i;
			}
		});
	    membersTableContent.splice(iToRemove,1);

		removeAllRespRows("rrdivmembers");
		fillRespRows("rrdivmembers", ["ops", "id", "title", "author", "isbn", "genre", "loc.", "period"], ["col-md-1","col-md-1","col-md-2","col-md-2","col-md-2","col-md-2", "col-md-1", "col-md-1"]);
		$.each(booksTableContent, function(i, cRow) {
			fillRespRows("rrdivmembers", cRow, ["col-md-1","col-md-1","col-md-2","col-md-2","col-md-2","col-md-2", "col-md-1", "col-md-1"]);
		});
		// add class to color every second row.
		renderRespRows("rrdivmembers");
	}
	
});


// Loans -----------------------------
$( "#searchLoanByCardIdForm" ).submit(function( event ) {
	var dataArray = $( this ).serializeArray(),
  dataObj = {};

  $(dataArray).each(function(i, field){
	  dataObj[field.name] = field.value;
  });
console.log(JSON.stringify(dataObj));

	$.ajax({
		type : "get",
		dataType : "text",
		url : "http://localhost:8080/loan/findbycardid/" + dataObj['cardId'],
		success : function(data) {
			createLoanResultsTable(data=="null" ? null : JSON.parse(data));
		},
		failure : function(errMsg) {
			createLoanResultsTable([]);
		}
	});
	event.preventDefault();
});


$( "#searchLoanByBookIdForm" ).submit(function( event ) {
	var dataArray = $( this ).serializeArray(),
  dataObj = {};

  $(dataArray).each(function(i, field){
	  dataObj[field.name] = field.value;
  });

   console.log( $( this ).serializeArray());
   $.ajax({
			type : "get",
			dataType : "text",
			url : "http://localhost:8080/loan/findbybookid/"+dataObj['bookId'],
			success : function(data) {
				console.log(data);
				createLoanResultsTable(JSON.parse(data));
			},
			failure : function(errMsg) {
				createLoanResultsTable([]);
			}
		});
	   
	  event.preventDefault();
	});










$('#rrdivbooks').on("click", ".rtbtnupdate", function(){
    console.log($(this).parent()+"update");

    // Load Thymeleaf page
    location.href="http://localhost:8080/book/findToUpdate/" + $(this).attr('data-id');
	
});


$('#rrdivmembers').on("click", ".rtbtnupdate", function(){
    console.log($(this).parent()+"update");

    // Load Thymeleaf page
    location.href="http://localhost:8080/member/findToUpdate/" + $(this).attr('data-id');
	
});



$('#rrdivbooks').on("click", ".rtbtnclone", function(){

	console.log("clone"+$(this).attr('data-id'));
	$.ajax({
		type : "post",
		contentType : "application/json; charset=utf-8",
		dataType : "text",
		data : $(this).attr('data-id'),
		url : "http://localhost:8080/book/clone",
		success : function(data) {

			var value=JSON.parse(data);
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
			
			// table.add(cRow)
			booksTableContent.push(cRow);
			removeAllRespRows("rrdivbooks");
			fillRespRows("rrdivbooks", ["ops", "id", "title", "author", "isbn", "genre", "loc.", "period"], ["col-md-1","col-md-1","col-md-2","col-md-2","col-md-2","col-md-2", "col-md-1", "col-md-1"]);
			$.each(booksTableContent, function(i, cRow) {
				fillRespRows("rrdivbooks", cRow, ["col-md-1","col-md-1","col-md-2","col-md-2","col-md-2","col-md-2", "col-md-1", "col-md-1"]);
			});
			// add class to color every second row.
			renderRespRows("rrdivbooks");

		}
	});

});


