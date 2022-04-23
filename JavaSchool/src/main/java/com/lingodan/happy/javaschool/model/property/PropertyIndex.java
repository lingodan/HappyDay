package com.lingodan.happy.javaschool.model.property;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PropertyIndex {

    private String property;

    private List<PropertyTerm> terms;


    public List<String> getAllProperties() {
        if (terms == null || terms.size() == 0) {
            return null;
        }
        return terms.stream().map(PropertyTerm::getValue).collect(Collectors.toList());
    }


    public List<Integer> getIndexByValue(String termValue) {
        if (termValue == null || termValue.trim().length() == 0) {
            return null;
        }
        if (terms == null || terms.size() == 0) {
            return null;
        }
        for (PropertyTerm term : terms) {
            if (term.getValue().equals(termValue)) {
                return term.getPosition();
            }
        }
        return null;
    }

    public void addIndexByValue(String termValue, Integer index) {
        if (termValue == null || termValue.trim().length() == 0) {
            return;
        }
        if (terms == null) {
            terms = new ArrayList<>();
        }
        PropertyTerm pTerm = null;
        for (PropertyTerm tTerm : terms) {
            if (tTerm.getValue().equals(termValue)) {
                pTerm = tTerm;
                pTerm.addIndex(index);
                break;
            }
        }
        if (pTerm == null) {
            pTerm = new PropertyTerm(termValue);
            pTerm.addIndex(index);
            terms.add(pTerm);
        }
    }

}
