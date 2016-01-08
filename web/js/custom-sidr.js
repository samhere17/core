if($(window).width() <= 992) {
	$('#side-bar-anchor').sidr({
		name: "side-bar",
		displace: false,
		speed: 300,

		onOpen: function() {
			$("#side-bar-anchor span").removeClass("glyphicon-menu-hamburger")
			$("#side-bar-anchor span").addClass("glyphicon-arrow-left")
			$("#side-bar-anchor ul li:nth-child(2)").text("Back")
		},
		onClose: function() {
			$("#side-bar-anchor span").removeClass("glyphicon-arrow-left")
			$("#side-bar-anchor span").addClass("glyphicon-menu-hamburger")
			$("#side-bar-anchor ul li:nth-child(2)").text("Menu")
		}
	})

	$(window).touchwipe({
		wipeLeft: function() {
			$.sidr("close", "side-bar");
		},
		wipeRight: function() {
			$.sidr("open", "side-bar");
		},
		preventDefaultEvents: false
	})
} else {
	$('#side-bar-anchor').sidr({
		name: "side-bar",
		displace: false,
		speed: 0
	})

	$.sidr("open", "side-bar")
	$("main").addClass("col-md-offset-3")
}
