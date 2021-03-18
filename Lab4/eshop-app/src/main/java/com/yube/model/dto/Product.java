package com.yube.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = {"productComments"}, callSuper = true)
@EqualsAndHashCode(exclude = {"productComments"}, callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product extends ObjectBase {
    private String categoryId;
    private String imageUrl;
    private Double price;
    private Integer ratingSum;
    private Integer ratingCount;
    private List<String> raters;
    private List<ProductComment> productComments;
}
