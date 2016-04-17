package com.mlefevre.maths.formula.converter.latex.operation;

import com.mlefevre.maths.formula.FormulaElement;
import com.mlefevre.maths.formula.FormulaElements;
import com.mlefevre.maths.formula.converter.ConverterOperation;

class Integral implements ConverterOperation {

    public String getTemplate() {
        return "\\int_{%s}^{%s}{%s}";
    }

    public void process(FormulaElement element) {
        if(element.hasChildren()) {
            FormulaElements elements = element.getChildren();
            StringBuilder builder = new StringBuilder("");
            while(elements.hasNext()) {
                FormulaElement next = elements.next();
                OperationFactory.get(next.getOperation()).process(next);
                builder.append(next.getValue());
            }
            element.setValue(builder.toString());
        }
        element.setValue(String.format(
                getTemplate(),
                element.getBounds().getLower(), element.getBounds().getUpper(),
                element.getValue()
        ));
    }

}
