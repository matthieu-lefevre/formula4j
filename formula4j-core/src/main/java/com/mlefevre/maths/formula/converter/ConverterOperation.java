package com.mlefevre.maths.formula.converter;

import com.mlefevre.maths.formula.FormulaElement;

public interface ConverterOperation {

    String getTemplate();

    void process(FormulaElement element);

}
