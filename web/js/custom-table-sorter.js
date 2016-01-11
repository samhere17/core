/* Make tables sortable */
$("#dweller-table, #apartment-table").tablesorter({
	/* Ascending sort */
	sortList: [[0, 0]],

	/* The library uses opposite terms */
	cssAsc: "descending",
	cssDesc: "ascending"
})

/*	Make table sortable
 *	This table has a input field in the header hence we need
 *	different configurations
*/
$("#apartment-list-table").tablesorter({
	/*	Ascending sort	*/
	sortList: [[1, 0]],

	/*	The library uses opposite terms */
	cssAsc: "descending",
	cssDesc: "ascending",

	/*	Disable sorting on coloumn which has the input field
	*	'ascending' and 'descending' won't be added to this coloumn.
	*	Hence the followwing code inside bind() won't affect this coloumn.
	*/
	headers: {
		0: {
			sorter: false
		}
	}
})

/* Change the Glyphicon once the coloumn has been sorted */
$("#dweller-table, #apartment-table, #apartment-list-table").bind("sortEnd", function() {
	/* For each coloumn in the table... */
	$("#dweller-table th, #apartment-table th, #apartment-list-table th").each(function(index, element) {
		/*
		*	If the coloumn head has the class 'ascending',
		*	remove the up chevron and add the down chevron
		*/
		if($(element).hasClass("ascending")) {
			var childSpan = $(element).children("span")
			childSpan.removeClass("glyphicon-chevron-up").addClass("glyphicon-chevron-down")
		}

		/*
		*	If the coloumn head has the class 'descending',
		*	remove the down chevron and add the up chevron
		*/
		else if($(element).hasClass("descending")) {
			var childSpan = $(element).children("span")
			childSpan.removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-up")
		}
	})
})
