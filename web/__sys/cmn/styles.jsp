<%-- <%@page import="org.iq.ui.Style"%>
<%@page import="java.util.List"%>
<%@page import="org.iq.ui.StyleProvider"%>
<%
List<Style> styles = StyleProvider.getStyles();
if (styles != null && styles.size() > 0) {
	for (Style thisStyle : styles) {
%>
<link href="${pageContext.request.contextPath}/<%=thisStyle.getRelativePath()%>" rel="stylesheet" type="text/css" media="<%=thisStyle.getMedia()%>" />
<%
	}
}
%>
 --%>

<link href="${pageContext.request.contextPath}/__sys/css/screen/00-iq-reset.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/__sys/css/screen/01-iq-common.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/__sys/css/screen/02-iq-form.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/__sys/css/screen/03-table-sorter.css" rel="stylesheet" type="text/css" media="screen" />
