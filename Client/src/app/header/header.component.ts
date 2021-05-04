import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ServicesService } from '../services/services.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  utilisateur;
  constructor(
    private route: ActivatedRoute,
    private service: ServicesService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.utilisateur = localStorage.getItem('utilisateur');
  }
  deconnect() {
    localStorage.clear();
    this.router.navigate(['/']);
    location.reload();
  }
  
}
