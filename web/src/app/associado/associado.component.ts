import { Component, OnInit, ViewChild } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { AssociadoDTO } from '../models/associado_dto';
import { AssociadoService } from '../services/associado.service';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatCardModule } from '@angular/material/card';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { HelpersService } from '../services/helpers.service';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';

@Component({
  selector: 'app-associado',
  standalone: true,
  imports: [
    MatIconModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatTableModule,
    MatPaginatorModule,
    NgxMaskDirective
  ],
  providers: [provideNgxMask()],
  templateUrl: './associado.component.html',
  styleUrl: './associado.component.css',
})
export class AssociadoComponent implements OnInit {
  associate: AssociadoDTO = {
    name: '',
    cpf: '',
    cep: ''
  };
  associadoForm!: FormGroup;
  associateTable: any;
  displayedColumns: string[] = [
    'id',
    'nome',
    'cpf',
    'cidade',
  ];
  dataSource = new MatTableDataSource<AssociadoDTO>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private service: AssociadoService,
    private formBuilder: FormBuilder,
    private helper: HelpersService
  ) {}

  ngOnInit(): void {
    this.validateAssociateForm();
    this.listAll();
  }

  listAll(){
    this.service.getAssociados()
    .subscribe((response) => {
      this.associateTable = response;
      let arrAssociate = [];
      for (let i = 0; i < this.associateTable.content.length; i++) {
        arrAssociate.push(this.associateTable.content[i]);
      }
      this.associateTable = arrAssociate;
      this.dataSource = new MatTableDataSource(this.associateTable);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  criarAssociado() {
    this.service.createAssociado(this.associate).subscribe((response) => {
      this.helper.openSnackBar("Associado criado com sucesso");
      console.log('Associado criado com sucesso');
      this.associadoForm.reset();
      this.helper.reloadComponent(true);
    });
  }

  validateAssociateForm() {
    this.associadoForm = this.formBuilder.group({
      name: ['', [Validators.required]],
      cpf: ['', [Validators.required, Validators.minLength(11), Validators.maxLength(11)]],
      cep: ['', [Validators.required]]
    });
  }
}
