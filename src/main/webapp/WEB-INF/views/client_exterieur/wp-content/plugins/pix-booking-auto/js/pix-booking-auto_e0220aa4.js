jQuery(document).ready(function ($) {
	"use strict";

	 Date.prototype.yyyymmdd = function() {
	  var mm = this.getMonth() + 1; // getMonth() is zero-based
	  var dd = this.getDate();

	  return [this.getFullYear(),
	          (mm>9 ? '' : '0') + mm,
	          (dd>9 ? '' : '') + dd
	         ].join('/');
	};
	function datediff(first, second) {
	    return Math.round((second-first)/(1000*60*60*24));
	}
		// Ð²ÑÐµ Ð´Ð°Ñ‚Ñ‹ Ð±Ñ€Ð¾Ð½Ð¸Ñ€Ð¾Ð²Ð°Ð½Ð¸Ñ
  	var allPixbaBookedDay = [];
 	pixbaBookedDay.forEach(function(element) {
 		let startTime = new Date(Date.parse(element['start-time']));
 		let finishTime = new Date(Date.parse(element['finish-time']));
 		let numberDay = datediff(startTime,finishTime);
 		let periodDay;
 		for (var i = 0; i < numberDay; i++) {
 			periodDay =  new Date(startTime);
 			periodDay =new Date(  periodDay.setDate(periodDay.getDate() + i) );
 			allPixbaBookedDay.push(periodDay.yyyymmdd());
 		}
 		 allPixbaBookedDay.push(finishTime.yyyymmdd());
	});
	var loceleBooking =  $('html').attr('lang');
	if(loceleBooking){
		loceleBooking = loceleBooking.slice(0, 2);
	}else{
		loceleBooking = '';
	}

var work_days = jQuery('#datetimepicker_simple').data('work_days');
if (work_days) {
var work_days_array  = work_days.split(',').map(function(item) {
    return parseInt(item, 10);
});

}
var work_time = jQuery('#datetimepicker_simple').data('work_time');
if (work_time) {
var work_time_array  = work_time.split(',');	
}
	
var date = new Date();
var plusDays =  jQuery('#datetimepicker_simple').data('min_date');	
date.setDate(date.getDate() + plusDays);	
var options = {year: 'numeric', month: '2-digit', day: '2-digit' };
var minDate = date.toLocaleDateString('zh-Hans-CN', options);
	
	
 var datetimepickersBooking =	jQuery('#datetimepicker_simple, #datetimepicker_end').datetimepicker({
			disabledWeekDays: work_days_array,
			allowTimes: work_time_array,
			format:'H:i Y/m/j',
			defaultTime:'09:00',
			disabledDates: allPixbaBookedDay,
			formatDate: 'Y/m/j',
			lang: loceleBooking,
			minDate: minDate,
		    startDate: minDate
 }); 


var date = new Date();
var plusDays =  jQuery('#pixad-time-start').data('min_date');	
date.setDate(date.getDate() + plusDays);	
var options = {year: 'numeric', month: '2-digit', day: '2-digit' };
var minDate = date.toLocaleDateString('zh-Hans-CN', options);


var work_days = jQuery('#pixad-time-start').data('work_days');
if (work_days) {
var work_days_array  = work_days.split(',').map(function(item) {
    return parseInt(item, 10);
});
}

$.datetimepicker.setLocale(loceleBooking);
var pixbaInputTime =	jQuery('.pix-input-time').each(function(index, el) {
	jQuery(this).datetimepicker({
			disabledWeekDays: work_days_array,
			timepicker:false,
			format:'Y/m/j',
			formatDate: 'Y/m/j',
			minDate: minDate,
		    startDate: minDate
 }); 
}); 



	// Ð²ÐºÐ» ÐºÐ°Ð»ÐµÐ½Ð´Ð°Ñ€ÑŒ
	var datetimepickerCalendar = jQuery('#datetimepicker_calendar').periodpicker({
		norange: true, // use only one value
		cells: [1, 1], // show only one month
 		lang: loceleBooking,
		resizeButton: false, // deny resize picker
		fullsizeButton: false,
		fullsizeOnDblClick: false,
		disableDays: allPixbaBookedDay,
		formatDate: '../../../../autos/dacia-sandero/index.html',
		inline:true,
		onChange: function () {
		}
		
	});
    
    
    // hide notices
    
    function noticeHide(){
     $(".booking-notice").addClass('notice-hide');
    }
    setTimeout(noticeHide, 12000);


});

