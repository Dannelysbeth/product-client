import {Component} from "@angular/core";
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {decrement, increment, reset} from "./counter.actions";
import {AsyncPipe} from "@angular/common";


@Component({
  selector: 'app-counter',
  standalone: true,
  imports: [
    AsyncPipe
  ],
  templateUrl: './counter.component.html'
})
export class CounterComponent {
  count$: Observable<number>;

  constructor(private readonly store: Store<{count: number}>) {
    store.dispatch(reset());
    this.count$ = store.select('count');
  }

  incrementMethod() {
    this.store.dispatch(increment());
  }

  decrementMethod() {
    this.store.dispatch(decrement());
  }

  resetMethod() {
    this.store.dispatch(reset());
  }


}


