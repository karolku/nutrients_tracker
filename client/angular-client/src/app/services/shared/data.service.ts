import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private nutrientsConsumed: any;
  private data = new BehaviorSubject(this.nutrientsConsumed);
  sharedData = this.data.asObservable();

  constructor() { }

  public nextData(data: any) {
    this.data.next(data);
  }
}
