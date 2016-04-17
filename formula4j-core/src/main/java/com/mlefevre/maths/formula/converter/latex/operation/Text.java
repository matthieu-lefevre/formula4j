package com.mlefevre.maths.formula.converter.latex.operation;

import com.mlefevre.maths.formula.FormulaElement;

public class Text extends BaseOperation {

    public String getTemplate() {
        return "%s";
    }

    public void process(FormulaElement element) {
        element.setValue(String.format(
                getTemplate(),
                element.getValue()
        ));
    }
}
