package com.yube.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "products")
@Data
@EqualsAndHashCode(exclude = {"offerings", "category", "productComments"}, callSuper = true)
@ToString(exclude = {"offerings", "category", "productComments"}, callSuper = true)
public class ProductEntity extends ObjectBaseEntity {
    @Column(nullable = false)
    private String imageUrl;
    @Column(nullable = false)
    private Double price;
    @Column
    private Integer ratingSum;
    @Column
    private Integer ratingCount;
    @ElementCollection
    @CollectionTable(name = "raters", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "rater")
    private Set<UUID> raters = new HashSet<>();
    @ManyToOne
    private ProductCategoryEntity category;
    @ManyToMany(mappedBy = "products")
    private Set<OfferingEntity> offerings = new HashSet<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductCommentEntity> productComments = new HashSet<>();

    public void setOfferings(Set<OfferingEntity> offerings) {
        if (offerings != null) {
            this.offerings = offerings;
        }
    }

    public void setProductComments(Set<ProductCommentEntity> productComments) {
        if (productComments != null) {
            productComments.forEach(productCommentEntity -> productCommentEntity.setProduct(this));
            this.productComments.clear();
            this.productComments.addAll(productComments);
        }
    }

    public void setRaters(Set<UUID> raters) {
        if (raters != null) {
            this.raters = raters;
        }
    }
}
