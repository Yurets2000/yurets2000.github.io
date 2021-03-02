import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {MatButtonModule} from '@angular/material/button';

import {AppComponent} from './app.component';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {ProductBlockComponent} from './components/product-block/product-block.component';
import {ProductItemComponent} from './components/product-item/product-item.component';
import {FormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {RatingModule} from 'ng-starrating';
import {ArraySortPipe} from './pipes/array-sort.pipe';
import {CategoriesComponent} from './components/categories/categories.component';
import {OfferingsComponent} from './components/offerings/offerings.component';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonToggleModule} from '@angular/material/button-toggle';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ProductBlockComponent,
    ProductItemComponent,
    ArraySortPipe,
    CategoriesComponent,
    OfferingsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RatingModule,
    AppRoutingModule,
    HttpClientModule,
    MatButtonModule,
    MatIconModule,
    MatButtonToggleModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
