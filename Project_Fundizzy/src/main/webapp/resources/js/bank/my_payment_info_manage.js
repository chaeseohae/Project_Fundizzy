$(function(){
	//계좌 연결
	$("#auth-button").on("click", function(){
		console.log("버튼 클릭됨");
		// 빈 새창을 열고 이름은 authwindow로 주고 width=500 height=700을 준다
		let authWindow = window.open("about:blank", "authWindow", "width=500,height=700");
		// authwindow의 주소값 전달 (// 요청주소에서 testapi로 수정해야함)
			authWindow.location = "https://testapi.openbanking.or.kr/oauth/2.0/authorize?"
								+ "response_type=code"
								+ "&client_id=4066d795-aa6e-4720-9383-931d1f60d1a9"
								+ "&redirect_uri=http://localhost:8081/callback"
								+ "&scope=login inquiry transfer"
								+ "&state=12345678901234567890123456789012"
								+ "&auth_type=0";
	});
	
});
