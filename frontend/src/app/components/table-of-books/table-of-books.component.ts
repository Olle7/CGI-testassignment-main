import { Component, OnInit } from '@angular/core';
import { BookService } from '../../services/book.service';
import { Observable } from 'rxjs';
import { Page } from '../../models/page';
import { Book } from '../../models/book';

@Component({
  selector: 'app-books-list',
  templateUrl: './table-of-books.component.html',
  styleUrls: ['./table-of-books.component.scss']
})
export class TableOfBooksComponent implements OnInit {

  books$: Observable<Page<Book> | Error>;

  constructor(
    private bookService: BookService,
  ) {
  }

  ngOnInit(): void {
    // TODO this observable should emit books taking into consideration pagination, sorting and filtering options.
    this.books$ = this.bookService.getBooks({});

  }

}
