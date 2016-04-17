package com.mlefevre.maths.formula.converter.latex.operation;

import com.mlefevre.maths.formula.FormulaElement;

class SquareRoot extends BaseOperation {

    public String getTemplate() {
        return "\\sqrt{%1s}";
    }

    public void process(FormulaElement element) {
        processChildren(element);
        element.setValue(String.format(
                getTemplate(),
                element.getValue()
        ));
    }
}
