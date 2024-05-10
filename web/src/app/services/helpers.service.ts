import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HelpersService {

  public isLoading = new Subject<boolean>();

  constructor(private snackBar: MatSnackBar, private router: Router) { }

  openSnackBar(message: string): void {
    this.snackBar.open(message, 'Sair', {
      horizontalPosition: "end",
      verticalPosition: "bottom",
    });
  }

  showLoading(){
    this.isLoading.next(true);
  }

  hideLoading(){
    this.isLoading.next(false);
  }

  reloadComponent(self:boolean,urlToNavigateTo ?:string){
   console.log("Current route I am on:",this.router.url);
   const url=self ? this.router.url :urlToNavigateTo;
   this.router.navigateByUrl('/',{skipLocationChange:true}).then(()=>{
     this.router.navigate([`/${url}`]).then(()=>{
       console.log(`After navigation I am on:${this.router.url}`)
     })
   })
 }

}
