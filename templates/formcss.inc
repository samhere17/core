<%
	if (reqCssClassNames.isEmpty() == false) {
%>
<style type="text/css" media="screen">
<%
		for (String cssClassName : reqCssClassNames) {
			String cssString = (String)cssProps.get(cssClassName);
%>
<%=cssClassName%> {<%=StringUtil.isEmpty(cssString) ? "" : cssString%>}
<%			
		}
%>
</style>
<%
	}
%>