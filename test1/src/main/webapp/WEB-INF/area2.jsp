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
	select {margin : 5px;}
</style>
<body>
	<div id="app">
		<select v-model="si" @change="fnGuList">
			<option value="">:: 전체 ::</option>
			<option v-for="item in siList" :value="item.si">{{item.si}}</option>
		</select>
		<select v-model="gu" @change="fnDongList">
			<option value="">:: 전체 ::</option>
			<option v-for="item in guList" :value="item.gu">{{item.gu}}</option>
		</select>
		<select v-model="dong">
			<option value="">:: 전체 ::</option>
			<option v-for="item in dongList" :value="item">{{item.dong}}</option>
		</select>
		<button @click="fnApi">클릭</button>
		<hr>
		<div v-if="T1H != ''">{{dong.dong}}의 온도는 {{T1H}}</div>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				siList : [],
				si : "",
				guList : [],
				gu : "",
				dongList : [],
				dong : "",
				T1H : ""		
            };
        },
        methods: {
			fnArea(){
				var self = this;
				self.guList = [];
				self.gu = "";
				self.dongList = [];
				self.dong = "";
				var nparam = {};
				$.ajax({
					url:"si-list.dox",
					dataType:"json",	
					type : "POST", 
					data : nparam,
					success : function(data) { 
						self.siList = data.siList;
						
					}
				});
			},
			
			fnGuList(){
				var self = this;
				self.dongList = [];
				self.dong = "";
				var nparam = {si : self.si};
				$.ajax({
					url:"gu-list.dox",
					dataType:"json",	
					type : "POST", 
					data : nparam,
					success : function(data) { 
						self.guList = data.guList;
						
					}
				});
			},
			
			fnDongList(){
				var self = this;
				var nparam = {si : self.si, gu : self.gu};
				$.ajax({
					url:"dong-list.dox",
					dataType:"json",	
					type : "POST", 
					data : nparam,
					success : function(data) { 
						self.dongList = data.dongList;
					}
				});
			},
			
			fnApi(){
				// 추후 현재 날짜 정보가져와서 실시간 처리 로직 추가할 것
				var self = this;
				if(self.dong == ""){
					alert("동/읍을 선택해주세요.");
					return;
				}
				var nx = self.dong.nx;
				var ny = self.dong.ny;
				var xhr = new XMLHttpRequest();
				var url = 'http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst'; /*URL*/
				var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'26Jt6WG3w3Ea4on0SOc67nMTWJlJ0CwWzH2XHxhuBHYzBkwABUcem88lB39hBrLvCcp7P%2BDMdLp0nBvkx9QUYQ%3D%3D'; /*Service Key*/
				queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
				queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('1000'); /**/
				queryParams += '&' + encodeURIComponent('dataType') + '=' + encodeURIComponent('JSON'); /**/
				queryParams += '&' + encodeURIComponent('base_date') + '=' + encodeURIComponent('20240911'); /**/
				queryParams += '&' + encodeURIComponent('base_time') + '=' + encodeURIComponent('1700'); /**/
				queryParams += '&' + encodeURIComponent('nx') + '=' + encodeURIComponent(nx); /**/
				queryParams += '&' + encodeURIComponent('ny') + '=' + encodeURIComponent(ny); /**/
				xhr.open('GET', url + queryParams);
				xhr.onreadystatechange = function () {
				    if (this.readyState == 4) {
				        console.log('Status: '+this.status+'nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+'nBody: '+this.responseText);
						var responseJson = JSON.parse(this.responseText);
						var items = responseJson.response.body.items.item;
						for (var i = 0; i < items.length; i++) {
							var item = items[i];
							if(item.category == 'PTY'){
								// 강수 로직 처리, 1~7
								// obsrValue : 없음(0), 비(1), 비/눈(2), 눈(3), 빗방울(5), 빗방울눈날림(6), 눈날림(7) 
							}
							if(item.category == 'REH'){
								// 습도 로직 처리
								// obsrValue : 단위 % 
							}
							if(item.category == 'RN1'){
								// 1시간 강수량 로직 처리
								// obsrValue : 단위 mm
							}
							if(item.category == 'T1H'){
								// 온도 로직 처리
								// obsrValue : 단위 ℃
								self.T1H = item.obsrValue;
							}
							// .. 기타 나머지 로직 처리
						}
						
				    }
				};
				xhr.send('');
			}
        },
        mounted() {
			var self = this;
			self.fnArea();
        }
    });
    app.mount('#app');
</script>