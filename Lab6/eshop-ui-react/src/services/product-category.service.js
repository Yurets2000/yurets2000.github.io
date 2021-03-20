import http from "../http-common";
import {apiUrls} from "../api-urls";

class ProductCategoryService {

    basicUrl = apiUrls.API_PRODUCT_CATEGORIES;

    getAll() {
        return http.get(this.basicUrl);
    }

    getById(id) {
        const url = `${this.basicUrl}/${id}`;
        return http.get(url);
    }

    getDefault() {
        const url = `${this.basicUrl}/default`;
        return http.get(url);
    }

    create(productCategory) {
        return http.post(this.basicUrl, productCategory);
    }

    update(productCategory) {
        return http.put(this.basicUrl, productCategory);
    }

    delete(id) {
        const url = `${this.basicUrl}/${id}`;
        return http.delete(url);
    }
}

export default new ProductCategoryService();
