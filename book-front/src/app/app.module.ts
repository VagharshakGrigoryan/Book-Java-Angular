import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookListComponent } from '../book/book-list/book-list.component';
import { CreateBookComponent } from '../book/create-book/create-book.component';
import { FormsModule} from '@angular/forms';
import { UpdateBookComponent } from '../book/update-book/update-book.component';
import { BookDetailsComponent } from '../book/book-details/book-details.component';
import { AuthorListComponent } from '../author/author-list/author-list.component';
import { AuthorDetailsComponent } from '../author/author-details/author-details.component';
import { CreateAuthorComponent } from '../author/create-author/create-author.component';
import { UpdateAuthorComponent } from '../author/update-author/update-author.component'


@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    CreateBookComponent,
    UpdateBookComponent,
    BookDetailsComponent,
    AuthorListComponent,
    AuthorDetailsComponent,
    CreateAuthorComponent,
    UpdateAuthorComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
