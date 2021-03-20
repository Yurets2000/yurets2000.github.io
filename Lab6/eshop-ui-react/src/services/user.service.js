import http from "../http-common";
import {apiUrls} from "../api-urls";

class UserService {

    basicUrl = apiUrls.API_USERS;

    findByEmailAndPassword(email, password) {
        const url = `${this.basicUrl}?email=${email}&password=${password}`;
        return http.get(url);
    }

    create(user) {
        return http.post(this.basicUrl, user);
    }

    update(user) {
        return http.put(this.basicUrl, user);
    }

    delete(id) {
        const url = `${this.basicUrl}/${id}`;
        return http.delete(url);
    }
}

export default new UserService();
