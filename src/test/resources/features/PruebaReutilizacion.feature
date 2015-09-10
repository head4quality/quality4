Feature: otra prueba de reutilizacion de pasos

	Background:
	Given se instancia page object "pageObjects.GoogleSearchPage"

	Scenario: un escenario de prueba
	Given se ingresa a "http://www.google.com"
	When click "input busqueda"
	When ingresar texto "busqueda" en "input busqueda"
	When click "boton buscar"
	Then se verifica "input busqueda" "se muestra"
	
	Scenario: otro escenario de prueba
	Given se ingresa a "http://www.google.com"
	Then se verifica "boton buscar" "no se muestra"