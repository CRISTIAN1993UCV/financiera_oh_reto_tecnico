import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DataSale, DataClient, DataSubDetail} from 'src/app/interfaces/sale/sale.interface';

@Injectable({
  providedIn: 'root'
})
export class SaleService {

  private apiUrl: string =  'http://localhost:9090/api';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private httpClient: HttpClient) { }

  public getDetailVentas(filterDate:string = ''): Observable<DataSale>
  {
    const url = `${this.apiUrl}/ventas/detail/?filterDate=${filterDate}`;
    return this.httpClient.get<DataSale>(url);
  }

  public getDataClient(idCliente:string = ''): Observable<DataClient>
  {
    const url = `${this.apiUrl}/clientes/${idCliente}`;
    return this.httpClient.get<DataClient>(url);
  }

  public getSubDetailVentas(idVenta:string = ''): Observable<DataSubDetail>
  {
    const url = `${this.apiUrl}/DetalleVentas/full-detalle-venta/${idVenta}`;
    return this.httpClient.get<DataSubDetail>(url);
  }
}
