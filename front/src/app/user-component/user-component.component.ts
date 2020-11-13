import { Component, OnInit } from '@angular/core';
import { APIServicesService } from '../apiservices.service';
import { Card } from '../card';
import { User } from '../user';

@Component({
  selector: 'app-user-component',
  templateUrl: './user-component.component.html',
  styleUrls: ['./user-component.component.css']
})
export class UserComponentComponent implements OnInit {

  id_user : number;
  user = false;
  name_user: string;
  currentUser : User;

  constructor(private service: APIServicesService) { 
    //this.currentUser = new User(1, "dave", new Card(1, "taff", "", null, 0, "", "",""));
  }

  ngOnInit(): void {
  }

  search(){
    if(this.id_user !== null){
      this.service.getUserById(""+this.id_user).subscribe((data) => {
        if(data !== null){
          let u = new User(data.id, data.name, data.card);
          this.currentUser = u
          this.user=true
        }
        else{
          this.user=false
        }
        
      })
    }
    
  }

  add(){
      if(this.name_user !== undefined){
        this.service.addUserByName(this.name_user)
      }
  }

}
