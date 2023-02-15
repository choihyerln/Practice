window.onload = function getTime() {
    var d = new Date();	// 현재 날짜와 시간
    var year = d.getFullYear();
    var month = d.getMonth() + 1;
    var day = d.getDate();
    var hur = d.getHours();	
    var min = String(d.getMinutes()).padStart(2, "0");

    var timeBoard = document.getElementById("WhatTimeIsItNow"); // 값이 입력될 공간

    var time = year + "-" + month + "-" + day + " " + hur + ":" + min + " 갱신";
    
    timeBoard.innerHTML = time;	// 출력
    
    setTimeout(getTime, 300000);	// 5분마다 갱신
}