import http from "../http-common";
import {apiUrls} from "../api-urls";

class ProductCommentService {

    basicUrl = apiUrls.API_PRODUCT_COMMENTS;

    getAll() {
        return http.get(this.basicUrl);
    }

    getById(id) {
        const url = `${this.basicUrl}/${id}`;
        return http.get(url);
    }

    create(productId, productComment) {
        const url = `${this.basicUrl}/${productId}`;
        return http.post(url, productComment);
    }

    update(productComment) {
        return http.put(this.basicUrl, productComment);
    }

    delete(id) {
        const url = `${this.basicUrl}/${id}`;
        return http.delete(url);
    }
}

export default new ProductCommentService();
