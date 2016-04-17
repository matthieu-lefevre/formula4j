package com.mlefevre.maths.formula.converter.latex.operation;

import com.mlefevre.maths.formula.FormulaElement;

class Root extends BaseOperation {

    public String getTemplate() {
        return "\\sqrt[%s]{%s}";
    }

    public void process(FormulaElement element) {
        processChildren(element);
        element.setValue(String.format(
                getTemplate(),
                element.getBounds().getUpper(),
                element.getValue()
        ));
    }
}
