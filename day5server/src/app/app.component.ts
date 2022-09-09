import { Component } from '@angular/core';
import { Register } from './models';
import { RegisterService } from './services/RegisterService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'day5server';

  constructor(private regSvc: RegisterService) { }

  processNewRegister(onNewRegister: Register) {
    console.info(">>>>>New Registration: ", onNewRegister)
    this.regSvc.onNewRegister(onNewRegister)
      .then(result => {
        console.info('>>>>RESULT: ',result)
      })
      .catch(error => {
        console.error('>>>>ERROR: ',error)
      })
  }
  
}
