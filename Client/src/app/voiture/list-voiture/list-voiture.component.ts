import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServicesService } from 'src/app/services/services.service';
import { Voiture } from 'src/app/voiture';
import Swal from 'sweetalert2'
@Component({
  selector: 'app-list-voiture',
  templateUrl: './list-voiture.component.html',
  styleUrls: ['./list-voiture.component.scss']
})
export class ListVoitureComponent implements OnInit {

  voitures: Voiture[];
  utilisateur;
  constructor(
    private service: ServicesService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getVoitures();
    this.utilisateur = localStorage.getItem('utilisateur');
  }
  private getVoitures() {
    this.service.getVoitureList().subscribe(data => {
      this.voitures = data;
    }, err => {
      console.error(err);
    })
  }
  commentaire(id) {
    if (localStorage.getItem('utilisateur')) {
      this.router.navigate(['voiture/' + id]);
    } else {
      Swal.fire("Vous n'êtes pas connecté","");
    }
  }
  deconnect() {
    localStorage.clear();
    this.router.navigate(['/']);
    location.reload();
  }
}
