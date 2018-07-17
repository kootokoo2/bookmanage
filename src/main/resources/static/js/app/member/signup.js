
$('#singUpBtn').on('click', function signup() {
  $(".dim-wrapper").hide();
  var form = {
    userId: $('#userId').val(),
    password: $('#password').val()
  };
  $.ajax({
    type: 'POST',
    data: JSON.stringify(form),
    url: "/member/signUp",
    contentType: "application/json; charset=UTF-8",
    success: function (data) {
      $(".dim-wrapper").show();
      location.href= "/signin"
    },
    error: function (data) {
      $(".dim-wrapper").show();
      alert(data.responseJSON.message)
    }
  });
});