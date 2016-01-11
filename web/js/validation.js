/* Validation, error etc. */
$(function() {
	$("input").blur(function() {

		/* If input is invalid */
		if($(this).is(":invalid")) {
			/* Show the red border */
			$(this).addClass("input-invalid")

			/* Hide the check icon */
			$(this).siblings(".glyphicon-ok").addClass("hidden")

			/* Show the cross icon */
			$(this).siblings(".glyphicon-remove").removeClass("hidden")

			/* Show help text */
			$(this).siblings(".error-msg").removeClass("hidden")
		} else {
			/* Hide the red border */
			$(this).removeClass("input-invalid")

			/* Hide the cross icon */
			$(this).siblings(".glyphicon-remove").addClass("hidden")

			/* Show the check icon */
			$(this).siblings(".glyphicon-ok").removeClass("hidden")

			/* Hide help text */
			$(this).siblings(".error-msg").addClass("hidden")

			/* Hide error message from server */
			$(this).siblings(".error-msg-from-svr").addClass("hidden")
		}

	})
})

$(function () {
	$(".form-control").blur(function() {            /* Validate all of the input fields each time an input is given. */
		var not_all_inputs_are_valid = false

		$(".form-control").each(function() {
			if($(this).is(":valid")) {
				return                              /* Enquivalent of continue */
			} else {
				not_all_inputs_are_valid = true     /* Not all inputs are valid */
				return false                        /* Enquivalent of break */
			}
		})

		if(!not_all_inputs_are_valid) {
			$("#submit").removeAttr("disabled")     /* Enable the submit button */
		} else {
			$("#submit").attr("disabled", "")       /* By default the button is disabled. This applies when someone makes one of the inputs invalid after all fields had been deemed valid. */
		}
	})
})
