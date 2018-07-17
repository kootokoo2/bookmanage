$('#searchButton').on('click', function search() {
  var form = {
    target: $("#searchTargetSelect option:selected").text(),
    query: $('#query').val()
  };

  $.ajax({
    type: 'POST',
    data: JSON.stringify(form),
    contentType: "application/json; charset=UTF-8",
    url: "/searchBook/",
    success: function (data) {
      $(".dim-wrapper").hide();
      $('#sub-content').html(data);

    },
    error: function (data) {
      $(".dim-wrapper").hide();
      alert(data.responseJSON.message)

    }
  });
});

function searchDetailBook(data) {
  var target = "isbn";
  var query = data;

  $.ajax({
    type: 'GET',
    url: "/bookDetail/" + target + "/" + query,
    success: function (data) {
      $(".dim-wrapper").hide();
      $('#sub-content').html(data);
    },
    error: function (data) {
      $(".dim-wrapper").hide();
      alert(data.responseJSON.message)
    }
  });
};

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