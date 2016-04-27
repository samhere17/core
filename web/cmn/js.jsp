        <%-- <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script> --%>

		<!--[if lt IE 9]>
			<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
		<![endif]-->

		<!--[if gte IE 9]>
			<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<![endif]-->

		<!--[if !IE]><!-->
			<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<!--<![endif]-->

        <script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <%-- <script src="${pageContext.request.contextPath}/js/bootstrap-select.min.js"></script> --%>
        <script src="${pageContext.request.contextPath}/js/bootstrap-toggle.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/sidr.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/touchwipe.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/tablesorter.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/custom-table-sorter.js"></script>
        <%-- <script src="${pageContext.request.contextPath}/js/custom-sidr.js"></script> --%>


        <script src="${pageContext.request.contextPath}/js/password-visibility-toggler.js"></script>
        <script src="${pageContext.request.contextPath}/js/all-checkbox-selector.js"></script>
        <script src="${pageContext.request.contextPath}/js/lookup-modals.js"></script>
        <script src="${pageContext.request.contextPath}/js/height-and-margin.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap-filestyle.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/validation.js"></script>

        <script>
            $(".dropdown-menu").click(function(e) {
                e.stopPropagation()
            })

			$('[data-toggle="tooltip"]').tooltip()

			$(".sub-dropdown").click(function() {
				var clickedItem = this

				$(".sub-dropdown").each(function(index, el) {
					if(el != clickedItem) {
						$(el).find(".sub-dropdown-menu").hide()
					}
				})

				$(clickedItem).find(".sub-dropdown-menu").toggle()
			})

			$(".dropdown").on("hide.bs.dropdown", function() {
				$(".sub-dropdown").find(".sub-dropdown-menu").hide()
			})

			$(".navbar-collapse").css("maxHeight", ($(window).height() - 60) - $(".navbar-header").height() + "px")

			/* Enable tooltip */
			$(function () {
				$('[data-toggle="tooltip"]').tooltip()
			})

			/* Accordion */

			$(".expand-all").click(function(event) {
				$(".panel-collapse.collapse").addClass("in");
			})

			$(".collapse-all").click(function(event) {
				$(".panel-collapse.collapse").removeClass("in");
			})
        </script>

<!-- File drag and drop -->
<script src="${pageContext.request.contextPath}/js/core-file-drag-n-drop.js"></script>