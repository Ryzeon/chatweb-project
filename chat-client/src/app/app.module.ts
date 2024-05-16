import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginPageComponent} from './iam/pages/login-page/login-page.component';
import {PageNotFoundComponent} from './public/pages/page-not-found/page-not-found.component';
import {ButtonModule} from "primeng/button";
import {PanelModule} from "primeng/panel";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FloatLabelModule} from "primeng/floatlabel";
import {InputTextModule} from "primeng/inputtext";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ToastModule} from "primeng/toast";
import {MessagesModule} from "primeng/messages";
import {MessageService} from "primeng/api";

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MessagesModule,
    AppRoutingModule,
    ButtonModule,
    PanelModule,
    FloatLabelModule,
    InputTextModule,
    ReactiveFormsModule,
    FormsModule,
    ToastModule,
  ],
  providers: [
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
