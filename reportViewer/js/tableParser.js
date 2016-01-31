/**
  * Clase que una vez instanciada permite completar una tabla con un conjunto de campos a setear
  */

/**
 * Constructor
 * @param tableId id de la tabla que se utilizara para insertar las filas
 * 	debe estar creada a nivel html
 */
function TableMaker (tableId) {
	this.$table = $('#'+tableId);
	//TODO verificar si existe la tabla
	this.rows = [];
}

/**
 * Guarda una nueva fila de tabla html en esta instancia de TableMaker. Estas
 * filas deben ser insertadas en la tabla posteriormente usando draw() para
 * verlas dibujadas
 * @param elementsArray array de elementos a insertar en la fila
 */
TableMaker.prototype.newTableRow =
function(elementsArray) {
	var newRow = $('<tr/>');
	for (var i = 0; i < elementsArray.length; i++) {
		var cell = $('<td/>');
		if (typeof elementsArray[i] == 'string') {cell.html(elementsArray[i])}
		else {cell.append(elementsArray[i])};
		newRow.append(cell);
	};
	this.rows.push(newRow);
};

/**
 * Dibuja las filas del array de filas actual en la tabla.
 */
TableMaker.prototype.draw =
function() {
	for (var i = 0; i < this.rows.length; i++) {
		this.$table.append(this.rows[i]);
	};
};

createCell = function(content, style) {};
