function bookmarkchange(data) {
  var form = {
    isbn: data
  };

  var thisCheck = $(this);

  if (thisCheck.is(':checked')) {

  } else {
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
};