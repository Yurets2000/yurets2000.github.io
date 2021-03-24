package com.yube.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = {"wishlist", "cart", "bought"}, callSuper = true)
@EqualsAndHashCode(exclude = {"wishlist", "cart", "bought"}, callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends Base {
    private String username;
    private String email;
    private String password;
    private List<Product> wishlist;
    private List<Product> cart;
    private List<Product> bought;
}
