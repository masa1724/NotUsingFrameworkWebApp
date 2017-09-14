<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <h3>header!</h3>
</header>

<main id="main" role="main" class="main">
  <div class="main-container">
    <form method="POST" action='<c:url value="/SampleResult"/>'>
	  <input type="text" name="year" size="4">年
	  <input type="text" name="month" size="2">月
	  <input type="text" name="day" size="2">日
	  <button type="submit">送信</button>
	</form>
  </div><!--.main-container-->
</main>

<footer id="footer" role="contentinfo" class="footer">
  <h3>footer</h3>
</footer>

</div><!-- .wrapper -->
</body>
</html>