import { User } from './../user';
import { LifeRegistration } from './../life-registration';
import { LifeComponent } from './../life/life.component';
import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { Router,Route } from '@angular/router';
@Component({
  selector: 'app-fetchdatalife',
  templateUrl: './fetchdatalife.component.html',
  styleUrls: ['./fetchdatalife.component.css']
})
export class FetchdatalifeComponent implements OnInit {
  user:LifeRegistration=new LifeRegistration();
  config:any;
  value:string="Approve";
  userData:any=[];
al:boolean;
  constructor(private userRegistration:RegistrationService,private _router:Router){
    this.userRegistration.getLifeData().subscribe(data=>{
      console.log(data);
      this.userData=data;
     
    });

  }

  public approvealForm(user){

    this.userRegistration.updateStatusOfLife(user).subscribe(
  
      data=>{
            
           alert("Approved  Successfully");
           let curl=this._router.url;
           this._router.navigateByUrl('/',{skipLocationChange: true}).then(()=>{
           this._router.navigate([curl]);
           });
      },
       error=>{
         alert("Unsuccessfull");
  
       }
    )
    }
    public rejectForm(user){
      this.userRegistration.rejectStatusOfLife(user).subscribe(
        data=>{
          alert("Rejected Successfully");
          let curl=this._router.url;
          this._router.navigateByUrl('/',{skipLocationChange: true}).then(()=>{
          this._router.navigate([curl]);
          });
        },
        error=>{alert("Unsuccessfull")}
      )
    }
    public detailsForm(){
    this.userRegistration.getLifeData().subscribe(data=>{
      console.log(data);
      this.userData=data;
    })
  }
  ngOnInit(): void {

  }

}
