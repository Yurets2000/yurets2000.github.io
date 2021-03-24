import {apiUrls} from "@/api-urls";
import http from "@/http-common";

class CharacteristicGroupService {

    basicUrl = apiUrls.API_CHARACTERISTIC_GROUPS;

    getAll() {
        return http.get(this.basicUrl);
    }

    getById(id) {
        const url = `${this.basicUrl}/${id}`;
        return http.get(url);
    }

    create(characteristic) {
        return http.post(this.basicUrl, characteristic);
    }

    update(characteristic) {
        return http.put(this.basicUrl, characteristic);
    }

    delete(id) {
        const url = `${this.basicUrl}/${id}`;
        return http.delete(url);
    }
}

export default new CharacteristicGroupService();
