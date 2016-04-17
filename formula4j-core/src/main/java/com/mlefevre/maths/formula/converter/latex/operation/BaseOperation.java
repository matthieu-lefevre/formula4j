package com.mlefevre.maths.formula.converter.latex.operation;

import com.mlefevre.maths.formula.FormulaElement;
import com.mlefevre.maths.formula.FormulaElements;
import com.mlefevre.maths.formula.converter.ConverterOperation;

abstract class BaseOperation implements ConverterOperation {

    protected void processChildren(FormulaElement parent) {
        if(!parent.hasChildren()) {
            return;
        }
        FormulaElements elements = parent.getChildren();
        StringBuilder builder = new StringBuilder("");
        while (elements.hasNext()) {
            FormulaElement next = elements.next();
            OperationFactory.get(next.getOperation()).process(next);
            builder.append(next.getValue());
        }
        parent.setValue(builder.toString());
    }

}
