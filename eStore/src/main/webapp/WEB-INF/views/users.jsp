<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container-wrapper">
	<div class="container">
		<h2>Product Inventory Page</h2>
		<p class="lead">제품 재고 현황입니다.</p>
		<table class="table table-striped">
			<thead>
				<tr class="bg-success">
					<th>UID</th>
					<th>Mac</th>
					<th>Nick</th>
					<th>Tobacco</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.uid}</td>
						<td>${user.mac}</td>
						<td>${user.nick}</td>
						<td>${user.tobac.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>