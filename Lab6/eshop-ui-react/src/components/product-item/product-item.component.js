/* eslint-disable jsx-a11y/anchor-is-valid */
import './product-item.component.css';
import {Component} from "react";
import Rating from '@material-ui/lab/Rating';
import {Button} from "@material-ui/core";
import FavoriteIcon from '@material-ui/icons/Favorite';
import ShoppingCartIcon from '@material-ui/icons/ShoppingCart';
import UserService from "../../services/user.service";
import {connect} from "react-redux";
import allActions from "../../actions";
import {observer} from "mobx-react";
import styleStore from "../store/style";
import generateColor from "../../utils/colors";

const ProductItem = observer(class ProductItem extends Component {

    constructor(props) {
        super(props);
        this.retrieveRating = this.retrieveRating.bind(this);
        this.retrieveCommentsCount = this.retrieveCommentsCount.bind(this);
        this.onCart = this.onCart.bind(this);
        this.onWishlist = this.onWishlist.bind(this);

        this.state = {
            isInWishList: false,
            isInCart: false
        }
    }

    componentDidMount() {
        if (this.props.user) {
            this.setState({
                isInWishList: this.props.user.wishlist
                    .findIndex(product => product.id === this.props.product.id) >= 0,
                isInCart: this.props.user.cart
                    .findIndex(product => product.id === this.props.product.id) >= 0
            });
        }
    }

    retrieveRating(product) {
        if (product.ratingCount >= 1) {
            return product.ratingSum / product.ratingCount;
        }
        return 0;
    }

    retrieveCommentsCount(product) {
        const comments = product.productComments;
        return comments ? comments.length : 0;
    }

    onWishlist(e) {
        const user = this.props.user;
        if (user) {
            const index = user.wishlist.findIndex(product => product.id === this.props.product.id);
            if (index === -1) {
                user.wishlist.push(this.props.product);
                this.setState({
                    isInWishList: true
                });
            } else {
                user.wishlist.splice(index, 1);
                this.setState({
                    isInWishList: false
                });
            }
            this.props.dispatch(allActions.userActions.setUser(user));
            UserService.update(user).then();
        }
    }

    onCart(e) {
        const user = this.props.user;
        if (user) {
            const index = user.cart.findIndex(product => product.id === this.props.product.id);
            if (index === -1) {
                user.cart.push(this.props.product);
                this.setState({
                    isInCart: true
                });
            } else {
                user.cart.splice(index, 1);
                this.setState({
                    isInCart: false
                });
            }
            this.props.dispatch(allActions.userActions.setUser(user));
            UserService.update(user).then();
        }
    }

    render() {
        const product = this.props.product;
        return <div className="product-item" style={{backgroundColor: !styleStore.fancy ? 'white' : generateColor()}}>
            <div className="product-image-container">
                <img className="product-image" src={product.imageUrl} alt="Product Item"/>
            </div>
            <div className="product-info-description">
                <p className="product-name">{product.name}</p>
                <div className="product-info">
                    <div className="product-responses">
                        <div className="product-rating">
                            <Rating name="product-rating" value={this.retrieveRating(product)} precision={0.25}
                                    checkedcolor="orange" uncheckedcolor="black" size="small" readOnly={true}/>
                        </div>
                        <div className="product-comments">
                            <a href="#" className="comment">
                                <i className="fa fa-comment"/>
                                <span className="comment-value">{this.retrieveCommentsCount(product)}</span>
                            </a>
                        </div>
                    </div>
                    <div className="product-price">
                        <span className="price-value">{product.price} $</span>
                    </div>
                    <div className="product-actions">
                        <Button size="large" style={{backgroundColor: this.state.isInWishList ? 'salmon' : '#e0e0e0'}}
                                onClick={this.onWishlist}>
                            <FavoriteIcon/>
                        </Button>
                        <Button size="large" style={{backgroundColor: this.state.isInCart ? 'salmon' : '#e0e0e0'}}
                                onClick={this.onCart}>
                            <ShoppingCartIcon/>
                        </Button>
                    </div>
                </div>
            </div>
        </div>
    }
});

const mapStateToProps = (state) => {
    const user = state.user;
    return {
        user
    };
}

export default connect(mapStateToProps)(ProductItem);
