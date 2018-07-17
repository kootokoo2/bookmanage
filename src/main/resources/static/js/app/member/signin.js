var isRunning = false;

$('#signInBtn').on('click', function signin() {
  if (isRunning == true) {
    return;
  }
  isRunning = true;
  var form = {
    userId: $('#userId').val(),
    password: $('#password').val()
  };
  $.ajax({
    type: 'POST',
    data: JSON.stringify(form),
    url: "/member/signIn",
    contentType: "application/json; charset=UTF-8",
    success: function (data) {
      $(".dim-wrapper").show();
      isRunning = false;
      location.href = "/book/main"
    },
    error: function (data) {
      $(".dim-wrapper").show();
      isRunning = false;
      alert(data.responseJSON.message);
      location.href = "/signup"
    }
  });

});