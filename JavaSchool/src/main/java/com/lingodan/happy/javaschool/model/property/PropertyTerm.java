package com.lingodan.happy.javaschool.model.property;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PropertyTerm {

    private String value;

    private List<Integer> position;


    public PropertyTerm(String value) {
        this.value = value;
    }

    public void addIndex(Integer index) {
        if (position == null) {
            position = new ArrayList<>();
        }
        position.add(index);
    }
}
