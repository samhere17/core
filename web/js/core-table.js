(function($) {
	var settings

	$.fn.buildTable = function(parameters) {
		console.log(parameters)

		/* Preparing settings with default options */
		settings = $.extend({
			responsive : true,
			striped : true,
			bordered : true,
			populateSampleData : false,
			sampleHeader : [ "Heading #1", "Heading #2", "Heading #3" ],
			sampleData : [
					[ "Row #1 Col #1", "Row #1 Col #2", "Row #1 Col #3", ],
					[ "Row #2 Col #1", "Row #2 Col #2", "Row #2 Col #3", ],
					[ "Row #3 Col #1", "Row #3 Col #2", "Row #3 Col #3", ] ],
			header : [],
			data : [],
			sort : false,
			sortParam : {

			}
		}, parameters)

		if($(this).is("table")) {
			var tableId = $(this).attr('id')

			/* Clearing all contents of table */
			$(this).html('')

			/* Preparing front end */
			$(this).addClass('core-table')
			$(this).addClass('table')

			if(settings.responsive) {
				if ($(this).parent().hasClass('table-responsive') == false) {
					$(this).wrap('<div class="table-responsive"></div>')
				}
			}

			if(settings.striped) {
				$(this).addClass('table-striped')
			}

			if(settings.bordered) {
				$(this).addClass('table-bordered')
			}

			/* Preparing table */
			if($.isEmptyObject(settings.header) == true && $.isEmptyObject(settings.data) == true) {
				// both header and data are empty
				console.log('both header and data are empty')
				if(settings.populateSampleData) {
					addHeading($(this), settings.sampleHeader, settings)
					addData($(this), settings.sampleData, settings)
				}
			} else if($.isEmptyObject(settings.header) == false && $.isEmptyObject(settings.data) == true) {
				// header has elements but data is empty
				console.log('header has elements but data is empty')
				addHeading($(this), settings.header, settings)
				addNoRecord($(this), settings)
			} else if($.isEmptyObject(settings.header) == true && $.isEmptyObject(settings.data) == false) {
				// header is empty but data has elements
				console.log('header is empty but data has elements')

			} else if($.isEmptyObject(settings.header) == false && $.isEmptyObject(settings.data) == false) {
				// both header and data has elements
				console.log('both header and data has elements')
				addHeading($(this), settings.header, settings)
				addData($(this), settings.data, settings)
			}

			/* Checking if table has head and body */
			if($(this).find('thead').length > 0 && $(this).find('tbody').length > 0) {
				/* table has head and body, hence performing additional task */

				/* Setting up sorter */
				if (settings.sort) {
					$(this).tablesorter(settings.sortParam)

					$(this).bind("sortEnd", function() {
						$(this).find("th").each(function(index, element) {
							var sortIcon = $(element).find("i")
							sortIcon.removeClass("fa-sort-desc").removeClass("fa-sort-asc").addClass("fa-sort")
							if($(element).hasClass("headerSortDown")) {
								sortIcon.removeClass("fa-sort").addClass("fa-sort-asc")
							} else if($(element).hasClass("headerSortUp")) {
								sortIcon.removeClass("fa-sort").addClass("fa-sort-desc")
							}
						})
					})

					if($(this).parent().find('div.sort-info').length == 0) {
						$('<div class="sort-info small"><p><i class="fa fa-fw fa-info-circle"></i> To sort a column click on it. Sort multiple columns simultaneously by holding down the shift key and clicking a second, third or even fourth column header!</p></div>').insertBefore(this)
					}
				}
			} else {
				/* table does not have head and body, hence hiding table */
				$(this).hide()
			}
		} else {
			$.error($(this).attr('id') + ' is not a table')
		}
		// return this
	}

	addHeading = function(table, headingArr, settings) {
		var heading = ''
		$.each(headingArr, function(index, value) {
			heading = heading + '<th class="text-center"><div><span>' + value
					+ '</span>'
			if (settings.sort) {
				heading = heading + ' <i class="fa fa-fw fa-sort"></i>'
			}
			heading = heading + '</div></th>'
		})

		var header = '<thead><tr>' + heading + '</tr></thead>'
		table.append(header)
	}

	addData = function(table, dataArr, settings) {
		var tbodyContent = ''

		$.each(dataArr, function(index, row) {
			tbodyContent = tbodyContent + '<tr>'

			$.each(row, function(index, col) {
				tbodyContent = tbodyContent + '<td class="text-center">' + col + '</td>'
			})
			tbodyContent = tbodyContent + '</tr>'
		})

		var body = '<tbody>' + tbodyContent + '</tbody>'
		table.append(body)
	}

	addNoRecord = function(table, settings) {
		var body = '<tbody><tr><td class="text-center" colspan="'
				+ settings.header.length + '">No record</td></tr></tbody>'
		table.append(body)
	}
}(jQuery))
