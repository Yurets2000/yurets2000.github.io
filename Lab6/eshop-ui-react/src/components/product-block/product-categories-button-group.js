import './product-block.component.css';
import React from "react";
import ToggleButton from '@material-ui/lab/ToggleButton';
import ToggleButtonGroup from '@material-ui/lab/ToggleButtonGroup';
import sort from "../../utils/list-utils";
import {observer} from "mobx-react-lite";
import styleStore from "../store/style";
import generateColor from "../../utils/colors";

const ProductCategoriesButtonGroup = observer((props) => {
    const [categories, setCategories] = React.useState(() => []);

    const handleCategories = (event, newCategories) => {
        setCategories(newCategories);
        props.parentCallback(newCategories.map(function (category) {
            return category.id;
        }));
    };

    return (
        <ToggleButtonGroup value={categories} onChange={handleCategories} className="product-categories">
            {
                sort(props.productCategories, 'name').map(function (productCategory) {
                    return <ToggleButton style={{backgroundColor: !styleStore.fancy ? 'white' : generateColor()}}
                                         key={'product-categories-button-group_' + productCategory.id}
                                         value={productCategory}>{productCategory.name}</ToggleButton>
                })
            }
        </ToggleButtonGroup>
    );
});

export default ProductCategoriesButtonGroup;
