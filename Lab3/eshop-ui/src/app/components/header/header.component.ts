import {Component, OnInit} from '@angular/core';
import {ProductCategory} from '../../models/ProductCategory';
import {ProductCategoryService} from '../../services/product-category.service';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isCategoriesOpen = false;
  productCategories: ProductCategory[];

  constructor(private userService: UserService,
              private productCategoryService: ProductCategoryService) {
  }

  ngOnInit(): void {
    this.loadProductCategories();
  }

  getTotalPrice(): number {
    if (this.userService.userValue.cart.length > 0) {
      return this.userService.userValue.cart
        .map(product => product.price)
        .reduce((a, b) => a + b);
    } else {
      return 0;
    }
  }

  getTotalCount(): number {
    return this.userService.userValue.cart.length;
  }

  openCloseCategories($event: MouseEvent): void {
    this.isCategoriesOpen = !this.isCategoriesOpen;
  }

  private loadProductCategories(): void {
    this.productCategoryService.getAll().subscribe(
      productCategories => this.productCategories = productCategories
    );
  }
}
