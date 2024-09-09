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
</style>
<body>
	<div id="app">
		<input type="text" placeholder="아이디">
		<button>중복체크</button>
		<input type="text" placeholder="비밀번호">
		<input type="text" placeholder="비밀번호확인">
		<button></button>
		<input type="text" placeholder="핸드폰번호">
		<button>중복체크</button>
		<input type="text" placeholder="주소">
		<button>중복체크</button>
		
	</div>
</body>
</html>
<script>
	const app = Vue.createApp({
        data() {
            return {
				info : {}
            };
        },
        methods: {
			fnGetList(){
				var self = this;
				var nparmap = {};
				$.ajax({
					url:"sample-list.dox",
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
			this.fnGetList();
        }
    });
    app.mount('#app');
</script>