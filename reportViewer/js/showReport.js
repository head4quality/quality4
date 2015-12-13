var report = [
  {
    "id": "escenarios-de-prueba-2",
    "description": "",
    "name": "escenarios de prueba 2",
    "keyword": "Feature",
    "line": 1,
    "elements": [
      {
        "id": "escenarios-de-prueba-2;escenario-2-1",
        "description": "",
        "name": "escenario 2-1",
        "keyword": "Scenario",
        "line": 3,
        "steps": [
          {
            "result": {
              "duration": 406089816,
              "status": "passed"
            },
            "name": "abrir driver",
            "keyword": "Given ",
            "line": 4,
            "match": {
              "location": "Pasos.abrir_driver()"
            }
          }
        ],
        "type": "scenario"
      },
      {
        "id": "escenarios-de-prueba-2;escenario-2-2",
        "description": "",
        "name": "escenario 2-2",
        "keyword": "Scenario",
        "line": 6,
        "steps": [
          {
            "result": {
              "duration": 90209,
              "status": "passed"
            },
            "name": "abrir driver",
            "keyword": "Given ",
            "line": 7,
            "match": {
              "location": "Pasos.abrir_driver()"
            }
          },
          {
            "result": {
              "status": "undefined"
            },
            "name": "paso que no existe",
            "keyword": "When ",
            "line": 8,
            "match": {}
          }
        ],
        "type": "scenario"
      },
      {
        "id": "escenarios-de-prueba-2;escenario-2-3",
        "description": "",
        "name": "escenario 2-3",
        "keyword": "Scenario",
        "line": 10,
        "steps": [
          {
            "result": {
              "duration": 117777,
              "status": "passed"
            },
            "name": "abrir driver",
            "keyword": "Given ",
            "line": 11,
            "match": {
              "location": "Pasos.abrir_driver()"
            }
          },
          {
            "result": {
              "duration": 5488318,
              "status": "failed",
              "error_message": "java.lang.AssertionError\n\tat org.junit.Assert.fail(Assert.java:86)\n\tat org.junit.Assert.assertTrue(Assert.java:41)\n\tat org.junit.Assert.assertTrue(Assert.java:52)\n\tat common.H4Q.Pasos.paso_que_falla(Pasos.java:33)\n\tat ✽.When paso que falla(escenarios 2.feature:12)\n"
            },
            "name": "paso que falla",
            "keyword": "When ",
            "line": 12,
            "match": {
              "location": "Pasos.paso_que_falla()"
            }
          },
          {
            "result": {
              "status": "skipped"
            },
            "name": "paso que no se ejecuta",
            "keyword": "When ",
            "line": 13,
            "match": {
              "location": "Pasos.no_se_ejecuta()"
            }
          }
        ],
        "type": "scenario"
      }
    ],
    "uri": "escenarios 2.feature"
  },
  {
    "id": "escenarios-de-prueba",
    "description": "",
    "name": "escenarios de prueba",
    "keyword": "Feature",
    "line": 1,
    "elements": [
      {
        "id": "escenarios-de-prueba;escenario-1",
        "description": "",
        "name": "escenario 1",
        "keyword": "Scenario",
        "line": 3,
        "steps": [
          {
            "result": {
              "duration": 77356,
              "status": "passed"
            },
            "name": "abrir driver",
            "keyword": "Given ",
            "line": 4,
            "match": {
              "location": "Pasos.abrir_driver()"
            }
          }
        ],
        "type": "scenario"
      },
      {
        "id": "escenarios-de-prueba;escenario-2",
        "description": "",
        "name": "escenario 2",
        "keyword": "Scenario",
        "line": 6,
        "steps": [
          {
            "result": {
              "duration": 117940,
              "status": "passed"
            },
            "name": "abrir driver",
            "keyword": "Given ",
            "line": 7,
            "match": {
              "location": "Pasos.abrir_driver()"
            }
          },
          {
            "result": {
              "status": "undefined"
            },
            "name": "paso que no existe",
            "keyword": "When ",
            "line": 8,
            "match": {}
          }
        ],
        "type": "scenario"
      },
      {
        "id": "escenarios-de-prueba;escenario-3",
        "description": "",
        "name": "escenario 3",
        "keyword": "Scenario",
        "line": 10,
        "steps": [
          {
            "result": {
              "duration": 102390,
              "status": "passed"
            },
            "name": "abrir driver",
            "keyword": "Given ",
            "line": 11,
            "match": {
              "location": "Pasos.abrir_driver()"
            }
          },
          {
            "result": {
              "duration": 370387,
              "status": "failed",
              "error_message": "java.lang.AssertionError\n\tat org.junit.Assert.fail(Assert.java:86)\n\tat org.junit.Assert.assertTrue(Assert.java:41)\n\tat org.junit.Assert.assertTrue(Assert.java:52)\n\tat common.H4Q.Pasos.paso_que_falla(Pasos.java:33)\n\tat ✽.When paso que falla(escenarios.feature:12)\n"
            },
            "name": "paso que falla",
            "keyword": "When ",
            "line": 12,
            "match": {
              "location": "Pasos.paso_que_falla()"
            }
          },
          {
            "result": {
              "status": "skipped"
            },
            "name": "paso que no se ejecuta",
            "keyword": "When ",
            "line": 13,
            "match": {
              "location": "Pasos.no_se_ejecuta()"
            }
          }
        ],
        "type": "scenario"
      }
    ],
    "uri": "escenarios.feature"
  }
]

var parseReport = function(){
	featuresTable = $('<table/>');
	for(var i=0; i<report.length; i++){
		var totalFeaturesTime = 0;
		var featureRow = $('<tr/>');
		var casesFailed = 0;
		var scenarios = report[i].elements;
		var columnName = $('<td/>').html(report[i].name);
		featureRow.append(columnName);
		var columnTotalScenarios = $('<td/>').html(scenarios.length);
		featureRow.append(columnTotalScenarios);		
		for (var j=0; j<scenarios.length; j++){
			var steps = scenarios[j].steps;
			for (var k=0; k<steps.length; k++){
				if (steps[k].result.duration != undefined){
					totalFeaturesTime+=(steps[k].result.duration/1000);
				}
				if (steps[k].result.status=='failed'){
					casesFailed++;	
				}
			}
		}
		var totalTimeColumn = $('<td/>').html(totalFeaturesTime);
		featureRow.append(totalTimeColumn);
		featuresTable.append(featureRow);
	}
	$('body').append(featuresTable);
}

document.ready = function() {
	parseReport();
}