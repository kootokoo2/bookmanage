$('#searchButton').on('click', function search() {
  var target =$("#searchTargetSelect option:selected").text();
  var query =$('#query').val();

  $.ajax({
    type: 'GET',
    url: "/searchBook/" + target + "/" +query,
    success: function (data) {
      $('#searchResult').html(data);
    },
    error: function (data) {
      alert(data.responseJSON.message)
    }
  });
});