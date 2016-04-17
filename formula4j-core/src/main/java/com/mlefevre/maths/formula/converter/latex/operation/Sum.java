package com.mlefevre.maths.formula.converter.latex.operation;

import com.mlefevre.maths.formula.FormulaElement;

class Sum extends BaseOperation {

    public String getTemplate() {
        return "{%s}+{%s}";
    }

    public void process(FormulaElement element) {
        FormulaElement term2 = element.getChildren().pop();
        processChildren(term2);
        OperationFactory.get(term2.getOperation()).process(term2);

        FormulaElement term1 = element.getChildren().pop();
        processChildren(term1);
        OperationFactory.get(term1.getOperation()).process(term1);

        element.setValue(String.format(
                getTemplate(),
                term1.getValue(), term2.getValue()
        ));
    }
}
