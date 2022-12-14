import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Register } from "../models";
import { lastValueFrom } from "rxjs";

const URL = 'https://whispering-refuge-41613.herokuapp.com/api/registration'

@Injectable()
export class RegisterService {

    constructor(private http: HttpClient) { }

    onNewRegister(register: Register): Promise<Response> {

        const headers = new HttpHeaders()
        .set('Content-Type', 'application/json')
        .set('Accept', 'application/json')       


        return lastValueFrom (
            this.http.post<Response>(URL, register, { headers })
                //.pipe()
        )
    }
}
