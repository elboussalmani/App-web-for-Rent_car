
// Fixed promo
(function($) {
	$(window).on('scroll', function() {
		var fromTopPromo = $(this).scrollTop();
		if (fromTopPromo > 190) {
			$('.promo-set').addClass('promo-set-view');
		} else {
			$('.promo-set').removeClass('promo-set-view');
		}

	});

})(jQuery);