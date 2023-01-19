import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListUsersComponent } from './list-users/list-users.component';
import { RegisterUserComponent } from './register-user/register-user.component';

const routes: Routes = [
  {path: 'users', component:ListUsersComponent},
  {path: '', redirectTo: 'users',pathMatch:'full'},
  {path: 'register-user', component:RegisterUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
