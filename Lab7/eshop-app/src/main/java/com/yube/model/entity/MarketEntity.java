package com.yube.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "markets")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MarketEntity extends ObjectBaseEntity {
    @Column
    private double latitude;
    @Column
    private double longitude;
}
