<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tratando erros com Ajax e VRaptor</title>
<script type="text/javascript" src="<c:url value="/js/jquery-1.5.min.js" />" charset="utf-8"></script>

<script type="text/javascript">
function testaCodigo() {
	$.ajax({
		url : "<c:url value='/testaCodigo' />",
		type: "post",
		dataType: "json",
		data: "codigo=" + $("#codigo").val(),
		success: function (data) {
			alert(data);
		},
		error: function (jXHR, textStatus, errorThrown) {
			alert(jXHR.responseText);
		}
	});

}	
</script>
</head>
<body>
	<label>Digite o c&oacute;digo:</label>
	<input type="text" name="codigo" id="codigo" />
	
	<button onclick="testaCodigo()">Testar</button>
</body>
</html>