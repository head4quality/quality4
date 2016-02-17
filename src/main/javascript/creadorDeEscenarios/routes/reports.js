var express = require('express');
var router = express.Router();
var mongoose = require('mongoose'),
    Schema=mongoose.Schema;

var reportSchema=new Schema({},{ strict: false });

var establishedModels = {};
function createModelForName(name) {
    if (!(name in establishedModels)) {
        establishedModels[name] = mongoose.model(name, reportSchema);
    }
    return establishedModels[name];
}

router.post('/saveReport/:client', function(req, res, next){
	var clientModel = createModelForName(req.params.client);
	var newReport = new clientModel(req.body);
	console.log(newReport);
	newReport.save(function(err){
		if(err) throw err;
	});
	res.send("report saved ok!");
});

router.get('/lastReport/:client', function (req, res, next) {
	var clientModel = createModelForName(req.params.client);
	var lastReport = clientModel.find().sort({_id:-1}).limit(1);
	console.log(lastReport);
	lastReport.exec(function(err, report){
		res.send(report);
	});
});

module.exports = router
