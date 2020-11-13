import { HttpClient , HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class APIServicesService {

  constructor(private http: HttpClient) { 
  }

  httpOptions = {
    headers: new HttpHeaders({
    'Content-Type' : 'application/json'
    })
    };


  getUserById(id: String): Observable<any>{
    return this.http.get("/api/user/"+id)
  }

  addUserByName(name: String) {
     this.http.post("/api/user", '{"name": "' +name+'" }', this.httpOptions).subscribe((data) =>{
       console.log(data)
     })
      
  }

  
}
