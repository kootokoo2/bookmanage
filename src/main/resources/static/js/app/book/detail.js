$(document).on('change', '.checkbox', function(event) {
  var form = {
    isbn: $(event.currentTarget).data("isbn")
  }

  if (this.checked) {
    $.ajax({
      type: 'POST',
      data: JSON.stringify(form),
      url: "/bookmark/save",
      contentType: "application/json; charset=UTF-8",
      success: function (data) {
      },
      error: function (data) {
        alert(data.responseJSON.message)
      }
    });
  } else {
    $.ajax({
      type: 'POST',
      data: JSON.stringify(form),
      url: "/bookmark/delete",
      contentType: "application/json; charset=UTF-8",
      success: function (data) {
      },
      error: function (data) {
        alert(data.responseJSON.message)
      }
    });
  }
});