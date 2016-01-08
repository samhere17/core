/*
	Role Selection Modal
*/

/* Prevents selection of multiple roles */
$("#roles-table").selectable({
	tolerance: "fit"
})

/* Remove the padding on 'body' which gets automatically added when the modal is opened */
$("#role-modal").on("shown.bs.modal", function() {
	$("body").css("padding-right", "0")
})

$("#role-select-btn").click(function() {
	var selectedRole = $("#roles-table tr.ui-selected")
	var selectedRoleId = $(selectedRole).children("td").first().text()
	var selectedRoleName = $(selectedRole).children("td:nth-child(2)").text()

	$("#role-id").attr("value", selectedRoleId)
	$("#role-name").attr("value", selectedRoleName)

	$("#role-modal").modal("hide")
})

/*
	Community Selection Modal
*/

$("#commu-table").selectable({
	tolerance: "fit"
})

/* Remove the padding on 'body' which gets automatically added when the modal is opened */
$("#commu-modal").on("shown.bs.modal", function() {
	$("body").css("padding-right", "0")
})

$("#commu-select-btn").click(function() {
	var selectedRole = $("#commu-table tr.ui-selected")
	var selectedCommuId = $(selectedRole).children("td").first().text()
	var selectedCommuName = $(selectedRole).children("td:nth-child(2)").text()

	$("#commu-id").attr("value", selectedCommuId)
	$("#commu-name").attr("value", selectedCommuName)

	$("#commu-modal").modal("hide")
})

/*
	Aparment Selection Modal
*/

$("#apartment-table").selectable({
	tolerance: "fit"
})

/* Remove the padding on 'body' which gets automatically added when the modal is opened */
$("#apartment-modal").on("shown.bs.modal", function() {
	$("body").css("padding-right", "0")
})

$("#apartment-select-btn").click(function() {
	var selectedApartment = $("#apartment-table tr.ui-selected")
	var selectedAptId = $(selectedApartment).children("td").first().text()

	$("#apt-id").attr("value", selectedAptId)

	$("#apartment-modal").modal("hide")
})

/* Parent option selection */
$("#option-table").selectable({
	tolerance: "fit"
})

/* Remove the padding on 'body' which gets automatically added when the modal is opened */
$("#option-modal").on("shown.bs.modal", function() {
	$("body").css("padding-right", "0")
})

$("#option-select-btn").click(function() {
	var selectedOption = $("#option-table tr.ui-selected")
	var selectedOptId = $(selectedOption).children("td").first().text()

	$("#opt-id").attr("value", selectedOptId)
	$("#opt-name").attr("value", selectedOption)

	$("#option-modal").modal("hide")
})
