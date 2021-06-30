const router = require('express').Router();
let User = require('../models/user.model');

//get all users
router.route('/').get((req, res) => {
    User.find()
        .then(user => res.json(user))
        .catch(err => res.status(400).json('Error: ' + err));

    // console.log(res);
});

//add user
router.route('/add').post((req, res) => {
    const user_id = req.body.user_id;
    const name = req.body.name;
    const email = req.body.email;
    const mobile_no = req.body.mobile_no;

    const newUser = new User({
        user_id,
        name,
        email,
        mobile_no
    });

    newUser.save()
        .then(() => res.json('User added successfully'))
        .catch(err => res.status(400).json('Error: ' + err));
});

//get user by user_id
router.route('/:id').get((req, res) => {
    User.findById(req.params.id)
        .then(user => res.json(user))
        .catch(err => res.status(400).json('Error: ' + err));
        console.log(req.params);
});

//delete user by user_id
router.route('/:id').delete((req, res) => {
    User.findOneAndDelete({user_id: req.params.id})
        .then(() => res.json('User deleted.'))
        .catch(err => res.status(400).json('Error: ' + err));
});

//update user
router.route('/update/:id').post((req, res) => {
    User.findOne({user_id: req.params.id})
        .then(user => {
            user.name= req.body.name;
            user.email= req.body.email;
            user.mobile_no= req.body.mobile_no;

            user.save()
                .then(() => res.json('User updated!'))
                .catch(err => res.status(400).json('Error: ' + err));
        })
        .catch(err => res.status(400).json('Error: ' + err));
});

module.exports = router;