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
		return elementoActual.attr('name');
	},
	estado:function(){
		//obtener html del li clickeado
		return pasoActual.html();
	},
	regla:function(){
		return this.keyword+" "+this.accion+' "'+this.elemento()+'" '+' "'+this.estado()+'" '
	}
}

reglas["accionElemento"]={
	menu:$acciones,
	entradas:['click'],
	keyword:"When",
	accion:function(){
		//obtener html del li clickeado
		return pasoActual.html();
	},
	elemento:function(){
		//obtener nombre del webelement seleccionado
		return elementoActual.attr('name');
	},
	regla:function(){
		return this.keyword+" "+this.accion()+' "'+this.elemento()+'" ';
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
		return elementoActual.attr('name');
	},
	parametro:function(){
		//obtener el texto ingresado en el input
	},
	regla:function(){
		return this.keyword+" "+this.accion()+' "'+this.parametro()+'" en '+' "'+this.elemento()+'" ';
	}
}
