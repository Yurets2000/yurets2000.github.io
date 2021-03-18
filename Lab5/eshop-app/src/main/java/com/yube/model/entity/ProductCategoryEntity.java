package com.yube.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "product_categories")
@Data
@EqualsAndHashCode(exclude = {"products", "characteristicGroups"}, callSuper = true)
@ToString(exclude = {"products", "characteristicGroups"}, callSuper = true)
public class ProductCategoryEntity extends ObjectBaseEntity {
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductEntity> products = new HashSet<>();
    @ManyToMany
    private Set<CharacteristicGroupEntity> characteristicGroups = new HashSet<>();

    public void setProducts(Set<ProductEntity> products) {
        if (products != null) {
            products.forEach(productEntity -> productEntity.setCategory(this));
            this.products.clear();
            this.products.addAll(products);
        }
    }

    public void setCharacteristicGroups(Set<CharacteristicGroupEntity> characteristicGroups) {
        if (characteristicGroups != null) {
            characteristicGroups.forEach(characteristicGroupEntity -> {
                if (characteristicGroupEntity.getProductCategories().stream()
                        .map(BaseEntity::getId)
                        .noneMatch(id -> id.equals(this.getId()))) {
                    characteristicGroupEntity.getProductCategories().add(this);
                }
            });
            this.characteristicGroups.clear();
            this.characteristicGroups.addAll(characteristicGroups);
        }
    }
}
