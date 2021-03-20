import http from "../http-common";
import {apiUrls} from "../api-urls";

class OfferingService {

    basicUrl = apiUrls.API_OFFERINGS;

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

    create(offering) {
        return http.post(this.basicUrl, offering);
    }

    update(offering) {
        return http.put(this.basicUrl, offering);
    }

    delete(id) {
        const url = `${this.basicUrl}/${id}`;
        return http.delete(url);
    }
}

export default new OfferingService();
