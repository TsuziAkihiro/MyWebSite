$(function() {
  $('.detail-show').click(function(){
    $('.detail-modal').fadeIn();
  });

  // 「.close-modal」要素にclickイベントを設定してください
  $('.close-modal').click(function(){
    $('.detail-modal').fadeOut();
  })


});
