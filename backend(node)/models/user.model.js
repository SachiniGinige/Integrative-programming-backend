const mongoose = require('mongoose');

const Schema = mongoose.Schema;

const userSchema = new Schema({
    user_id: {type: String, required: true, unique: true},
    name: {type: String, required: true},
    email: {type: String, required: true},
    mobile_no: {type: String, required: true}
}, {
    timestamps: true,
});

const User = mongoose.model('User', userSchema);

module.exports = User;