$('#singInBtn').on('click', function signin() {
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
      location.href= "/book/main"
    },
    error: function (data) {
      alert(data.message()); //error message
    }
  });
});