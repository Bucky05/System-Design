const {randomUUID} = require('crypto');

class User{
    #name;
    #id;
    constructor(name) {
        this.#name = name;
        this.#id = randomUUID();
    }

    getName(){
        return this.#name;
    }

    getId(){
        return this.#id;
    }

}

module.exports = User;