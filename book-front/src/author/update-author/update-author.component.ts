import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Author} from "../../app/model/Author";
import {AuthorService} from "../../app/service/authorService/author.service";

@Component({
  selector: 'app-update-author',
  templateUrl: './update-author.component.html',
  styleUrls: ['./update-author.component.css']
})
export class UpdateAuthorComponent implements OnInit {

  id!: number;
  author: Author = new Author();
  constructor(private authorService: AuthorService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.authorService.getAuthorById(this.id).subscribe(data => {
      this.author = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.authorService.updateAuthor(this.id, this.author).subscribe(data =>{
        this.goToBookList();
      }
      , error => console.log(error));
  }

  goToBookList(){
    this.router.navigate(['/authors']);
  }
}
