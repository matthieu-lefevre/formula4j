package com.mlefevre.maths.formula.converter.latex.operation;

import com.mlefevre.maths.formula.FormulaElement;

class Integral extends BaseOperation {

    public String getTemplate() {
        return "\\int_{%s}^{%s}{%s}";
    }

    public void process(FormulaElement element) {
        processChildren(element);
        element.setValue(String.format(
                getTemplate(),
                element.getBounds().getLower(), element.getBounds().getUpper(),
                element.getValue()
        ));
    }

}
