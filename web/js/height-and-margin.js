$(window).on("load", function() {
	var heightOfHeader = $("header").height()

	$("main").css("margin-top", heightOfHeader)
	$("#index-main").css("margin-top", heightOfHeader)

	$("aside").css("margin-top", heightOfHeader)
})
