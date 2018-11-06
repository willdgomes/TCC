var w = $(window).width();
$(function (){
  ToggleMenu();
  $('.toggler').click(function(){
    $('.sidebar').toggleClass('d-none');
    $('.toggler-menu').toggleClass('d-none');
    $('.toggler-clear').toggleClass('d-none');
  });
  $('.nav-link[data-toggle="collapse"]').click(function(){
    $(this).find('.caret').toggleClass('closed');
  });
  $('[data-toggle="tooltip"]').tooltip();
  $('[data-toggle="popover"]').popover({trigger: 'focus'});
});
$('body').on('click', function(e) {
  if($(e.target).closest('.toggler').length == 0 && $(e.target).closest('.sidebar').length == 0) {
    if($(window).width() < 992) {resetToggleMenu();}
  }
});
$(window).resize(function(){
  if ($(window).width()==w) return;
  w = $(window).width();
  ToggleMenu();
});
function ToggleMenu(){
  if($(window).width() < 992) {resetToggleMenu();}
  else {$('.sidebar').removeClass('d-none');}
}
function resetToggleMenu(){
  $('.toggler-menu').removeClass('d-none');
  $('.toggler-clear').addClass('d-none');
  $('.sidebar').addClass('d-none');
}
