import { Component } from '@angular/core';
import {Message} from "./model/Message";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ChatVisualizer';

  messageFromAppComponent: Message = new Message("12:00", "23/12/2000", "Amparo", "Hi!");

}
