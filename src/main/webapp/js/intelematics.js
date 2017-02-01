$(document).ready(function() {
    $('#loginButton').click(function() {
        disableButtons();

            var user = new Object();
            user.username = $('#username').val();
            user.password = $('#password').val();

            var json = JSON.stringify(user);

            $.ajax({
                   type: 'POST',
                   url: contextPath+"/api/v1/login/",
                   contentType: 'application/json',
                   data: json, // serializes the form's elements.
                   dataType : 'json',
                   success: function(data)
                   {
                        var result = JSON.stringify(data);
                        if(data.statusCode == 200) {
                            $('#message').html('');
                        } else {
                            console.log("ERROR: ", result);
                            $('#message').html(data.message);
                        }

                        $('#result').html(result);
                   },
                   error : function(xhr, ajaxOptions, thrownError) {
                        console.log("ERROR: ", xhr.responseText);
                        $('#result').html(xhr.responseText);

                        var result = JSON.parse( xhr.responseText);
                        $('#message').html(result.message);
                   },
                   complete: function(){
                        enableButtons();
                   }
                 });
    });
});

function disableButtons() {
    $('#loginButton').prop('disabled', true);
}

function enableButtons() {
    $('#loginButton').prop('disabled', false);
}