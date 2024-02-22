import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { SalePage } from 'src/app/pages/sale/sale.page';
import { FormsModule } from '@angular/forms';
import { CardComponent } from 'src/app/components/card/card.component';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    AppComponent,
    SalePage,
    CardComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    BrowserModule,
    RouterModule.forRoot([
      {path: 'ventas', component:SalePage},
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
