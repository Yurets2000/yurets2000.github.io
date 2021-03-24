import {apiUrls} from "@/api-urls";
import http from "@/http-common";

class CharacteristicService {

    basicUrl = apiUrls.API_CHARACTERISTICS;

    getAll() {
        return http.get(this.basicUrl);
    }

    getById(id) {
        const url = `${this.basicUrl}/${id}`;
        return http.get(url);
    }

    create(characteristicGroupId, characteristic) {
        const url = `${this.basicUrl}/${characteristicGroupId}`;
        return http.post(url, characteristic);
    }

    update(characteristic) {
        return http.put(this.basicUrl, characteristic);
    }

    delete(id) {
        const url = `${this.basicUrl}/${id}`;
        return http.delete(url);
    }
}

export default new CharacteristicService();
