import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServicesService } from '../services/services.service';
import Swal from 'sweetalert2'
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  nom: string;
  mdp: string;
  createCompte: boolean = false;
  constructor(
    private service: ServicesService,
    private router: Router) {
  }

  ngOnInit() {
  }
  login() {
    this.createCompte = false;
    let utilisateur = {
      nomUtilisateur: this.nom,
      mdpUtilisateur: this.mdp
    }
    this.service.login(utilisateur).subscribe(data => {
      console.log(data);
      if (data) {
        Swal.fire("Connexion réussie", "");
        localStorage.setItem('utilisateur', data.mdpUtilisateur);
        localStorage.setItem('idUtilisateur', data.idUtilisateur);
        this.router.navigate(['/'])
      }else {
        Swal.fire("Le nom ou le mot de passe entré est invalide.", "");
        this.nom = null;
        this.mdp = null;
      }
    }, err => {
      console.error(err);
    })
  }
  addCompte() {
    this.createCompte = true;
    let utilisateur = {
      nomUtilisateur: this.nom,
      mdpUtilisateur: this.mdp
    }
    console.log(utilisateur);
    this.service.saveUser(utilisateur).subscribe(data => {
      console.log(data);
      if (data) {
        Swal.fire("Inscription réussie", "");
        this.nom = null;
        this.mdp = null;
      }
    }, err => {
      console.error(err);
    })
  }
}
