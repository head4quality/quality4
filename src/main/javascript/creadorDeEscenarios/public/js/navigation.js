$( '.navLi' ).hover(
	function  () {
		$( this ).children( 'ul' ).slideDown('fast');
	},
	function  () {
		$( this ).children( 'ul' ).slideUp('fast');
	});
