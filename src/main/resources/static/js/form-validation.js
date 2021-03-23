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


    $("form[name='activity-form']").validate({
        rules: {
            activityName: "required",
            activityDate: "required",
            activityStatus: "required",
            teamId: "required"
        },
        messages: {
            activityName: "!",
            activityDate: "!",
            activityStatus: "!",
            teamId: "!"
        },
        submitHandler: function(form) {
            form.submit();
        }
    });

    $("form[name='contact-form']").validate({
        rules: {
            contactFirstName: "required",
            contactLastName: "required",
            contactPhoneNumber: "required",
            childId: "required"
        },
        messages: {
            contactFirstName: "!",
            contactLastName: "!",
            contactPhoneNumber: "!",
            childId: "!"
        },
        submitHandler: function(form) {
            form.submit();
        }
    });

});






