package com.yube.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = {"products", "characteristicGroups"}, callSuper = true)
@EqualsAndHashCode(exclude = {"products", "characteristicGroups"}, callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductCategory extends ObjectBase {
    private List<Product> products;
    private List<CharacteristicGroup> characteristicGroups;
}
