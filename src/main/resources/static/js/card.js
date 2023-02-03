$(document).ready(function () {
  let emojiUrl = '';

  let ver = 1;
  $('#card1').click(function () {
    $.ajax({
      type: 'post',
      url: 'myPage',
      data: { ver: ver },
      success: function (data) {
		console.log(data)
        $('#card1-top').text('챌린지로 ' + data['top'] + ' 아낀 비용');
        $('img#card1-emoji').attr('src', emojiUrl + data['emoji']);
        $('#card1-emoji-txt').text(data['etxt']);
        $('#card1-bottom').text(data['bottom']);
        $('#card1-right').text(data['right']);
        if (ver == 2) {
          ver = 0;
        } else {
          ver++;
        }
      },
    });
  });
});
