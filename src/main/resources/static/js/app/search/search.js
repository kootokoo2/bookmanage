$('#searchButton').on('click', function search() {
  var target =$("#searchTargetSelect option:selected").text();
  var query =$('#query').val();
  $.ajax({
    type: 'GET',
    url: "/searchBook/" + target + "/" +query,
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
    url: "/bookDetail/" + target + "/" +query,
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