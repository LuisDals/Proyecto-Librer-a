import { Role } from "./Role.model";

export class Users {
    username: string | undefined;
    password: string;
    firstName: string;
    lastName: string;
    email: string;
    role: Role;


    constructor(
        username: string | undefined,
        password: string,
        firstName: string,
        lastName: string,
        email: string,
        role: Role
    ) {
        this.username = username
        this.password = password
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.role = role
    }
}