

function detail(isbn10, isbn13) {
  var target = "isbn";
  var query = isbn10
  window.location = "/bookDetail/" + target + "/" + query;
}


function search() {
  var form = {
    target: $("#searchTargetSelect option:selected").text(),
    sort: $("#searchSortSelect option:selected").text(),
    category: $("#categorySelect option:selected").text(),
    query: $("#query").val(),
    page: $("#page").val(),
    size: $("#size").val()
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
      alert(data.responseJSON.message);
    }
  });
};


