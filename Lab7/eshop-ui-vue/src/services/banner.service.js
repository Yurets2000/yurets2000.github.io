import {apiUrls} from "@/api-urls";
import http from "@/http-common";

class BannerService {

    basicUrl = apiUrls.API_BANNERS;

    getAll() {
        return http.get(this.basicUrl);
    }

    getById(id) {
        const url = `${this.basicUrl}/${id}`;
        return http.get(url);
    }

    getRandom() {
        const url = `${this.basicUrl}/random`;
        return http.get(url);
    }
}

export default new BannerService();
