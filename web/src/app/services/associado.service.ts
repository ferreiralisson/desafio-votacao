import { Constants } from './../constants/constants';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AssociadoDTO } from '../models/associado_dto';

@Injectable({
  providedIn: 'root',
})
export class AssociadoService {
  constructor(private httpClient: HttpClient) {}

  getAssociados(): Observable<AssociadoDTO> {
    return this.httpClient.get<AssociadoDTO>(Constants.base_url + '/associate');
  }
}
