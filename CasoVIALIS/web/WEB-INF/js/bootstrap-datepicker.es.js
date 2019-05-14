/**
 * Spanish translation for bootstrap-datepicker
 * Bruno Bonamin <bruno.bonamin@gmail.com>
 */
;(function($){
	$.fn.datepicker.dates['es'] = {
		days: ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"],
		daysShort: ["Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"],
		daysMin: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa", "Do"],
		months: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
		monthsShort: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"],
		today: "Hoy"
	};
    
    $.fn.datepicker.parseDate = function(date){
    	var y  = date.getFullYear();
    	var m  = (date.getMonth() > 8)?(date.getMonth()+1):('0'+(date.getMonth()+1));
    	var d  = (date.getDate()   > 9)?(date.getDate()    ):('0'+date.getDate());
    	return {d: d.toString(), m:m.toString(),y:y.toString()};
    }
    
}(jQuery));
