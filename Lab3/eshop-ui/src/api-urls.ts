import {environment} from './environments/environment';

export const apiUrls = {
  API_OFFERINGS: environment.BASE_URL + '/offerings',
  API_PRODUCTS: environment.BASE_URL + '/products',
  API_PRODUCT_CATEGORIES: environment.BASE_URL + '/product-categories',
  API_PRODUCT_COMMENTS: environment.BASE_URL + '/product-comments',
  API_USERS: environment.BASE_URL + '/users',
};
