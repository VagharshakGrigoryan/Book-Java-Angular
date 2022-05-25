import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Author} from "../../model/Author";
import {AuthorService} from "../../service/authorService/author.service";

@Component({
  selector: 'app-create-author',
  templateUrl: './create-author.component.html',
  styleUrls: ['./create-author.component.css']
})
export class CreateAuthorComponent implements OnInit {

  author: Author = new Author();

  constructor(private authorService: AuthorService,
              private router: Router) {
  }

  ngOnInit(): void {
  }

  saveAuthor() {
    this.authorService.createAuthor(this.author).subscribe(data => {
        console.log(data);
        this.goToAuthorList();
      },
      error => console.log(error));
  }

  goToAuthorList() {
    this.router.navigate(['/authors']).then(r => this.author);
  }

  onSubmit() {
    console.log(this.author);
    this.saveAuthor();
  }
}
