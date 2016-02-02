function newpdf(name,scenario,scenarioStatus, totalFeaturesTime){
	var button = document.createElement("input");
    button.type = "button";
    button.value= "pdf";
    button.addEventListener("click", function(){
        pdf(name , scenario,scenarioStatus, totalFeaturesTime);
    },false);
     return button;
}


function pdf(name, scenario,scenarioStatus, totalFeaturesTime) {
	
	var imgData ='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFUAAAArCAYAAAAJ3cTrAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAN1wAADdcBQiibeAAAABl0RVh0U29mdHdhcmUAd3d3Lmlua3NjYXBlLm9yZ5vuPBoAAAsJSURBVGiB7Zt7cFTVHcc/59zNOwiEZxLIYjbLSyABgo9O5aFEKMUWUPqA1gcvAalTOgLq1Bk7tp0iPtqp8hRB7RSqVsA6NcjgawblkV0SCpphd0NWkDwhIQmPbPbe0z/uurBkQ5LNigH9Znbm3j3n/M7vfu/v/H6/8zsboZQCwGqzjwFWADcD/bk+UAO8CPzN63GdulqTCqUUVpt9KbAK0K7WxFcZZ4H1wHNej+urb3oykZGZNRrYx/VL6KXwAa8Bf/J6XKXf1CQSc8l/FwgFiAXmAZ9bbfbHrTZ7zDcxicT0od81JAB/BgqtNvvt0RYuMjKzVLSFXmNQwCZgebSCmYyGkGscApgDFFtt9geiIrCjlqoAKYR5rQxMHSOQoxQIcYmsNqglRGSzCVBGi/I/BhZ6Pa7iSERDB0kVQjB/7lykZhr8wcIi9u3bF7GsX82eRVJSEgAOh4MDBY6QPkoppJTk5GTzg1tvxa/rCNF+WpWhsEjJxldfpcnnQzeMy7v4gGcws4QL7X6WDlmqgAOf7UULkLr+5Y2sXbcuQlmC/+zYTnpqakDWBtau2xBs1jQLyclJPL58GRMmTCAmxkJHVoXSDQwB69evZ/PmV/ErBc1XxxfALK/HVdge+deETzUMhc2Wyfbt27grLw8pJQh5kQPVjg+mu5IxFiwWC4sXLWLNSy+GIxRgCLDParP/zmqzt/kNWiJ7zKsLIeAPTz1FSkICuhAIIaiqqmLbjh3g19tlsApBbHw8D95/X5DI0bm5PPnk73n66T+GGxILPAdMttrs93s9rrLW5rgmSF340AIyB1jRNQ1NwtY332TlylUIEdlCE0KwYcPLvPD8s9wyZgwA90ybzs78/7L/gLOlYXnAIavNPtfrcb1zJfnXxPKfMG4cMTExSMDhLGTVsy9ETCiYPvXChfM8vGQJ1dVmamoYOiNzRrc2tCeww2qzr7Ha7Aktder0pEpNYrfbzRuhcL70CJuzy4jROr6zNgzFln9tDd5PmTK5rUMXAg6rzZ4TrjGqpAoh2hUzQj5KhVVm6E1Dg7krhsYPRSlju55lbnpNROnU5fq+9fbbwfvUPuntGR4MYpc3RNWnPvTgA8yfNyeisUo3EJrWLAp3SUo2g7YSKP0Ct3VvQFewLLOSNd4uHSJWKUV9XX3wPjau3fWVWOA5q82eDcz3elw+iLKlGlJGaKYgpAyb1kgpzO81SdL2J8AwS2oWAT9NbYym+giaz99G3Ae8b7XZUyDKpOoIM7GO4GNuOJtbnRAaSIn0nSFu/6aQLrtOtxgrglBKYcvMRDXfNQWs/CKRfr8/ksf+GuOAPVabvUtUl39hoZOCA47WO4aDEPx69iwSE0KJqiivQAlB0qZZponqF9vO+1q3rOzsbF5bu4ZnVr/IP/+xpVl738AOztShw3QMBv4aVVIdBU7WrV8f2WAhmPrjKc1IPeo+SqznE2Ldn6KU4HBDMsOTA35Q0WLib9YIctiwZjWGlCxa8BCNZ8/z7+3bg8aplGLaT+4OjnE6D0SmeyjmdPqUygBi3ngUpRSfno4lvyoOhaC8KRYlWrZUpRTHjx/n7PlzACQlJLLisceYNm160OkZymDunIuBtbCoxcS/XejkpCqW22uJr3ZR59eY/b90LOgopXi3sivyChsApRRVVVXMmPmz4HcWKXl06W+5d8a9SCHYumULmjTzXUMZvPHW9qho3am3qWN7+nmk3ykUMLPQijIEArPmOvuBuXSLuQWX20VrQfvtbduYMX06AIkJCTyxYjlPrFge0mfjK5upqqqKit6dltTc5LMsH+bFryRLilMprg8UpANJghJwx7ixTBg/zryRV3AFLRWkpcTw6xQ4HaxeuzbCQmJzdEpSBRrjKnajCfjodCLvlSdgJj+KW7v5QChQAlnlIrZoG0ITNNrvQO83CsK4hJY2CI3nfVRUlrFw0eKoEQpROE5ZMH9eUGmH8yAFBQURaiL45S9+zg3JXVgq3iXBvYdzumLs/iyqL0CspvNwRg1LrDVoKpBfapg7LSUwuvXjL70WIVoLE0IwZdJk0tPTUEIhdZj38GIKnQcjT/0vn6Kjlf+oaYJZ67wnvYEXBlWC0ilvsnDGH4s9/jy6MHdWMYGI36QgJmBehfWJbDjRnXfKEpBtMLmbx+Syds1q8wGUQtd1Fi5aTMFBJxGeeoWgUx1R90002HtLKYLmux+At6pTmN6jBkMoPqlOZk9tPFvLu3HO31LhvgUIGD5sOK+/sjE408FCJ/MWLGrbgWNr4jsTqdYkg/dGlxInDHacSsHbABLBvrpEPquJQwHe8W4AbB9n4Q/PfdsgBKNycti86RX2fraXuQsWoEWhnAidjNRWIQTe8S5AYP3I1mHXo2ka2TnZOByOqCz7rxEmVLYcLb9tDO1iFjyON8aF5bO9euu6jtN5MKqEwmUpVfeePRg1Zgyg8Pv9fLxrNwADbDY8rqPB3cdN2SM4XFQUVCY2Po6BQ4dw2HnxJDcnN5fCMJnAsJxsDhcW0SctjZ69e9G1WzfO1J6hqqKCyrIyEpIS6W+1cvQL87cMA4cM5uSJr2ior2NSyhl0BVVNsViEhq7M6kqftL6MHJ2Lz+dDSMnu9/IBGD4yBwMz/UpOSqa0xE1lRQVSSGyDBpKalo6maZR6SjhW4kYZihGjR3HIEdiuChgxciRFTicjc8cQn5hAfV09SYmJHD/upfzEybA+OITUaTNnsnnNOlTgb+LkH7E7P5/kLl1MfxMYn5qWxpGiQ8GJJ02dSl1dLQoVJDqlR4+wb7F3n75AERUnT1JZXoZ9yGCOfl4cjDTnzp7D19jIAFsmFmEeIzfU1QFwoD4RnRpe/yoJ3bhYrpo6fQYvv7Ta3BcETluVUvTu04fdO3eCAgPFhLw8KsvK0dHp178/u/N3IoTgzsmTqawop6G+nu49UkL07dmrN0IIevTqSYnLzTG3G4TgN8uW8vdVz4d9xhBSE5OSUCELy7wWwa1MoO0SxVFQd6aWU9XVDBw8BFdxcaBL+CUlmuU8oXmZAEo9JYzPywMFH+56Pyhrz6l47B/Zmsn0+XwITB85Lm8ix1wujnlKAMWEu/KQQkNaJCe8XozAixdShOjYNaU7DfX1SHlpsBIhlyPH5JJpswGCfXv2tejTQ0jVpAxamxQyhAApBYZu/t4Jw7RkBEzIm4jULPTu3ZcmvYmjxcVR8VB1DXVgqJAHbyku6bpptYZh8EH++9wxOS9AKnywcxeZWTaEEJS43WH9p0IFXVuwNTCvZtGC3xYWOChxuwOKtBwlQwLVl95S4uMT6JOayqS7p9LkawKg+MgRbrt9bGBSRWx8nPm2hSAxKZnd+fl8sHMnQkF6Rr8WJ2sXDMJW68PhQuP54MqxDcpCXkbcMY+HzKws+qamBVnLuPHG4Avr2q0bJ7xes0Ep4uLjQSl69OpFY+MFLq5QAm7qymlHSEolpGTQkCGkW/tT4jIdd6nHA4DFYmHsxDuprayhwLkXTWqkpPTgTG1t8BhCobAPHoS7+CgZmVbsgweDofDrekjQ+1omQEqvnpyuqm6mWN9+aRi6QWVZeaukCiEYOmIEfVP7cOhgEV1uuIESt5v+1gxOlH4ZjBFDhw3j88NHAPOnP+PzJiKk4JPdH+Jvago+w8DBQ+hvzcB91MXx0lIA+t84gLraWmpP17SuT0ZmVilgbbXn92grvBLY/21rcZ1hvwRWEnKc9j06AB1YKb0elwNYxvfEdhQ6sMzrcTnEdf4ff1cDxzFd6Eqvx3UA4P/JlmywzJSkWAAAAABJRU5ErkJggg==';
	var doc = new jsPDF();
	//doc.setFontSize(40);
	doc.addImage(imgData, 'JPEG', 10, 10, 40, 20);
	doc.setFontSize(20);
	doc.text(10, 60, 'Project: '+ 'HQ4');
	doc.setFontSize(10);
	doc.text(10, 80, 'Name: '+ scenario.name);
	doc.text(10, 90, 'Description: '+ scenario.description);
	doc.text(10, 100, 'Status: '+ scenarioStatus);
	doc.text(10, 110, 'Tiempo: '+ totalFeaturesTime);
	doc.save(name+'.pdf');
	
}