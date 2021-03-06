<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/common/global.jsp"%>
<title>详情</title>
<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/include-jquery.jsp"%>
<%@ include file="/common/include-bootstap.jsp"%>
<script src="${ctx }/js/grid.js"></script>
<%@ include file="/common/include-styles.jsp"%>
</head>
<body class="editBody">
	<button class="btn btn-info btn-sm pull-left"  onclick="javascript:location.href='${ctx}/tour/reported!findPage.action?statisticType=1&status=1'">
		<span class="glyphicon glyphicon-backward"></span> 返回列表
	</button>
	<div class="clearfix" style="margin-bottom: 20px;"></div>
	<form method="post" id="deleteForm">
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>名称</th>
					<th>收入&nbsp;<font color="green">(万元)</font></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="details">
					<tr>
						<td>${name }</td>
						<td>${money }</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</form>
</body>
</html>
