<%-- 
<%@page import="org.iq.ui.Script"%>
<%@page import="org.iq.ui.ScriptProvider"%>
<%@page import="java.util.List"%>
<%
List<Script> scripts = ScriptProvider.getScripts();
if (scripts != null && scripts.size() > 0) {
	for (Script thisScript : scripts) {
%>
<script src="${pageContext.request.contextPath}/<%=thisScript.getRelativePath()%>" type="text/javascript"></script>
<%
	}
}
%>
 --%>

<%-- <script src="<%=rootLink%>/js/iq-form.js" type="text/javascript"></script>
<script src="<%=rootLink%>/js/jquery-1.11.1.min.js" type="text/javascript"></script>
 --%>
 <%-- <script src="<%=rootLink%>/js/jquery-ui.min.js" type="text/javascript"></script> --%>
 
<script src="${pageContext.request.contextPath}/__sys/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/__sys/js/jquery.tablesorter.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/__sys/js/iq-form.js" type="text/javascript"></script>
