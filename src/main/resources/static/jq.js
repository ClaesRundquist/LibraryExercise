/* JQuery functions for LibraryExercise project */
function populate(frm, data) {
	  $.each(data, function(key, value){
	    $('[name='+key+']', frm).val(value);
	  });
	}

	$("#searchTitle").click(

    	function(){$.ajax({ 
    	   type: "get",
    	   dataType: "text",
    	   url: "http://localhost:8080/book/findbytitle/"+$('#title').val(),
    	   success: function(data){        
    		   if ($.parseJSON(data).books=="") {
    			   // TODO message should not be hardcoded.
    			   $("#res").html("No books found");
    		   } else {
    			   var jsRow=[], jsData=[];
    			   for each(row in $.parseJSON(data).books) {
    				   jsRow.push(row.id);
    				   jsRow.push(row.title;
       				   jsRow.push(row.author;
       				   jsRow+=row.genre;
       				   jsRow+=row.isbn;
       				   jsRow+=row.location;
       				   jsRow+=row.loanPeriod;
       				        				 
       				   jsData += jsRow;
    			   };
    			   alert(jsData);
    				    $('#bookResultsTable').DataTable( {
    				        data: jsData,
    				        columns: [
    				            { title: "Id" },
    				            { title: "Title" },
    				            { title: "Author" },
    				            { title: "Genre" },
    				            { title: "ISBN" },
    				            { title: "Loacation" },
    				            { title: "LoanPeriod" }
    				        ]
    				    } );
    			   
    			   
    			   $("#res").html(data);	    			   
    		   }
    		   populate('#searchBookForm', $.parseJSON(data).books[0]);
    	   },
    	 	failure: function(errMsg) {
    	 		alert(errMsg);
    	 	}
    	})
    	
    });
	$("#searchITA").click(

	    function(){
			var body='{"isbn":"'+$('#isbn').val()+'","title":"'+$('#title').val()+'","author":"'+$('#author').val()+'"}';
		    $.ajax({ 
	    	   type: "post",
	    	   contentType: "application/json; charset=utf-8",
	    	   dataType: "text",
	    	   data:body,
	    	   url: "http://localhost:8080/book/findlike",
	    	   success: function(data){        
	    		   if ($.parseJSON(data).books=="") {
	    			   // TODO message should not be hardcoded.
	    			   $("#res").html("No books found");
	    		   } else {
	    			   $("#res").html(data);	    			   
	    		   }
	    		   populate('#searchBookForm', $.parseJSON(data).books[0]);
	    	   }
	    	})
	    	
	    });


	