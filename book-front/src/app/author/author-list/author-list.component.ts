import { Component, OnInit } from '@angular/core';
import {Author} from "../../model/Author";
import {Router} from "@angular/router";
import {AuthorService} from "../../service/authorService/author.service";

@Component({
  selector: 'app-author-list',
  templateUrl: './author-list.component.html',
  styleUrls: ['./author-list.component.css']
})
export class AuthorListComponent implements OnInit {

  authors!: Author[];


  constructor(private authorService: AuthorService,
              private router: Router) { }
  ngOnInit(): void {
    this.getAuthors();
  }

  private getAuthors(){
    this.authorService.getAuthorList().subscribe(data => {
      this.authors = data;
    });
  }

  authorDetails(id: number){
    this.router.navigate(['author-details', id]).then(r => this.getAuthors());
  }

  updateAuthor(id: number){
    this.router.navigate(['update-author', id]).then(r => this.getAuthors());
  }

  deleteAuthor(id: number) {
    this.authorService.deleteAuthor(id).subscribe(data => {
        console.log("user deleted" + data);
        this.getAuthors();
      },(err)=>{
        console.log("unable to deleted user" + err)
      }
    )

  }

}
