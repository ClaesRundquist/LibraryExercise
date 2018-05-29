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
   // 		   $("#res").html(data);
    		   populate('#searchBookForm', $.parseJSON(data).books[1]);
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
	   // 		   $("#res").html(data);
	    		   populate('#searchBookForm', $.parseJSON(data).books[0]);
	    	   }
	    	})
	    	
	    });


	