import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Voiture } from '../voiture';
import { Utilisateur } from '../Utilisateur';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  private baseURL = "http://localhost:8080/api"
  constructor(private httpClient: HttpClient) { }

  getVoitureList(): Observable<Voiture[]> {
    return this.httpClient.get<Voiture[]>(this.baseURL + "/voitures");
  }

  getVoiture(id): Observable<Voiture[]> {
    return this.httpClient.get<Voiture[]>(this.baseURL + "/voiture/"+id);
  }

  login(utilisateur) {
    return this.httpClient.post<Utilisateur>(this.baseURL + "/login",utilisateur);
  }

  save(commentaire) {
    return this.httpClient.post<Utilisateur>(this.baseURL + "/commenter",commentaire);
  }

  saveUser(utilisateur) {
    return this.httpClient.post<Utilisateur>(this.baseURL + "/saveUser",utilisateur);
  }

  getCommentaireVoiture(id){
    return this.httpClient.get<Voiture[]>(this.baseURL + "/commentaire/"+id);
  }
}
