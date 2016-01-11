$(".select-all").click(function() {
    if($(this).is(":checked")) {
        $(this).parent(".panel-heading").siblings(".panel-body").find("input").prop("checked", true)
    } else {
        $(this).parent(".panel-heading").siblings(".panel-body").find("input").prop("checked", false)
    }
})

/* For apartments page */

$(".select-all").click(function() {
    if($(this).is(":checked")) {
		$("tr td").find("input").prop("checked", true)
    } else {
        $("tr td").find("input").prop("checked", false)
    }
})

// $("#select-all").click(function(event) {
// 	$(this).find("span").toggleClass("glyphicon-ok")
// 	$(this).find("span").toggleClass("glyphicon-remove")
//
// 	$("label:not(#select-all)").each(function() {
// 		$(this).find("span").toggleClass("glyphicon-ok")
// 		$(this).find("span").toggleClass("glyphicon-remove")
// 	})
// })
