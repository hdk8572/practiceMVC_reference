<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container">
  <h2><a href="${pageContext.request.contextPath}/boardList.do">Spring MVC01</a></h2>
  <div class="panel panel-default">
    <div class="panel-heading">BOARD</div>
    <div class="panel-body">
    	<table class="table table-boarded table-hover">
    		<tr>
    			<td>번호</td>
    			<td>제목</td>
    			<td>작성자</td>
    			<td>작성일</td>
    			<td>조회수</td>
    		</tr>
    		<c:forEach items="${list}" var="vo">
    		<tr>
    			<td>${vo.idx}</td>
    			<td><a href="${pageContext.request.contextPath}/boardContent.do/${vo.idx}">${vo.title}</a></td>
    			<td>${vo.writer}</td>
    			<td>${fn:split(vo.indate, " ")[0]}</td>
    			<td>${vo.count}</td>
    		</tr>
    		</c:forEach>
    	</table>
    	<a href="${pageContext.request.contextPath}/boardForm.do" class="btn btn-primary btn-sm">등록</a>
	</div>
	<div class="panel-footer">인프런_스프1탄_황대경</div>
  </div>
</div>

</body>
</html>