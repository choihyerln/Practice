export const questions = [
  {
    number: '01',
    question: '질문1',
    choices: [
      { text: '텍스트1', value: 'i' },
      { text: '텍스트2', value: 'e' }
    ]
  },
  {
    number: '02',
    question: '질문2',
    choices: [
      { text: '텍스트1', value: 's' },
      { text: '텍스트2', value: 'n' }
    ]
  },
  {
    number: '03',
    question: '질문5',
    choices: [
      { text: '텍스트1', value: 'f' },
      { text: '텍스트2', value: 't' }
    ]
  },
  {
    number: '04',
    question: '질문4',
    choices: [
      { text: '텍스트1', value: 'j' },
      { text: '텍스트2', value: 'p' }
    ]
  },
  {
    number: '05',
    question: '질문5',
    choices: [
      { text: '텍스트1', value: '' },
      { text: '텍스트2', value: '' }
    ]
  },
  {
    number: '06',
    question: '질문6',
    choices: [
      { text: '텍스트1', value: '' },
      { text: '텍스트2', value: '' }
    ]
  },
  {
    number: '07',
    question: '질문7',
    choices: [
      { text: '텍스트1', value: '' },
      { text: '텍스트2', value: '' }
    ]
  },
  {
    number: '08',
    question: '질문8',
    choices: [
      { text: '텍스트1', value: '' },
      { text: '텍스트2', value: '' }
    ]
  },
  {
    number: '09',
    question: '질문9',
    choices: [
      { text: '텍스트1', value: '' },
      { text: '텍스트2', value: '' }
    ]
  },
  {
    number: '10',
    question: '질문10',
    choices: [
      { text: '텍스트1', value: '' },
      { text: '텍스트2', value: '' }
    ]
    
  },

  {
    number: '11',
    question: '질문10',
    choices: [
      { text: '텍스트1', value: '' },
      { text: '텍스트2', value: '' }
    ]
    
  },
  {
    number: '12',
    question: '질문10',
    choices: [
      { text: '텍스트1', value: '' },
      { text: '텍스트2', value: '' }
    ]
    
  },
] //질문 고르기, 질문선택지가 늘어나면 개수 더 만들기
export const results = [
  {
    title: '출근 시간은<br>내가 정해!',
    character: '/images/result_character1.png',
    results: [
      '혼자서 멘탈 케어가 가능해요!<br>소속이 없어도, 벌이가 불안정해도 저는 지금이 좋아요!',
      '일에 대한 욕심이 많아요.<br>행복한 야근이라고 할 수 있어요!',
      '자유로운 환경에서 더 잘해요!<br>하지만 누구보다 스스로 시간 관리가 철저해요:)',
      '리더십 있다는 소리를 자주 들어요.<br>추진력이 있는 편이죠~ (뿌듯)'
    ],
    
  },
  {
    title: '프로직진러!<br>진행력 갑',
    character: '/images/result_character2.png',
    results: [
      '나는야 회사 사람들 멘탈 지킴이!<br>언제나 토닥토닥 으샤으샤 응원하며 다니는 파워 인싸!',
      '여러 사람과 협업이 필요한 직무에 찰떡!',
      '진행력 갑! 추진력 갑!<br>빠른 속도로 동시에 여러 업무를 해결할 수 있어요.',
      '회사 행사나 크리스마스 이벤트,<br>회사사람들 생일까지 우리가 다 챙길게요'
    ],
    
  },
  {
    title: '결과창',
    character: '/images/result_character3.png',
    results: [
      '결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!'
    ],
   
  },
  {
    title: '결과창',
    character: '/images/result_character4.png',
    results: [
      '결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!'
    ],
   
  },
  {
    title:  '결과창',
    character: '/images/result_character5.png',
    results: [
      '결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!'
    ],
   
  },
  {
    title:  '결과창',
    character: '/images/result_character6.png',
    results: [
      '결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!결과창!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!'
    ],
    // 결과 설명 나타내는 창 테스트마다 있던 텍스트 입력?
  }
]
export const mbtis = {
  entj: 0,
  entp: 0,
  estp: 0,
  esfp: 1,
  esfj: 1,
  enfj: 1,
  infp: 2,
  isfp: 2,
  isfj: 2,
  infj: 2,
  estj: 3,
  istp: 3,
  intj: 4,
  intp: 4,
  istj: 4,
  enfp: 5
}
 //mbtis: 결과값 나오는 설정, 테스트마다 맞춰 수정