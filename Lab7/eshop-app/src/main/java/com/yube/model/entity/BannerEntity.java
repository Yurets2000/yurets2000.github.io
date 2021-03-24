package com.yube.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "banners")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BannerEntity extends BaseEntity {
    @Column(nullable = false)
    private String imageUrl;
}
