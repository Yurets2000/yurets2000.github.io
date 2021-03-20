import './product-block.component.css';
import React, {Component} from "react";
import ProductCategoriesService from "../../services/product-category.service";
import ProductCategoriesButtonGroup from "./product-categories-button-group";
import ProductItem from "../product-item/product-item.component";
import sort from "../../utils/list-utils";

export default class ProductBlock extends Component {

    constructor(props) {
        super(props);
        this.retrieveProductCategories = this.retrieveProductCategories.bind(this);
        this.onFilteringCategoriesChange = this.onFilteringCategoriesChange.bind(this);
        this.getProducts = this.getProducts.bind(this);

        this.state = {
            productCategories: [],
            products: []
        }
    }

    componentDidMount() {
        this.retrieveProductCategories();
        this.setState({
            products: this.props.data ? this.props.data.products : []
        });
    }

    retrieveProductCategories() {
        ProductCategoriesService.getAll()
            .then(response => {
                this.setState({
                    productCategories: response.data
                });
            })
            .catch(e => {
                console.log(e);
            });
    }

    getProducts(filteringCategories) {
        if (filteringCategories && filteringCategories.length > 0) {
            return this.props.data.products.filter(product => filteringCategories.indexOf(product.categoryId) !== -1);
        } else {
            return this.props.data.products;
        }
    }

    onFilteringCategoriesChange(newFilteringCategories) {
        this.setState({
            products: this.getProducts(newFilteringCategories)
        });
    }

    render() {
        if (!this.props.data) return null;
        return <div className="product-block">
            {this.props.dataType === 'Offering' &&
            <div>
                <h1>{this.props.data.name}</h1>
                <div>
                    <ProductCategoriesButtonGroup parentCallback={this.onFilteringCategoriesChange}
                                                  productCategories={this.state.productCategories}/>
                </div>
            </div>
            }
            <div className={`product-items ${this.props.dataType === 'Offering' ? 'main-items' : ''} 
            ${this.props.dataType === 'ProductCategory' ? 'filtered-items' : ''}`}>
                {
                    sort(this.state.products, 'name').map(function (product) {
                        return <ProductItem key={'product-block_' + product.id} product={product}/>
                    })
                }
            </div>
        </div>
    }
}
