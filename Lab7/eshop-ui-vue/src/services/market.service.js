import {apiUrls} from "@/api-urls";
import http from "@/http-common";

class MarketService {

    basicUrl = apiUrls.API_MARKETS;

    getAll() {
        return http.get(this.basicUrl);
    }

    getById(id) {
        const url = `${this.basicUrl}/${id}`;
        return http.get(url);
    }

    create(market) {
        return http.post(this.basicUrl, market);
    }

    update(market) {
        return http.put(this.basicUrl, market);
    }

    delete(id) {
        const url = `${this.basicUrl}/${id}`;
        return http.delete(url);
    }
}

export default new MarketService();
