import {ProductComment} from './ProductComment';
import {ObjectBase} from './ObjectBase';

export class Product extends ObjectBase {
  categoryId: string;
  imageUrl: string;
  price: number;
  ratingSum: number;
  ratingCount: number;
  raters: string[];
  productComments: ProductComment[];
}
