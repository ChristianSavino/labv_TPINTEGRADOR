$(document).ready(function() {
	
});

$.ajax({

    type: "GET",
    url: "getUserName.html",
    contentType: "text/plain",
    dataType: "text",
    success: function (data) {
        debugger;
        $("#usuario").text('Hola:' + data);
    },
    failure: function (response) {
         debugger;
        alert(response.d);
    }
});