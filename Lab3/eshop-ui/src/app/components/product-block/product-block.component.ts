import {Component, Input, OnInit} from '@angular/core';
import {ProductCategory} from '../../models/ProductCategory';
import {Offering} from '../../models/Offering';
import {ProductService} from '../../services/product.service';
import {ProductCategoryService} from '../../services/product-category.service';
import {OfferingService} from '../../services/offering.service';
import {MatButtonToggleChange} from '@angular/material/button-toggle';
import {Product} from '../../models/Product';

@Component({
  selector: 'app-product-block',
  templateUrl: './product-block.component.html',
  styleUrls: ['./product-block.component.css']
})
export class ProductBlockComponent implements OnInit {
  @Input() data: ProductCategory | Offering;
  @Input() dataType: string;
  productCategories?: ProductCategory[];
  filteringCategories?: string[];

  constructor(private productService: ProductService,
              private offeringService: OfferingService,
              private productCategoryService: ProductCategoryService) {
  }

  ngOnInit(): void {
    this.loadProductCategories();
  }

  private loadProductCategories(): void {
    this.productCategoryService.getAll()
      .subscribe(productCategories => this.productCategories = productCategories);
  }

  getProducts(): Product[] {
    if (this.dataType === 'Offering' && this.filteringCategories && this.filteringCategories.length > 0) {
      return this.data.products.filter(product => this.filteringCategories.indexOf(product.categoryId) !== -1);
    } else {
      return this.data.products;
    }
  }

  onCategorySelectionChange($event: MatButtonToggleChange): void {
    const checked = $event.source.checked;
    const productCategory = $event.value;
    if (checked) {
      if (!this.filteringCategories) {
        this.filteringCategories = [];
      }
      this.filteringCategories.push(productCategory.id);
    } else if (this.filteringCategories.length > 0) {
      const index = this.filteringCategories.indexOf(productCategory.id);
      this.filteringCategories.splice(index, 1);
    }
  }
}
