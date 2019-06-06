import { Noticias } from 'src/app/notices/models/noticias';
import { Servicios } from 'src/app/business-services/models/servicios';

export class User {
    id : number;
    email: string="";
    nombre: string="";
    apellidos: string ="";
    password: string="";
    telefono: string="";
    roles:string[];
    servicios: Servicios[]
    noticias: Noticias[];
  }