export interface SubDetail {
  nombre: number;
  precio: string;
  cantidad: string;
  subtotal: string;
}

export interface Sale {
  id: number;
  id_cliente: number;
  nombres: string;
  apellidos: string;
  fecha: string;
  total: number;
}


export interface Client {
  id: number;
  nombres: string;
  apellidos: string;
  dni: string;
  telefono: string;
  email: string;
}


export interface DataSale {
  _embedded: Sale[];
}

export interface DataClient {
  _embedded: Client;
}

export interface DataSubDetail {
  _embedded: SubDetail[];
}


