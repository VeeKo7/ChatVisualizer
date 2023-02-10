import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MessageComponent } from './message/message.component';
import { HomeComponent } from './home/home.component';
import { MessageStoreService } from "./service/message-store.service";
import { HttpClientModule } from "@angular/common/http";
import { TestComponent } from './test/test.component';

@NgModule({
  declarations: [
    AppComponent,
    MessageComponent,
    HomeComponent,
    TestComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [MessageStoreService],
  bootstrap: [AppComponent]
})
export class AppModule { }
