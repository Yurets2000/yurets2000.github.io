import './categories.component.css';
import {Component} from "react";
import ProductCategoriesService from "../../services/product-category.service";
import ProductBlock from "../product-block/product-block.component";
import getParameterByName from "../../utils/url-utils";
import sort from "../../utils/list-utils";

export default class Categories extends Component {

    constructor(props) {
        super(props);
        this.retrieveProductCategories = this.retrieveProductCategories.bind(this);
        this.retrieveSelectedProductCategory = this.retrieveSelectedProductCategory.bind(this);

        this.state = {
            productCategories: [],
            selectedProductCategory: null
        }
    }

    componentDidMount() {
        this.retrieveProductCategories();
        this.retrieveSelectedProductCategory();
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

    retrieveSelectedProductCategory() {
        const id = getParameterByName('selected');
        if (id) {
            ProductCategoriesService.getById(id)
                .then(response => {
                    this.setState({
                        selectedProductCategory: response.data
                    });
                })
                .catch(e => {
                    console.log(e);
                });
        } else {
            ProductCategoriesService.getDefault()
                .then(response => {
                    this.setState({
                        selectedProductCategory: response.data
                    });
                })
                .catch(e => {
                    console.log(e);
                });
        }
    }

    render() {
        const selectedProductCategory = this.state.selectedProductCategory;
        return <div className="categories">
            <div className="filtering-block">
                <div className="categories-block">
                    <h3 className="categories-head">Categories</h3>
                    <ul className="product-categories">
                        {
                            sort(this.state.productCategories, 'name').map(function (productCategory) {
                                return <li
                                    key={'categories_' + productCategory.id}
                                    className={`${selectedProductCategory && productCategory.id === selectedProductCategory.id ? 'selected-item' : ''}`}>
                                    <a href={'./categories?selected=' + productCategory.id}>{productCategory.name}</a>
                                </li>
                            })
                        }
                    </ul>
                </div>
                <div className="filters-block">
                    <h3 className="filters-head">Additional Filters</h3>
                    <ul className="filters-categories">
                        <li>
                            <div id="color-category" className="filter-category">
                                <h4 className="filter-category-head">Color</h4>
                                <ul className="filter-subcategories">
                                    <li>
                                        <input type="checkbox" id="white" name="color" value="White"/>
                                        <label htmlFor="white">White</label>
                                    </li>
                                    <li>
                                        <input type="checkbox" id="black" name="color" value="Black"/>
                                        <label htmlFor="black">Black</label>
                                    </li>
                                    <li>
                                        <input type="checkbox" id="gold" name="color" value="Gold"/>
                                        <label htmlFor="gold">Gold</label>
                                    </li>
                                    <li>
                                        <input type="checkbox" id="red" name="color" value="Red"/>
                                        <label htmlFor="red">Red</label>
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            {selectedProductCategory &&
            <ProductBlock data={selectedProductCategory} dataType={'ProductCategory'}/>
            }
        </div>
    }
}
