import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ProductCategoryService} from '../../services/product-category.service';
import {ProductCategory} from '../../models/ProductCategory';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  productCategories: ProductCategory[];
  selectedProductCategory: ProductCategory;

  constructor(private route: ActivatedRoute,
              private productCategoryService: ProductCategoryService) {
  }

  ngOnInit(): void {
    this.loadSelectedProductCategory();
    this.loadProductCategories();
  }

  loadSelectedProductCategory(): void {
    const id = this.route.snapshot.queryParamMap.get('selected');
    if (id) {
      this.productCategoryService.getById(id).subscribe(
        productCategory => this.selectedProductCategory = productCategory
      );
    } else {
      this.productCategoryService.getDefault().subscribe(
        productCategory => this.selectedProductCategory = productCategory
      );
    }
  }

  loadProductCategories(): void {
    this.productCategoryService.getAll().subscribe(
      productCategories => this.productCategories = productCategories
    );
  }
}
