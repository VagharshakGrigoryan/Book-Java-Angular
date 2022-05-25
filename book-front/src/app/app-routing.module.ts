import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookListComponent } from '../book/book-list/book-list.component';
import { CreateBookComponent } from '../book/create-book/create-book.component';
import { UpdateBookComponent } from '../book/update-book/update-book.component';
import { BookDetailsComponent } from '../book/book-details/book-details.component';
import {AuthorListComponent} from "./author/author-list/author-list.component";
import {AuthorDetailsComponent} from "./author/author-details/author-details.component";
import {CreateAuthorComponent} from "./author/create-author/create-author.component";
import {UpdateAuthorComponent} from "./author/update-author/update-author.component";

const routes: Routes = [
  {path: 'books', component: BookListComponent},
  {path: 'create-book', component: CreateBookComponent},
  {path: '', redirectTo: 'books', pathMatch: 'full'},
  {path: 'update-book/:id', component: UpdateBookComponent},
  {path: 'book-details/:id', component: BookDetailsComponent},
  {path: 'authors', component: AuthorListComponent},
  {path: 'create-author', component: CreateAuthorComponent},
  {path: '', redirectTo: 'authors', pathMatch: 'full'},
  {path: 'update-author/:id', component: UpdateAuthorComponent},
  {path: 'author-details/:id', component: AuthorDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
