
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--화면 상단의 메뉴 -->
<div class="navbar-wrapper">
	<div class="container">

		<nav class="navbar navbar-inverse navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Project name</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="<c:url value="/"/> ">Home</a></li>
						<li><a href="<c:url value="/users"/> ">Users</a></li>
						<li><a href="<c:url value="/todayamount"/> ">TodayAmount</a></li>
						<li><a href="<c:url value="/ranking"/> ">Ranking</a></li>
						<li><a href="<c:url value="/chartFromRecord"/> ">Chart</a></li>
						<li><a href="<c:url value="/mynicotine"/> ">My nicotine</a></li>
						<li><a href="<c:url value="/fargerstrom"/> ">FagerStrom Test</a></li>
						<li><a href="<c:url value="/insertUser"/> ">InsertUser</a></li>
						<li><a href="<c:url value="/insertRecord"/> ">InsertRec</a></li>
						<li><a href="<c:url value="/insertYesterDayRecord"/> ">InsertYesRec</a></li>
						
						
						
<!-- 						<li class="dropdown"><a href="#" class="dropdown-toggle" -->
<!-- 							data-toggle="dropdown" role="button" aria-haspopup="true" -->
<!-- 							aria-expanded="false">Dropdown <span class="caret"></span></a> -->
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li class="dropdown-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>
					<ul class="nav navbar-nav pull-right">
						<c:if test="${pageContext.request.userPrincipal.name != null}">
							<li><a>Welcome ${pageContext.request.userPrincipal.name}</a></li>
							<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
								<li><a href="<c:url value="/admin"/> ">AdminPage</a></li>
							</c:if>
							<li><a href="<c:url value="/logout"/> ">Logout</a></li>
						</c:if>
						<c:if test="${pageContext.request.userPrincipal.name == null}">
							<li><a href="<c:url value="/login"/> ">Login</a></li>
						</c:if>
					</ul>

				</div>
			</div>
		</nav>

	</div>
</div>
