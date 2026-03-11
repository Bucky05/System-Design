const User = require('../models/user')

const userList = [
    new User("User1"),
    new User("User2")
]

module.exports = {
    addUser : (user) => userList.push(user),
    getUserById : (id) => {
        return userList.filter((user) => user.getId().equals(id))[0];
    }
}