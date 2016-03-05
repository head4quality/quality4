var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');
mongoose.connect('mongodb://root:root@jello.modulusmongo.net:27017/duqyD4oz');

var featureScema= mongoose.Schema({
	feature:String,
	imagenes:[]
});

var Feature=mongoose.model('Feature', featureScema);

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.get('/feature/:nombreFeature', function(req, res, next) {
	Feature.find({feature:req.params.nombreFeature}, function(err, fs){
			res.json(fs[0]);
		});
});

router.post('/feature/crear/:nombreFeature', function(req, res, next){
    nuevoFeature = new Feature(req.body);
    //nuevoFeature.feature=req.feature;
    nuevoFeature.save(function(err){});
    res.send("guardado ok!");
});

router.post('/feature/guardar/:nombreFeature', function(req, res, next){
    Feature.find({feature:req.params.nombreFeature}, function(err, fs){
			currentFeature = fs[0];
            
		});
});

module.exports = router;
