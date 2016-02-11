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
console.log("llega hasta aca");
	var clientModel = createModelForName(req.params.client);
	var newReport = new clientModel(req.body);
	console.log("llega hasta aca");
	newReport.save(function(err){});
	res.send("report saved ok!");
});

module.exports = router
