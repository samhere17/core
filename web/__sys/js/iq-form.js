function showDialog(dialogId, modal) {
	$("#overlay").fadeIn(300);
	$("#" + dialogId).fadeIn(300);
	if (modal) {
		$("#overlay").unbind("click");
	} else {
		$("#overlay").click(function(e) {
			hideDialog(dialogId);
		});
	}
}

function hideDialog(dialogId) {
	$("#overlay").fadeOut(300);
	$("#" + dialogId).fadeOut(300);
}