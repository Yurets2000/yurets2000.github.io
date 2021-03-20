import http from "../http-common";
import {apiUrls} from "../api-urls";

class ProductService {

    basicUrl = apiUrls.API_PRODUCTS;

    getAll() {
        return http.get(this.basicUrl);
    }

    getById(id) {
        const url = `${this.basicUrl}/${id}`;
        return http.get(url);
    }

    create(productCategoryId, product) {
        const url = `${this.basicUrl}/${productCategoryId}`;
        return http.post(url, product);
    }

    update(product) {
        return http.put(this.basicUrl, product);
    }

    delete(id) {
        const url = `${this.basicUrl}/${id}`;
        return http.delete(url);
    }
}

export default new ProductService();
