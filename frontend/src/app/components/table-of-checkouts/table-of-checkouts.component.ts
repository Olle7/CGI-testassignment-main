import { Component, OnInit } from '@angular/core';
import { BookService } from '../../services/book.service';
import { Observable } from 'rxjs';
import { Page } from '../../models/page';
import { Book } from '../../models/book';

@Component({
  selector: 'app-books-list',
  templateUrl: './table-of-checkouts.component.html',
  styleUrls: ['./table-of-checkouts.component.scss']
})
export class TableOfCheckoutsComponent implements OnInit {

  books$: Observable<Page<Book> | Error>;
  columns_of_table_of_books:Array<String>;

  constructor(
    private bookService: BookService,
  ) {
  }

  ngOnInit(): void {
    // TODO this observable should emit books taking into consideration pagination, sorting and filtering options.
    this.books$ = this.bookService.getBooks({});
    this.columns_of_table_of_books = ["author","title","year","status","dueDate","id","added","checkOutCount","genre","comment"];
  }

}
