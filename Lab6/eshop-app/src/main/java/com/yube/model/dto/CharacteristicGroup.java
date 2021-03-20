package com.yube.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = {"characteristics"}, callSuper = true)
@EqualsAndHashCode(exclude = {"characteristics"}, callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacteristicGroup extends ObjectBase {
    private List<Characteristic> characteristics;
}
