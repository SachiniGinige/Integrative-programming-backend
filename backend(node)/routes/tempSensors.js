const router = require('express').Router();
let TempSensor = require('../models/tempSensor.model');

//get all
router.route('/').get((req, res) => {
    TempSensor.find()
        .then(tempReadings => res.json(tempReadings))
        .catch(err => res.status(400).json('Error: ' + err));
});

//add entry (data reading)
router.route('/add').post((req, res) => {
    const sensor_id = req.body.sensor_id;
    const date = Date.parse(req.body.date);
    const data_value = req.body.data_value;

    const newTempSensor = new TempSensor({
        sensor_id,
        date,
        data_value
    });

    newTempSensor.save()
        .then(() => res.json('Temperature reading recorded'))
        .catch(err => res.status(400).json('Error: ' + err));
});

//get by sensor_id (returns all readings of the sensor)
router.route('/:id').get((req, res) => {
    TempSensor.find({sensor_id: req.params.id})
        .then(tempReadings => res.json(tempReadings))
        .catch(err => res.status(400).json('Error: ' + err));
});

module.exports = router;