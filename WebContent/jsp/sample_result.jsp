<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf8"%>
<%@ page import="java.util.Map, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <meta name="title" content="タイトル"/>
  <meta name="viewport" content="width=device-width,initial-scale=1"/>
  <meta name="description" content="ディスクリプション"/>
  <meta name="keywords" content="キーワード"/>

  <!-- Common 
  <link rel="stylesheet" type="text/css" href="./reset.css" media="all"/>
  <link rel="stylesheet" type="text/css" href="./common.css" media="all"/>
  PC
  <link rel="stylesheet" type="text/css" href="./pc.css" media="screen and (min-device-width:481px)"/>
  <!--スマホ
  <link rel="stylesheet" type="text/css" href="./iphone.css" media="only screen and (max-device-width:480px)"/>
　　
  <script type="text/javascript" src="./script.js"></script>
  -->
   <link rel="stylesheet" type="text/css" href='<c:url value="/css/pc.css"/>' media="screen and (min-device-width:481px)"/>
  <link rel="stylesheet" type="text/css" href='<c:url value="/css/iphone.css"/>' media="only screen and (max-device-width:480px)"/>
  
 
</head>
<body>
<div id="wrapper" class="wrapper">

<header id="header" role="banner" class="header">
  <h3>header area</h3>
</header>

<main id="main" role="main" class="main">
  <div class="main-container">
  <span><c:out value="${day}"/></span>
  
    <!-- レコードが1件以上の場合 -->
	<c:if test="${fn:length(userList)>=1}">
  	<table border="1">
  	  <tr>
  	    <th>system_user_id</th>
        <th>email</th>
        <th>password</th>
        <th>name</th>
        <th>status</th>
        <th>error_count</th>
        <th>last_login_time</th>
        <th>created</th>
        <th>modified</th>
  	  </tr>
  	<c:forEach var="user" items="${userList}">
  	  <tr>
  		<td><c:out value="${user.system_user_id}"/></td>
  		<td><c:out value="${user.email}"/></td>
  		<td><c:out value="${user.password}"/></td>
  		<td><c:out value="${user.name}"/></td>
  		<td><c:out value="${user.status}"/></td>
  		<td><c:out value="${user.error_count}"/></td>
  		<td><c:out value="${user.last_login_time}"/></td>
  		<td><c:out value="${user.created}"/></td>
  		<td><c:out value="${user.modified}"/></td>
  	  </tr>
	</c:forEach>
	</table>
	</c:if>

	<!-- レコードが0件の場合 -->
	<c:if test="${fn:length(userList)==0}">
		<b>レコードが0件です。</b>
	</c:if>
  </div><!--.main-container-->
</main>

<footer id="footer" role="contentinfo" class="footer">
  <h3>footer area</h3>
</footer>

</div><!-- .wrapper -->
</body>
</html>