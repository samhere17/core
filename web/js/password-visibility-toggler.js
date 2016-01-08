$("#show-pass-btn").click(function() {
	if($("#hidden-password").attr("type") === "password") {
		$("#hidden-password").attr("type", "text")
		$("#show-pass-btn").text("Hide Password")
	} else if($("#hidden-password").attr("type") === "text") {
		$("#hidden-password").attr("type", "password")
		$("#show-pass-btn").text("Show Password")
	}
})
