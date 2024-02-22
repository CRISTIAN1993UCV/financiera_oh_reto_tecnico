import { Component, OnInit } from '@angular/core';
import { SaleService } from 'src/app/services/sale/sale.services';
import { Sale, Client, SubDetail } from 'src/app/interfaces/sale/sale.interface';


@Component({
  selector: 'page-sale',
  templateUrl: './sale.page.html',
  styleUrls: ['./sale.page.css']
})
export class SalePage implements OnInit {

  dateSearch: string = '';
  dateSubDetail: string = '';
  totalSubDetail: string = '';
  fechaSubDetailDisabled: boolean = true;
  showSubDetail:boolean = false;
  subDetailTitle:string = 'Detail Sale';
  dataVenta: Sale[] = [];
  cliente!: Client;
  subDetail!: SubDetail[];


  closeCard() {
    this.showSubDetail = false;
  }

  search() {
    this.saleService.getDetailVentas(this.dateSearch).subscribe(
      (data) => {
        this.dataVenta = data._embedded;
      }
    )
  }

  viewDetail(id_venta:number, id_cliente:number, fecha:string, total:number) {
    this.saleService.getDataClient(id_cliente.toString()).subscribe(
      (data) => {
        this.cliente = data._embedded;
        this.saleService.getSubDetailVentas(id_venta.toString()).subscribe(
          (data) => {
            this.subDetail = data._embedded;
          }
        )
      }
    )
    this.totalSubDetail = total.toString();
    this.showSubDetail = true;
    this.dateSubDetail = fecha;

  }


  constructor(private saleService: SaleService) {}




  ngOnInit(): void {

    this.saleService.getDetailVentas(this.dateSearch).subscribe(
      (data) => {
        this.dataVenta = data._embedded;
      }
    )
  }

}
