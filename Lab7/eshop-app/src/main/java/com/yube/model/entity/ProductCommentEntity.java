package com.yube.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name = "product_comments")
@Data
@EqualsAndHashCode(exclude = {"product"}, callSuper = true)
@ToString(exclude = {"product"}, callSuper = true)
public class ProductCommentEntity extends BaseEntity {
    @Column(nullable = false)
    private String author;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    private ProductEntity product;
}
