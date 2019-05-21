import { Noticias } from 'src/app/notices/models/noticias';

export class User {
    id : number;
    email: string="";
    nombre: string="";
    apellidos: string ="";
    password: string="";
    telefono: string="";
    roles:string[];
    noticias: Noticias[];
  }