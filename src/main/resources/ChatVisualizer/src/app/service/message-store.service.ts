import { Injectable } from '@angular/core';
import {Message} from "../model/Message";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class MessageStoreService {

  constructor(private http: HttpClient) { }


  public getMessages(formData: FormData)  {
    return this.http.post<Array<Message>>(
      "api/v1/post/file",
      formData
    )
  }


}
