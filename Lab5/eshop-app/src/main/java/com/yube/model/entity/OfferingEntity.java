package com.yube.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "offerings")
@Data
@EqualsAndHashCode(exclude = {"products"}, callSuper = true)
@ToString(exclude = {"products"}, callSuper = true)
public class OfferingEntity extends ObjectBaseEntity {
    @ManyToMany
    private Set<ProductEntity> products = new HashSet<>();

    public void setProducts(Set<ProductEntity> products) {
        if (products != null) {
            products.forEach(productEntity -> {
                if (productEntity.getOfferings().stream()
                        .map(BaseEntity::getId)
                        .noneMatch(id -> id.equals(this.getId()))) {
                    productEntity.getOfferings().add(this);
                }
            });
            this.products.clear();
            this.products.addAll(products);
        }
    }
}
