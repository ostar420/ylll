<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String pdfName = request.getAttribute("pdfName")==null?"/":(String) request.getAttribute("pdfName");
%>
<!doctype html>
<html>
	<head>
		<title>read pdf online</title>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/static/js/pdfobject.js"></script>	
		<script type="text/javascript">
      		window.onload = function (){
        		var myPDF = new PDFObject({ url: "${pageContext.request.contextPath}/pdf/getpdf/<%=pdfName%>" }).embed();
      		};

</script>
	</head>
	<body>
		<p>It appears you don't have Adobe Reader or PDF support in this web
                    browser. <a href="${pageContext.request.contextPath}/pdf/getpdf/<%=pdfName%>">Click here to download the PDF</a>
                </p>
	</body>
</html>
