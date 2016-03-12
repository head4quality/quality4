var report = "";

var statusSvg= '<svg width="5.5666mm" height="5.8mm" id="svg2"> <g id="layer1"> <circle cx="11" cy="10" r="9" style="stroke: #FFF;stroke-width: 6%;"/> </g></svg>'


function markAsSelected (tr) {
	if (tr.hasClass('selected')) {return};
	tr.siblings('.selected').toggleClass('selected');
	tr.toggleClass('selected');
}

function createScenarioDiv (name, element) {
	var newTable = $('<table>')
		.attr('id', name)
		.append('<tr><th>Pasos</th><th>Status</th><th>Tiempo</th></tr>');
	var newDiv = $('<div/>').addClass('hidden').attr('name', name)
		.append($('<h3/>').html(name))
		.append(newTable);
	var errorMessage = '';
	$('#scenariosPart').append(newDiv);
	var tableMaker = new TableMaker(newTable);
	if (element.before != undefined) {
		// Se crea la fila nombre, status, tiempo
		tableMaker.newTableRow(['<strong style="color:rgb(232,230,229)">Before</strong>'
			, statusSvg
			, element.before[0].result.duration])
			.addClass(element.before[0].result.status);
	};
	for (var i = 0; i < element.steps.length; i++) {
		var result=element.steps[i].result.status;
		if(element.steps[i].result.error_message!=undefined) 
			errorMessage=element.steps[i].result.error_message
				.replace(/\n/g, '<br/>')
				.replace(/\t/g, '&nbsp;&nbsp;&nbsp;&nbsp;');
		tableMaker.newTableRow(['<strong style="color:rgb(232,230,229)">'+element.steps[i].keyword+'</strong>'+element.steps[i].name,
				statusSvg,
				element.steps[i].result.duration])
			.addClass(result);
		if (element.steps[i].embeddings != undefined) {
			scenarioDataImage=element.steps[i].embeddings[0].data;
		};
	};
	if (element.after != undefined) {
		// Se crea la fila nombre, status, tiempo
		tableMaker.newTableRow(['<strong style="color:rgb(232,230,229)">After</strong>'
			, statusSvg
			, element.after[0].result.duration])
			.addClass(element.after[0].result.status);
	};
	newDiv.append($('<p/>').addClass('blue').html('head@quality:#<br/>Error<br/>'+errorMessage));
	if (scenarioDataImage!='') {
		newDiv.append($('<img/>').attr('src','data:image/jpeg;base64,'+scenarioDataImage).attr({'width':'90%'}));
	};
	tableMaker.draw();
}

var parseReportUsingTableMaker = function() {
	var featuresTableMaker = new TableMaker('featuresTable');
	var scenariosTableMaker = new TableMaker('scenariosTable');
	var steps
	for(var i=0; i<report.length; i++){
		var totalFeaturesTime = 0;
		var casesFailed = 0;
		var scenarios = report[i].elements;
		var columnName = report[i].name;
		var totalScenarios=0;
		for (var j=0; j<scenarios.length; j++){
			var totalScenarioTime=0;
			var steps = scenarios[j].steps;
			var scenarioStatus = 'passed';
			for (var k=0; k<steps.length; k++){
				scenarioDataImage="";
				if (steps[k].result.duration != undefined){
					totalScenarioTime+=(steps[k].result.duration/1000);
					totalFeaturesTime+=totalScenarioTime;
				}
				if (steps[k].result.status=='failed'){
					casesFailed++;
					scenarioStatus = 'failed';
				}
			}
			var name = report[i].name+"-"+scenarios[j].name;
			var pdf = new newpdf(name ,scenarios[j] ,scenarioStatus, totalScenarioTime);
			createScenarioDiv(scenarios[j].id, scenarios[j]);
			scenariosTableMaker.newTableRow([
					scenarios[j].name,
					steps.length,
					scenarioStatus,
					totalScenarioTime,
					pdf
					])
				.addClass('hidden')
				.attr('name', scenarios[j].id);
			totalScenarios++;
		}
		featuresTableMaker.newTableRow([report[i].name, totalScenarios, totalFeaturesTime])
			.attr('name', report[i].id);
	}
	featuresTableMaker.draw();
	scenariosTableMaker.draw();
};

function setStyles () {
	$featuresTable=$('#featuresTable');
	$featuresTable.find('td:nth-child(2)').addClass('centred');
}

function setInteraction () {
	// Interaccion de la tabla de features
	$('#featuresTable tr').on('click', function() {
		var nombre = $(this).attr('name');
		markAsSelected($(this));
		$('#scenariosTable tr.visible').toggleClass('visible').toggleClass('hidden');
		$('#scenariosTable tr[name*="'+nombre+';"]').toggleClass('visible').toggleClass('hidden');
	});
	//Interaccion de la tabla de escenarios
	$('#scenariosTable tr').on('click', function() {
		var nombre = $(this).attr('name');
		markAsSelected($(this));
		$('#scenariosPart').toggleClass('hidden');
		$('#scenariosPart div.visible').toggleClass('visible').toggleClass('hidden');
		$('#scenariosPart div[name="'+nombre+'"]').toggleClass('visible').toggleClass('hidden');
	});

	$('#scenariosPart').on('click', function() {
		$('#scenariosPart').toggleClass('hidden');
	});
}

var underline = function(){
	$('div.underline')
		.each(function(i, obj){
			//var svg = $('<svg><svg/>').attr('id','underline'+i);
			//$(obj).append(svg);
			var snap = Snap('#underline'+i);
			var title=$(obj).find('h3');
			var underline = snap.line (0,10,0,10);
			underline.attr({
				stroke: "rgb(130, 130, 130)",
				strokeWidth: 2
			});
			underline.animate({x2:title.innerWidth()}, 1500)
			var circle = snap.circle(title.innerWidth(),10, 0);
			circle.attr({
				fill: "rgb(130, 130, 130)"
			});
			circle.animate({r:5}, 1000);
		});
}

document.ready = function() {
	$('div.underline')
		.each(function(i, obj){
			var svg = $('<svg><svg/>').attr('id','underline'+i);
			$(obj).append(svg);
		});
	$.get('report/lastReport/clienteDePrueba', function( data ) {
		report=data[0].report;
	}).done(function(){
		parseReportUsingTableMaker();
		setStyles();
		underline();
		setInteraction();
	});
}
