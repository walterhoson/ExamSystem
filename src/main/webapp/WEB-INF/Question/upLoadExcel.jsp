<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../resources/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="../resources/js/upLoadExcel.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upLoadExecl</title>
</head>
<body>
	<form id="QueryForm" action="insertquestion" method="post"
		enctype="multipart/form-data">
		<h3 class="box-title">请选择上传的文件:</h3>
		<input id="excel_file" class="form-control" type="file" name="file" accept="xlsx" size="80" /> 
		<input type="submit" id="upload" value="上传" align="right" onclick="doUpload()">
	</form>
</body>
</html>