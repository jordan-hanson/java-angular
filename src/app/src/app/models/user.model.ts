export class User {

    //Fields 
    firstname: String
    lastname: String
    code: Number
    // department: String
    // manager: String

    constructor(firstname: String,
        lastname: String,
        code: Number,
    ) {
        this.firstname = firstname
        this.lastname = lastname
        this.code = code
        // this.department = department
        // this.manager = manager
    }
}

