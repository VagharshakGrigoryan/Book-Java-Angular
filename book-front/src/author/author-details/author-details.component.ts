import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Author} from "../../app/model/Author";
import {AuthorService} from "../../app/service/authorService/author.service";

@Component({
  selector: 'app-author-details',
  templateUrl: './author-details.component.html',
  styleUrls: ['./author-details.component.css']
})
export class AuthorDetailsComponent implements OnInit {

  id!: number
  author!: Author

  constructor(private route: ActivatedRoute, private authorService: AuthorService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.author = new Author();
    this.authorService.getAuthorById(this.id).subscribe(data => {
      this.author = data;
    });
  }}
