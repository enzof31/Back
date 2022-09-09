import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../Model/persona.model';


@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  URL = 'http://localhost:8080/persona/';

  constructor(private http: HttpClient) { }

  public verPersona(): Observable<persona>{
    return this.http.get<persona>(this.URL+'traer/perfil');
  }
}
