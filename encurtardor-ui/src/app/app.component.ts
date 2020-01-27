import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface Payload {
  shortURL: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'encurtardor-ui';
  inputBigUrl: string;
  shortUrl: any;

  constructor(
    private http: HttpClient
  ){}

  encurtarUrl() {
    const body = {originalURL: this.inputBigUrl}
    this.http.post('http://localhost:8081/ms-encurtador-url/encurtador/v1/', body)
    .subscribe((response: Payload) => {
      this.shortUrl = response.shortURL;
    });
  }
}

