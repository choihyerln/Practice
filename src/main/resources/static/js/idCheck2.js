    function id_overlap_check() {
    	$('#id').change(function () {
	        $('#id_check_sucess').hide();
	        $('.id_overlap_button').show();
	        $('#id').attr("check_result", "fail");
      	})
      	if ($('#id').val() == '') {
	      alert('아이디를 입력해주세요.')
	      return;
    	}
    	id_overlap_input = document.querySelector('input[name="id"]');

        $.ajax({
          url: "{% url 'lawyerAccount:id_overlap_check' %}",
          data: {
            'id': id_overlap_input.value
          },
          datatype: 'json',
          success: function (data) {
            console.log(data['overlap']);
            if (data['overlap'] == "fail") {
              alert("이미 존재하는 아이디 입니다.");
              id_overlap_input.focus();
              return;
            } else {
              alert("사용가능한 아이디 입니다.");
              $('#id').attr("check_result", "success");
              $('#id_check_sucess').show();
              $('.id_overlap_button').hide();
              return;
            }
          }
        });

        if ($('#id').attr("check_result") == "fail"){
          alert("아이디 중복체크를 해주시기 바랍니다.");
          $('#id').focus();
          return false;
        }
      }

