$(document).ready(function() {
	
});

$.ajax({

    type: "GET",
    url: "getUserName.html",
    contentType: "text/plain",
    dataType: "text",
    success: function (data) {
        $("#usuario").text('Hola:' + data);
    },
    failure: function (response) {
        alert(response.d);
    }
});