<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container-wrapper">
	<div class="container">
		<h2>Today Amount</h2>
		<p class="lead">오늘의 흡연량 입니다.</p>
		<table class="table table-striped">
			<thead>
				<tr class="bg-success">
					<th>TodayAmount</th>
				</tr>
			</thead>
			<tbody>
					<tr>
						<td>${todayAmount}</td>
					</tr>
			</tbody>
		</table>
	</div>
</div>