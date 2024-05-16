import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginPageComponent} from "./iam/pages/login-page/login-page.component";
import {PageNotFoundComponent} from "./public/pages/page-not-found/page-not-found.component";

const routes: Routes = [
  {path: 'login', component: LoginPageComponent},
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
  // {path: 'home', loadChildren: () => import('./home/home.module').then(m => m.HomeModule)},
  // {path: 'chat', loadChildren: () => import('./chat/chat.module').then(m => m.ChatModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
