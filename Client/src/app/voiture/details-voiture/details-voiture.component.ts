import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ServicesService } from 'src/app/services/services.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-details-voiture',
  templateUrl: './details-voiture.component.html',
  styleUrls: ['./details-voiture.component.scss']
})
export class DetailsVoitureComponent implements OnInit {

  voiture: any;
  commentaires: any[] = [];
  commentaire: string;
  id: string;
  constructor(
    private route: ActivatedRoute,
    private service: ServicesService,
    private router: Router
  ) { }

  ngOnInit(): void {
    if (localStorage.getItem('utilisateur')) {
      this.route.params.subscribe((params) => {
        this.service.getVoiture(params.id).subscribe((data) => {
          this.voiture = data;
          this.id = params.id;
          this.getCommentaire(params.id);
        })
      }, err => {
        console.error(err);
      });
    } else {
      Swal.fire("Vous n'êtes pas connecté", "");
      this.router.navigate(['/']);
    }
  }
  getCommentaire(id) {
    this.service.getCommentaireVoiture(id).subscribe(data => {
      console.log(data);
      this.commentaires = data;
    }, err => {
      console.error(err);
    })
  }
  commmenter() {
    if (this.commentaire) {
      let commentaire = {
        idUtilisateur: localStorage.getItem("idUtilisateur"),
        idVoiture: this.id,
        commentaire: this.commentaire,
        dateCommentaire: new Date()
      }
      this.service.save(commentaire).subscribe(data => {
        this.commentaire = null;
        this.commentaires.push(data);
      }, err => {
        console.error(err);
      })
    }
    else {
      Swal.fire("Veuillez saisir le commentaire", "");
    }
  }
}
