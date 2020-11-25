'use strict';

$.fn.cookieBar = function (options) {
  var settings = $.extend({
    'acceptButton': '.js-cookieBarAccept',
    'secure': false,
    'path': '/',
    'domain': '',
    'threshold': 500
  }, options);

  var _hide = function _hide($cookiebar) {
    $cookiebar.attr('aria-hidden', 'true').attr('aria-live', 'off').hide();
  };

  var _show = function _show($cookiebar) {
    $cookiebar.attr('aria-hidden', 'false').attr('aria-live', 'polite').show();
  };

  var _accept = function _accept($cookiebar) {
    $.cookie('cookiebar', 'hide', {
      path: settings.path,
      secure: settings.secure,
      domain: settings.domain,
      expires: 30
    });
    $(document).trigger('accept.cookiebar', [$cookiebar]);
  };

  $(document).on('accept.cookiebar', function (e, $cookiebar) {
    _hide($cookiebar);
  });

  $.cookieBar = $.cookieBar || {};

  $.cookieBar.isAccepted = function () {
    return $.cookie('cookiebar') === 'hide';
  };

  return this.each(function () {
    var $cookiebar = $(this);

    if (!$.cookieBar.isAccepted()) {
      if (settings.threshold > 0) {
        $(window).on('scroll.cookiebar', function () {
          if ($(window).scrollTop() > settings.threshold) {
            $(window).unbind('scroll.cookiebar');
            _accept($cookiebar);
          }
        });
      }
      _show($cookiebar);
    }

    $cookiebar.find(settings.acceptButton).click(function () {
      _accept($cookiebar);
      return false;
    });
  });
};