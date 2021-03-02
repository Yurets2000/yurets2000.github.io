import {Base} from './Base';
import {Product} from './Product';

export class User extends Base {
  username: string;
  email: string;
  password: string;
  wishlist: Product[];
  cart: Product[];
  bought: Product[];
}
