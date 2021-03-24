package com.yube.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = {"productComments", "characteristics"}, callSuper = true)
@EqualsAndHashCode(exclude = {"productComments", "characteristics"}, callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product extends ObjectBase {
    private String categoryId;
    private String imageUrl;
    private Double price;
    private Integer ratingSum;
    private Integer ratingCount;
    private List<String> raters;
    private List<ProductComment> productComments;
    private List<Characteristic> characteristics;
}
