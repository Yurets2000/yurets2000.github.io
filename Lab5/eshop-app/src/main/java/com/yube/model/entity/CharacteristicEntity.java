package com.yube.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "characteristics")
@Data
@EqualsAndHashCode(exclude = {"group", "products"}, callSuper = true)
@ToString(exclude = {"group", "products"}, callSuper = true)
public class CharacteristicEntity extends BaseEntity {
    @Column(nullable = false)
    private String value;
    @ManyToOne
    private CharacteristicGroupEntity group;
    @ManyToMany(mappedBy = "characteristics")
    private Set<ProductEntity> products = new HashSet<>();

    public void setProducts(Set<ProductEntity> products) {
        if (products != null) {
            this.products = products;
        }
    }
}
