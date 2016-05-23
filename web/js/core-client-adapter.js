(function($) {

	$.requestCore = function(options) {
		console.log(options)
		/* Preparing options with default options */
		if (options && typeof(options) == 'object') {
			options = $.extend( {}, $.requestCore.defaults, options )
		}
		
		alert(options.action)
		
		window.location.href = "adapter?requested-action="+launchAction
		console.log("called - "+launchAction)

		
		function callFunction(func){
			if ( $.isFunction(func)) {
				func.call(this)
			}
		}
	}
	
	$.requestCore.defaults = {
		
	}
})(jQuery)
