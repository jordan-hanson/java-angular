export class User {

    //Fields 
    firstname: String
    lastname: String
    code: Number
    department: String
    manager: String

    constructor(firstname: String,
        lastname: String,
        code: Number,
        manager: String,
        department: String
    ) {
        this.firstname = firstname
        this.lastname = lastname
        this.code = code
        this.manager = manager
        this.department = department
    }
}

