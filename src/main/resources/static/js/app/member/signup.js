
$('#singUpBtn').on('click', function signup() {
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
      location.href= "/signin"
    },
    error: function (data) {
      alert(data.responseJSON.message)
    }
  });
});