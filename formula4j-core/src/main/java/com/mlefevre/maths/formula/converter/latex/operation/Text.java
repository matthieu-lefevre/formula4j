package com.mlefevre.maths.formula.converter.latex.operation;

import com.mlefevre.maths.formula.FormulaElement;
import com.mlefevre.maths.formula.converter.ConverterOperation;

public class Text implements ConverterOperation {

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
