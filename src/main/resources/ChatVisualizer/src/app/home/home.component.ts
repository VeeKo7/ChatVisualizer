import { Component, OnInit } from '@angular/core';
import {Message} from "../model/Message";
import {Observable} from "rxjs";
import {MessageStoreService} from "../service/message-store.service";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  result: Observable<Array<Message>> | undefined;
  file!: File;
  messages: Array<Message> | undefined;



  constructor(private service: MessageStoreService) { }

  ngOnInit(): void {}

  upload() {
    console.log("uploading file.. " + this.file.name)
    let formData = new FormData();
    formData.append("file", this.file, this.file.name)
    this.result = this.service.getMessages(formData);
    this.result.subscribe(
      (messages) => {
        this.messages = messages;
      }
    )
    }

  onChange(event: Event) {
    console.log("file changed")
    // @ts-ignore
    this.file = event.target.files[0]
  }
}
