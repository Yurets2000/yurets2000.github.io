import {constants} from "../constants";

const initialState = {
    user: localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : constants.DEFAULT_USER
};

const userReducer = (state = initialState, action) => {
    switch (action.type) {
        case "SET_USER":
            return {
                ...state,
                user: Object.assign({}, action.payload)
            };
        default:
            return state;
    }
}

export default userReducer;
