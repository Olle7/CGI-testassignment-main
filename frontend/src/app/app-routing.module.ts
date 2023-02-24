import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BooksListComponent } from './components/books-list/books-list.component';
import { BookDetailComponent } from './components/book-detail/book-detail.component';
import { TableOfBooksComponent } from './components/table-of-books/table-of-books.component';
import { TableOfCheckoutsComponent } from "./components/table-of-checkouts/table-of-checkouts.component";

const routes: Routes = [
  {path: '', redirectTo: 'books', pathMatch: 'full'},
  {path: 'books', component: BooksListComponent},
  {path: 'books/:id', component: BookDetailComponent},
  {path: 'table_of_books', component: TableOfBooksComponent},
  {path: 'table_of_checkouts', component: TableOfCheckoutsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
