package com.mlefevre.maths.formula.converter.latex.operation;

import com.mlefevre.maths.formula.FormulaElement;
import com.mlefevre.maths.formula.FormulaElements;
import com.mlefevre.maths.formula.converter.ConverterOperation;

class Product implements ConverterOperation {

    public String getTemplate() {
        return "{%s}\\times{%s}";
    }

    public void process(FormulaElement element) {
        FormulaElement term2 = element.getChildren().pop();
        if(term2.hasChildren()) {
            FormulaElements elements = term2.getChildren();
            StringBuilder builder = new StringBuilder("");
            while(elements.hasNext()) {
                FormulaElement next = elements.next();
                OperationFactory.get(next.getOperation()).process(next);
                builder.append(next.getValue());
            }
            term2.setValue(builder.toString());
        }
        OperationFactory.get(term2.getOperation()).process(term2);

        FormulaElement term1 = element.getChildren().pop();
        if(term1.hasChildren()) {
            FormulaElements elements = term1.getChildren();
            StringBuilder builder = new StringBuilder("");
            while(elements.hasNext()) {
                FormulaElement next = elements.next();
                OperationFactory.get(next.getOperation()).process(next);
                builder.append(next.getValue());
            }
            term1.setValue(builder.toString());
        }
        OperationFactory.get(term1.getOperation()).process(term1);

        element.setValue(String.format(
                getTemplate(),
                term1.getValue(), term2.getValue()
        ));
    }
}
