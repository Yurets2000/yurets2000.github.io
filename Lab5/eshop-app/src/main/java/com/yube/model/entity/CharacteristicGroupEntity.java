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

@Entity(name = "characteristic_groups")
@Data
@EqualsAndHashCode(exclude = {"characteristics", "productCategories"}, callSuper = true)
@ToString(exclude = {"characteristics", "productCategories"}, callSuper = true)
public class CharacteristicGroupEntity extends ObjectBaseEntity {
    @ManyToMany(mappedBy = "characteristicGroups")
    private Set<ProductCategoryEntity> productCategories = new HashSet<>();
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CharacteristicEntity> characteristics = new HashSet<>();

    public void setCharacteristics(Set<CharacteristicEntity> characteristics) {
        if (characteristics != null) {
            characteristics.forEach(characteristicEntity -> characteristicEntity.setGroup(this));
            this.characteristics.clear();
            this.characteristics.addAll(characteristics);
        }
    }

    public void setProductCategories(Set<ProductCategoryEntity> productCategories) {
        if (productCategories != null) {
            this.productCategories = productCategories;
        }
    }
}
