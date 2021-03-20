$(document).ready(function() {
    console.log("script loaded!");


    $("form").submit(function(e) {
        if ($.trim($("#childfirstname").val()) === "" || $.trim($("#childlastname").val()) === "") {
            alert('you did not fill out one of the fields');
            e.preventDefault();
            return false;
        }
    });

    $("form[name='new-child']").validate({
        rules: {
            // key name = name attribute of input field
            childfirstname: "required",
            childlasttname: "required",
            regdate: {
                required: true,
                minlength: 10
            },
            enrldate: {
                minlength: 10
            },
            contactname: "required",
            contactlastname: "required",
            contactphonenr: "required"

        },
        //  validation error messages
        messages: {
            childfirstname: "enter child's name!",
            childlasttname: "enter child's last name!",
            regdate: {
                required: "enter registration date!",
                minlength: "date format yyyy-mm-dd"
            },
            enrldate: {
                minlength: "date format yyyy-mm-dd"
            },
            contactname: "enter contact name!",
            contactlastname: "enter contact last name!",
            contactphonenr: "enter contact phone number!"
        },
        // Make sure the form is submitted to the destination defined
        // in the "action" attribute of the form when valid
        submitHandler: function(form) {
            form.submit();
        }
    });
});

//



