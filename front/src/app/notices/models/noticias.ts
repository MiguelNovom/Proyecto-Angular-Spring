import { User } from 'src/app/auth/models/user';

export class Noticias {
    id: number;
    titulo: string;
    texto: string;
    imagen: string;
    user: User;
}
