package com.yube.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
@Data
@EqualsAndHashCode(exclude = {"wishlist", "cart", "bought"}, callSuper = true)
@ToString(exclude = {"wishlist", "cart", "bought"}, callSuper = true)
public class UserEntity extends BaseEntity {
    @Column(nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @ManyToMany
    private Set<ProductEntity> wishlist = new HashSet<>();
    @ManyToMany
    private Set<ProductEntity> cart = new HashSet<>();
    @ManyToMany
    private Set<ProductEntity> bought = new HashSet<>();

    public void setWishlist(Set<ProductEntity> wishlist) {
        if (wishlist != null) {
            this.wishlist.clear();
            this.wishlist.addAll(wishlist);
        }
    }

    public void setCart(Set<ProductEntity> cart) {
        if (cart != null) {
            this.cart.clear();
            this.cart.addAll(cart);
        }
    }

    public void setBought(Set<ProductEntity> bought) {
        if (bought != null) {
            this.bought.clear();
            this.bought.addAll(bought);
        }
    }
}
