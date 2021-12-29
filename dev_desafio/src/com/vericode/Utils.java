package com.vericode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private List<BigDecimal> elements = new ArrayList<>();
    private int numberOfElements;

    public Utils(List<BigDecimal> elements) {
        this.elements = elements;
        this.numberOfElements = elements.size();
    }

    public BigDecimal sumElementsFromList(List<BigDecimal> elements){
        BigDecimal total = BigDecimal.ZERO;
        elements.forEach(e -> total.add(e));
        return total;
    }

    public BigDecimal average() {
        BigDecimal value = sumElementsFromList(elements);
        return value.divide(new BigDecimal(numberOfElements));
    }

    public BigDecimal standardDeviation() {
        BigDecimal avg = average();
        BigDecimal stdDeviation = BigDecimal.ZERO;

        this.elements.forEach(e -> {
            BigDecimal aux = e.subtract(avg);
            stdDeviation.add(aux.multiply(aux));
        });

        return new BigDecimal(Math.sqrt(stdDeviation.divide(new BigDecimal(numberOfElements)).doubleValue()));
    }
}
