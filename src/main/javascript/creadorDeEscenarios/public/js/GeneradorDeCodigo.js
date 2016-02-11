
var pasoActual;

function GeneradorDeCodigo(){
	var keys = Object.keys(reglas);

	for (var i = 0; i < keys.length; i++) {
    	var regla = reglas[keys[i]];
    	for (var j = 0; j < regla.entradas.length; j++) {
    		regla.menu.append(
				$( '<li>' ).attr('class', keys[i]).html(regla.entradas[j])
			);
    	};
		$( '.'+keys[i] ).on('click', function(){
			pasoActual=$(this);
            r=reglas[pasoActual.attr('class')];
            // oculto el menu de nuevo paso y borro el div que bloquea la aplicacion
            $('#nav').css({'display':'none'});
            $('#block').remove();
            if (r.ingresarDatos!=null)
                r.ingresarDatos();
            else{
			    $('#codigoFeatures').append(
				    $('<p/>').html( generarPasoGherkins( pasoActual.attr('class') ) )
			    );
            }
		});
	}
	
}

var generarPasoGherkins=function(clase){
	return reglas[clase].regla();
}

GeneradorDeCodigo.prototype.actualizarComboWebElements= function(){
	var combo = $( '#formularioGenerarCodigo select[name=webElementsSelect]');
	combo.find( 'option' ).remove();
	$( 'rect' ).each(function(){
		opcion=$( '<option/>' );
		opcion.html($(this).attr('name'));
		combo.append(opcion);
	});
}
