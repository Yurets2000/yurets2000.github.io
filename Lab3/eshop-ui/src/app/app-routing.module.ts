import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CategoriesComponent} from './components/categories/categories.component';
import {OfferingsComponent} from './components/offerings/offerings.component';

const routes: Routes = [
  {path: '', component: OfferingsComponent},
  {path: 'categories', component: CategoriesComponent},
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
