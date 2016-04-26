$(window).on("load", function() {
	var heightOfHeader = $("header").innerHeight()
	var heightOfFooter = $("footer").innerHeight()
	var height = $(window).height() - heightOfHeader - heightOfFooter
	
	/* Setting the margin */
	$("main").css("margin-top", heightOfHeader)
	$("#index-main").css("margin-top", heightOfHeader)

	$("aside").css("margin-top", heightOfHeader)
	
	/* Setting the margin */
	$("main").css("height", height)
	$("aside").css("height", height)
})
