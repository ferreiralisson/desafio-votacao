import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AssociadoDTO } from './models/associado_dto';
import { AssociadoService } from './services/associado.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'desafio_votacao';
  associados: AssociadoDTO[] | undefined;

  constructor(private service: AssociadoService) {}

  ngOnInit(): void {
      this.service.getAssociados()
      .subscribe((response: any) => {
        this.associados = response.content;
        console.log(this.associados)
        this.associados?.forEach((associado) => {
            this.title = associado.name
        })
      })
  }


}
