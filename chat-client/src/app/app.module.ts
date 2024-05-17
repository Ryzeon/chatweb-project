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
import {ToolbarContentComponent} from './public/components/toolbar-content/toolbar-content.component';
import {HomePageComponent} from './public/pages/home-page/home-page.component';
import {ToolbarModule} from "primeng/toolbar";
import {SidebarModule} from "primeng/sidebar";
import {ChatSidebarContentComponent} from './chat/components/chat-group-sidebar-content/chat-sidebar-content.component';
import {ChatPageComponent} from './chat/pages/chat-page/chat-page.component';
import {HttpClientModule} from "@angular/common/http";
import {
  ChatGroupCreatedDialogComponent
} from './chat/components/chat-group-created-dialog/chat-group-created-dialog.component';
import {DialogModule} from "primeng/dialog";
import {DialogService} from "primeng/dynamicdialog";
import {StompClientService} from "./shared/service/stomp/stomp-client.service";
import {stompConfig} from "./infrastructure/communication/config/StompConfig";

const createStompClientService = () => {
  const rxStomp = new StompClientService();
  rxStomp.configure(stompConfig);
  rxStomp.activate();
  return rxStomp;
}

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    PageNotFoundComponent,
    ToolbarContentComponent,
    HomePageComponent,
    ChatSidebarContentComponent,
    ChatPageComponent,
    ChatGroupCreatedDialogComponent
  ],
  imports: [
    DialogModule,
    HttpClientModule,
    ToastModule,
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
    ToolbarModule,
    SidebarModule
  ],
  providers: [
    DialogService,
    MessageService,
    {
      provide: StompClientService,
      useFactory: createStompClientService
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
