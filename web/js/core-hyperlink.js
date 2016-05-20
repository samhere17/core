$('a').click(function(e) {
	e.preventDefault()
	console.log("link clicked")
	var launchAction = $(this).attr('data-launch-action')
	if(launchAction) {
		window.location.href = "adapter?requested-action="+launchAction
		console.log("called - "+launchAction)
	}
})