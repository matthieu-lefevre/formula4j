package com.mlefevre.maths.formula;

import java.util.ArrayList;
import java.util.List;

public final class FormulaElements {

    private int currentIndex = 0;

    private List<FormulaElement> elements = new ArrayList<>();


    public boolean hasNext() {
        return currentIndex < elements.size();
    }

    public FormulaElement next() {
        if(!hasNext()) {
            return null;
        }
        FormulaElement currentElement = elements.get(currentIndex);
        currentIndex++;
        return currentElement;
    }

    public FormulaElement pop() {
        if(null == elements || elements.isEmpty()) {
            return null;
        }
        int lastIndex = elements.size() - 1;
        FormulaElement lastElement = elements.get(lastIndex);
        elements.remove(lastIndex);
        return lastElement;
    }

    public void push(FormulaElement element) {
        if(null == elements) {
            elements = new ArrayList<>();
        }
        elements.add(element);
    }

}
