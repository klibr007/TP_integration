import { User } from './user';

export class Card {

    constructor(private  id: number,
        public label: string,
        public date : string,
        public user: User,
        public durating: number,
        public location: string,
        public url : string,
        public description: string){}
}
