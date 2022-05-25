import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from 'rxjs';
import {Author} from "../../model/Author";

@Injectable({
  providedIn: 'root'
})
export class AuthorService{
  private baseURL = "http://localhost:8081/authors";

  constructor(private httpClient: HttpClient) {
  }

  getAuthorList(): Observable<Author[]> {
    return this.httpClient.get<Author[]>(`${this.baseURL}`);
  }

  createAuthor(author: Author): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, author);
  }

  getAuthorById(id: number): Observable<Author> {
    return this.httpClient.get<Author>(`${this.baseURL}/${id}`);
  }

  updateAuthor(id: number, author: Author): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/${id}`, author);
  }

  deleteAuthor(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

}
