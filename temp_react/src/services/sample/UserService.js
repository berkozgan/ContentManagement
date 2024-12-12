import { mainUrl } from "store/constant";
import ServiceCaller from 'services/ServiceCaller';

class UserService {
    getAllUsers(serviceCaller, callback, errorCallBack) {
        serviceCaller.get(
            `${mainUrl}/users/getAll`, 
            undefined, 
            undefined, 
            callback, 
            errorCallBack
        );
    }

    addUser(serviceCaller, userRequestBody, callback, errorCallBack) {
        const headers = { 'Content-Type': 'application/json' };
        serviceCaller.post(
            `${mainUrl}/users/add`, 
            undefined, 
            headers, 
            userRequestBody, 
            callback, 
            errorCallBack
        );
    }

    removeUserById(serviceCaller, userId, callback, errorCallBack) {
        serviceCaller.delete(
            `${mainUrl}/users/remove/${userId}`, 
            undefined, 
            undefined, 
            callback, 
            errorCallBack
        );
    }
}

export default new UserService();
