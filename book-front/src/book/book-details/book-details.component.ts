import {Component, OnInit} from '@angular/core';
import {Book} from '../../app/model/book';
import {ActivatedRoute} from '@angular/router';
import {BookService} from '../../app/service/bookService/book.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  id!: number
  book!: Book

  constructor(private route: ActivatedRoute, private bookService: BookService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.book = new Book();
    this.bookService.getBookById(this.id).subscribe(data => {
      this.book = data;
    });
  }
}
