<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/layout/menu.jsp"></jsp:include>
	<title>view 기본 세팅 파일</title>
</head>
<style>
	table {
			margin : 20px;
		}
	table, tr, th, td {
		border : 1px solid black;
		padding : 5px 5px;
		border-collapse: collapse;
	}
</style>
<body>
	<div id="app">
		<table>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>학부</th>
				<th>학과</th>
				<th>담당교수</th>
			</tr>
			<tr>
				<td>{{info.stuNo}}</td>
				<td>{{info.name}}</td>
				<td>{{info.dName}}</td>
				<td>{{info.dName}}</td>
				<td>{{info.position}}</td>
			</tr>	
		</table>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				info : {},
				stuNo : '${stuNo}'
            };
        },
        methods: {
			fnStuInfo(){
				var self = this;
				var nparmap = {stuNo : self.stuNo};
				$.ajax({
					url:"/school-stuView.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						console.log(data);
						self.info = data.list;
					}
				});
            },
        },
        mounted() {
			var self = this;
			self.fnStuInfo();
        }
    });
    app.mount('#app');
</script>
​