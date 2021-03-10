import './offerings.component.css';
import React, {Component} from "react";
import ProductBlock from "../product-block/product-block.component";
import OfferingService from "../../services/offering.service";

export default class Offerings extends Component {

    constructor(props) {
        super(props);
        this.retrieveOfferings = this.retrieveOfferings.bind(this);

        this.state = {
            offerings: []
        }
    }

    componentDidMount() {
        this.retrieveOfferings();
    }

    retrieveOfferings() {
        OfferingService.getAll()
            .then(response => {
                this.setState({
                    offerings: response.data
                });
            })
            .catch(e => {
                console.log(e);
            });
    }

    render() {
        return <div className="offerings-container">
            {
                this.state.offerings.map(function (offering) {
                    return <ProductBlock key={offering.id} dataType={'Offering'} data={offering}/>
                })
            }
        </div>
    }
}
