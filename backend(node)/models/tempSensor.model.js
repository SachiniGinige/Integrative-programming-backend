const mongoose = require('mongoose');

const Schema = mongoose.Schema;

const tempSensorSchema = new Schema({
    sensor_id: {type: String, required: true},
    date: {type: Date, required: true},
    data_value: {type: String, required: true}
}, {
    timestamps: true,
});

const TempSensor = mongoose.model('TempSensor', tempSensorSchema);

module.exports = TempSensor;