
// 질문 화면의 각 요소
const progressValueEl = document.querySelector('.progress .value')


let qNo = 0 // 현재 질문 번호
let mbti = '' // MBTI 결과

// 화면에 질문을 랜더링
function renderQuestion() {
  const question = questions[qNo]
  progressValueEl.style.width = (qNo + 1) * 10 + '%'
}
