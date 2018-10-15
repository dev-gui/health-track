$(document).ready(function () {
  // Rolagem suave
  $("#seta1,#seta2").on('click', function (event) {
    if (this.hash !== "") {
      event.preventDefault();
      var hash = this.hash;
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 800, () => {
        window.location.hash = hash;
      });
    }
  });
  // validacao
  $.validate({
    modules: "html5",
    validateOnBlur: true
  })
  // Shake para os arrows
  $("#seta1,#seta2").click(function () {
    $(this).effect({ effect: "shake", direction: "up", times: 1 })
  })
})