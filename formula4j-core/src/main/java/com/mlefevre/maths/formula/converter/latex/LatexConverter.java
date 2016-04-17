package com.mlefevre.maths.formula.converter.latex;

import com.mlefevre.maths.formula.Formula;
import com.mlefevre.maths.formula.FormulaElement;
import com.mlefevre.maths.formula.FormulaElements;
import com.mlefevre.maths.formula.converter.ConversionException;
import com.mlefevre.maths.formula.converter.Converter;
import com.mlefevre.maths.formula.converter.ConverterOperation;
import com.mlefevre.maths.formula.converter.latex.operation.OperationFactory;

public class LatexConverter implements Converter {

    private static LatexConverter instance;

    private LatexConverter() {

    }

    public synchronized static LatexConverter getInstance() {
        if(null == instance) {
            instance = new LatexConverter();
        }
        return instance;
    }

    public String convert(Formula formula) throws ConversionException {
        StringBuilder output = new StringBuilder();
        FormulaElements components = formula.getComponents();
        while(components.hasNext()) {
            FormulaElement component = components.next();
            OperationFactory.get(component.getOperation()).process(component);
            output.append(component.getValue());
        }
        return output.toString();
    }
}
