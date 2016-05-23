$('a').click(function(e) {
	e.preventDefault()
	console.log("link clicked")
	var launchAction = $(this).attr('data-launch-action')
	if(launchAction) {
		$.requestCore({
			"action" : launchAction,
			"type" : "GET"
		})
	}
})