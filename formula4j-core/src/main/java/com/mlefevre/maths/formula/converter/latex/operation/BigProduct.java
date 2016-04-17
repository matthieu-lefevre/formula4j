package com.mlefevre.maths.formula.converter.latex.operation;

import com.mlefevre.maths.formula.FormulaElement;

class BigProduct extends BaseOperation {

    public String getTemplate() {
        return "\\prod_{%s}^{%s}{%s}";
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
