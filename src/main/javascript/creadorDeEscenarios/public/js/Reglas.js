var $acciones=$( '#acciones' );
var $aserciones=$( '#aserciones' );

var reglas={};
reglas["asercionElementoEstado"]={
	menu:$aserciones,
	entradas:['se muestra',
		'no se muestra',
		'esta habilitado',
		'esta deshabilitado'],
	keyword:"Then",
	accion: "se verifica",
	elemento:function(){
		//obtener nombre del webelement seleccionado
		return '<strong class="element">'+elementoActual.attr('name')+'</strong>';
	},
	estado:function(){
		//obtener html del li clickeado
		return pasoActual.html();
	},
	regla:function(){
		return'<strong class="keyword">'+this.keyword+"</strong> "+this.accion+' "'+this.elemento()+'" '+' "'+this.estado()+'" '
	}
}

reglas["accionElemento"]={
	menu:$acciones,
	entradas:['click en'],
	keyword:"When",
	accion:function(){
		//obtener html del li clickeado
		return pasoActual.html();
	},
	elemento:function(){
		//obtener nombre del webelement seleccionado
		return '<strong class="element">'+elementoActual.attr('name')+'</strong>';
	},
	regla:function(){
		return '<strong class="keyword">'+this.keyword+"</strong> "+this.accion()+' "'+this.elemento()+'" ';
	}
}

reglas["accionParametroElemento"]={
	menu:$acciones,
	entradas:['seleccionar opcion',
		'ingresar texto'],
	keyword:"When",
	accion:function(){
		//obtener html del li clickeado
		return pasoActual.html();
	},
	elemento:function(){
		//obtener nombre del webelement seleccionado
		return '<strong class="element">'+elementoActual.attr('name')+'</strong>';
	},
	parametro:function(){
		//obtener el texto ingresado en el input
		return '<strong class="parameter">'+document.getElementsByName('textoParametro')[0].value+'</strong>';
	},
	regla:function(){
                    console.log("dsfadafd");
		return '<strong class="keyword">'
            +reglas["accionParametroElemento"].keyword
            +"</strong> "+reglas["accionParametroElemento"].accion()+' "'
            +reglas["accionParametroElemento"].parametro()
            +'" en '+' "'+reglas["accionParametroElemento"].elemento()+'" ';
	},
    ingresarDatos:function(){
        bloquearPantalla();
	    $('#block').click(function(){
		    $(this).remove();
            $('#formularioGenerarCodigo').css({'display':'none'});
	    });
        $( '#formularioGenerarCodigo' ).css({'display':'block', 'z-index':'100'});
        $( 'button[name=okCrearPaso]' ).unbind();
        var auxiliar=this.regla;
        /*
         * Accion al apretar el boton ok del formulario de nuevo paso
         */
        $( 'button[name=okCrearPaso]' ).on('click', function(){
            $('#codigoFeatures').append(
					    $('<p/>').html( auxiliar() )
				    );
            $( '#formularioGenerarCodigo' ).css('display', 'none');
            //Desbloquear pantalla
            $( '#block' ).remove();
        });
    }
}
