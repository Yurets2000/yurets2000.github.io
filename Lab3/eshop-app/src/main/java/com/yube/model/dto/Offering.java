package com.yube.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = {"products"}, callSuper = true)
@EqualsAndHashCode(exclude = {"products"}, callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Offering extends ObjectBase {
    private List<Product> products;
}
