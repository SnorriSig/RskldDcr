$(document).ready(function() {
    console.log("script loaded!");

    $("form[name='child-form']").validate({
        rules: {
            childFirstName: "required",
            childLastName: "required",
            childDoB: {
                required: true,
                minlength: 10
            },
            teamId: "required",
            contactId: "required",
            childStatus: "required",
        },
        messages: {
            childFirstName: "!",
            childLastName: "!",
            childDoB: {
                required: "!",
                minlength: "yyyy-mm-dd"
            },
            teamId: "!",
            contactId: "!",
            childStatus: "!"
        },
        submitHandler: function(form) {
            form.submit();
        }
    });


});




