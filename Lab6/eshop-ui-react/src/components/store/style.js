import {makeAutoObservable} from "mobx";

class StyleStore {
    fancy = false;

    constructor() {
        makeAutoObservable(this);
    }

    switchFancy() {
        console.log('switchFancy');
        this.fancy = !this.fancy;
        console.log('fancy: ' + this.fancy);
    }

}

export default new StyleStore();
