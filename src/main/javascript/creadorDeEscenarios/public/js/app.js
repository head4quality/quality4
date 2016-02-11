/*
 *imagenes que se van a cargar para seleccion de elementos
 */
//var imagenes=["imgs/img1.jpg", "imgs/img2.jpg"];
var pantallas=[];
var elementosDefinidos={};

var imagenes;

var altoImagenes="300";

/*
 *Carga las imagenes en el div#imagenes > div y el svg que va arriba
 */
var dibujarImagenes = function(){
	/*
	 * Recorre el array de imagenes y agrega un div > img por cada uno
	 */
	for	(index = 0; index < imagenes.length; index++) {
		var $divImagenes = $( '#imagenes' );
		var imagen = $('<img>').attr('src', imagenes[index].path)
			.attr('class','pantalla')
			.attr('height', altoImagenes);
		var contenedorImagen=$('<div/>');
		contenedorImagen.append(imagen);
		$divImagenes.append(contenedorImagen);
	}
	/*
	 * para cada imagen define un svg
	 */
	$('.pantalla').on('load', function(){
		var index = ($('svg').size());
		var svg=$('<svg id=pantalla'+index+'></svg>')
		svg.attr({
				'height':$(this).height(), 
				'width':$(this).width(),
			});
		svg.attr('style', 'position:relative; top:-'+altoImagenes+';');
		$(this).after(svg);
		/*
	 	 * se crea el Snap para el svg
	 	 */
		var id='#pantalla'+index;
		var s=Snap(id);
		pantallas[index]=s;
		/*
		 * se dibuja cada web element si los hay
		 */
		for (var i = 0; i < imagenes[index].elementos.length; i++) {
			var elemento=imagenes[index].elementos[i];
			elementosDefinidos[elemento.nombre]=s.rect(elemento.x, elemento.y, elemento.height, elemento.width)
				.attr({
					name: elemento.nombre,
					fill: "rgba(255,255,255,0.4)",
	    			stroke: "#000",
	    			strokeWidth: 1 
				});
            generarCodigoPageObject(elemento.nombre);
		};
	});
	$('#imagenes').css('height', altoImagenes);
}

/*
 * 1. Elimina las imgenes dibujadas
 * 2. Pide las imagenes del feature indicado y las dibuja
 */
var cargarImagenes = function(nombreFeature){
    $( '#imagenes div' ).remove();
	$.get("/feature/"+nombreFeature, function(res){
		imagenes=res.imagenes;
	}).done(function(){
		dibujarImagenes();
	}).done(function(){
		
	});
}

var rectanguloDibujado; //Ultimo webelement dibujado

/**
 * Funcion que genera el codigo del archivo PageObject.java
 */
var generarCodigoPageObject= function(nombreWebElement){
		$('#codigoPage').append(
			$('<p/>').html('@FindBy() public WebElement '+nombreWebElement.replace(/\s+/g,"_")+"_selenium;")
		);
        $('#codigoPage').append(
			$('<p/>').html('public String '+nombreWebElement.replace(/\s+/g,"_")+"_sikuli;")
		);
		$('#constructorPage > div').append(
			$('<p/>').html('mapaDeElementosSelenium.put("' +nombreWebElement+ '", '+nombreWebElement.replace(/\s+/g,"_")+"_selenium"+');')
		);
        $('#constructorPage > div').append(
			$('<p/>').html('mapaDeElementosSikuli.put("' +nombreWebElement+ '", '+nombreWebElement.replace(/\s+/g,"_")+"_sikuli"+');')
		);
}

var cargarInteraccion = function(){
	console.log('carga de interacciones');
	/*
	 *Dibujado de un cuadrado con el drag del mouse
	 */
	var posicionX;
	var posicionY;
	var snapActual; //se usa para dibujar al hacer click
	var isDragging=false; //control de drag
	var isClicked=false
	/* 
	 * Dibujado de elementos sobre las imagenes
	 * se controla el drag del mouse y se dibuja el rectangulo en consecuencia del movimiento
	 */
	$('#imagenes').on('mousedown', 'svg', function (event){
		if(capturandoElemento){
			posicionX = event.pageX - $(this).offset().left;
			posicionY = event.pageY - $(this).offset().top;
			console.log($(this).attr('id'));
			snapActual=Snap('#'+$(this).attr('id'));
			rectanguloDibujado=snapActual.rect(posicionX, posicionY, 0, 0);
			rectanguloDibujado.attr({
			    fill: "rgba(255,255,255,0.4)",
	    		stroke: "#000",
	    		strokeWidth: 1  
			});
			rectanguloDibujado.attr('class','webelement');
			isClicked=true;
		}
	}).on('mousemove', 'svg',function(event) {
    	isDragging = true;
		if (isClicked && capturandoElemento){
			var posicionActualX = (event.pageX- $(this).offset().left);
			var posicionActualY = (event.pageY- $(this).offset().top);
			//Calculo ancho y alto
			rectanguloDibujado.attr('width', Math.abs(posicionActualX-posicionX));
			rectanguloDibujado.attr('height', Math.abs(posicionActualY-posicionY));
			//Calculo la coordenada x
			if(posicionActualX<posicionX)
				rectanguloDibujado.attr('x', posicionActualX);
			else
				rectanguloDibujado.attr('x', posicionX);
			//Calculo la coordenada y
			if(posicionActualY<posicionY)
				rectanguloDibujado.attr('y', posicionActualY);
			else
				rectanguloDibujado.attr('y', posicionY);

		}
 	}).on('mouseup', 'svg',function(event) {
    	var wasDragging = isDragging;
    	isDragging = false;
		isClicked=false;
    	if (wasDragging && capturandoElemento) {
			desplegarMenuNuevoWebElement(event);
			capturandoElemento=false;
        	console.log('WebElement creado');
		}
	/*
	 * Accion al hacer click en un rectangulo
	 */
	}).on('mouseup', 'rect', function(event){
		if(!capturandoElemento){
			console.log('despliego menu acciones ' + $(this).attr('name'));
			desplegarMenuNuevoPaso(event);
			elementoActual=$(this);
		}
	});
	$('#imagenes').on('mouseleave', 'svg',function(){
		if(isClicked){
			isClicked=false;
			capturandoElemento=false;
			rectanguloDibujado.remove();
		}
	});
	$('img').click(function (){
		console.log('click en imagen');
	});

	/*
	 * Accion al apretar boton aceptar del menu de nuevo web element
	 */
	$('#aceptarNuevoWebElement').click(function (){
		console.log('accion aceptar nuevo web element');
		var $nombre=$('#nombre');
		rectanguloDibujado.attr('name', $nombre.val());
		elementosDefinidos[rectanguloDibujado.attr('name')]=rectanguloDibujado;
		rectanguloDibujado=null;
		console.log('web element '+$nombre.val());
		generarCodigoPageObject($nombre.val());
		$nombre.val('');
		$('#menuNuevoWebElement').css({'display':'none'});
		$('#block').remove();
	});

	/*
	 * Accion al pasar por la definicion de un webelement en un step
	 */
    $( '#codigoFeatures' ).on('mouseenter', 'strong.element', function(){
        elementosDefinidos[$(this).html()].attr({
            stroke:"#00F",
            strokeWidth:4
        });
    }).on('mouseleave', 'strong.element', function(){
        elementosDefinidos[$(this).html()].attr({
            stroke:"#000",
            strokeWidth:1
        });
    });;
    
}

var cargarToolBar = function(){
	capturandoElemento=false;
}

var desplegarMenuNuevoWebElement = function(ev){
	bloquearPantalla();
	/* pantalla 
	 * 		bloqueada
	 */
	$('#menuNuevoWebElement').css({
		'top':ev.pageY,
		'left':ev.pageX,
		'display':'block'});
}

var desplegarMenuNuevoPaso = function(ev){
	bloquearPantalla();
	$('#nav').css({
		'top':ev.pageY,
		'left':ev.pageX,
		'display':'block'});
	$('#block').click(function(){
		$(this).remove();
		$('#nav').css({'display':'none'});
	});
	}



var bloquearPantalla = function(){
	var divBloqueo=$('<div id="block"/>').css({
		'position':'absolute',
		'top':0,
		'left':0,
		'width':window.screen.width,
		'height':window.screen.height
	});
	$('body').append(divBloqueo);
}

/*
 * Peticion post que guarda el feature en la base de datos
 */
var nuevoFeature = function(){
    nombre=document.getElementById('nombreFeature').value;
    req = {feature:nombre};
    $.post("/feature/crear/"+nombre, req);
}
