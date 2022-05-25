import { Component, OnInit } from '@angular/core';
import {Book} from '../../app/model/book'
import { BookService } from '../../app/service/bookService/book.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books!: Book[];

  constructor(private bookService: BookService,
    private router: Router
             ) { }

  ngOnInit(): void {
    this.getBooks();
  }

  private getBooks(){
    this.bookService.getBookList().subscribe(data => {
      this.books = data;
    });
  }

  bookDetails(id: number){
    this.router.navigate(['book-details', id]).then(r => this.getBooks());
  }

  updateBook(id: number){
    this.router.navigate(['update-book', id]).then(r => this.getBooks());
  }

  deleteBook(id: number) {
    this.bookService.deleteBook(id).subscribe(data => {
      console.log("user deleted" + data);
      this.getBooks();
    },(err)=>{
      console.log("unable to deleted user" + err)
      }
    )

  }

}
