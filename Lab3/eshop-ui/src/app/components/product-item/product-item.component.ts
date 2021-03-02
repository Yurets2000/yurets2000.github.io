import {Component, Input, OnInit} from '@angular/core';
import {Product} from '../../models/Product';
import {StarRatingComponent} from 'ng-starrating';
import {ProductService} from '../../services/product.service';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {
  @Input() product: Product;
  isInWishList: boolean;
  isInCart: boolean;

  constructor(private userService: UserService,
              private productService: ProductService) {
  }

  ngOnInit(): void {
    this.isInWishList = this.userService.userValue.wishlist
      .findIndex(product => product.id === this.product.id) >= 0;
    this.isInCart = this.userService.userValue.cart
      .findIndex(product => product.id === this.product.id) >= 0;
  }

  public retrieveRating(product: Product): number {
    if (product.ratingCount >= 1) {
      return product.ratingSum / product.ratingCount;
    }
    return 0;
  }

  public retrieveCommentsCount(product: Product): number {
    const comments = product.productComments;
    return comments ? comments.length : 0;
  }

  onRate($event: { oldValue: number; newValue: number; starRating: StarRatingComponent }): void {
    const user = this.userService.userValue;
    if (this.product.raters.findIndex(id => id === user.id) === -1) {
      this.product.ratingCount++;
      this.product.ratingSum += $event.newValue;
      this.product.raters.push(user.id);
      this.productService.update(this.product).subscribe();
    }
  }

  onWishlist($event: MouseEvent): void {
    const user = this.userService.userValue;
    const index = user.wishlist.findIndex(product => product.id === this.product.id);
    if (index === -1) {
      user.wishlist.push(this.product);
      this.isInWishList = true;
    } else {
      user.wishlist.splice(index, 1);
      this.isInWishList = false;
    }
    this.userService.update(user).subscribe();
  }

  onCart($event: MouseEvent): void {
    const user = this.userService.userValue;
    const index = user.cart.findIndex(product => product.id === this.product.id);
    if (index === -1) {
      user.cart.push(this.product);
      this.isInCart = true;
    } else {
      user.cart.splice(index, 1);
      this.isInCart = false;
    }
    this.userService.update(user).subscribe();
  }
}
