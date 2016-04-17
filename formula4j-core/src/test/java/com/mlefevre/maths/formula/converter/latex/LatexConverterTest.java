package com.mlefevre.maths.formula.converter.latex;

import com.mlefevre.maths.formula.Formula;
import com.mlefevre.maths.formula.FormulaElement;
import com.mlefevre.maths.formula.Operation;
import com.mlefevre.maths.formula.converter.Converter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LatexConverterTest {

    private Converter converter = LatexConverter.getInstance();


    @Test
    public void should_not_convert_plain_text() {
        Formula formula = new Formula();
        FormulaElement component = new FormulaElement();
        component.setValue("sin(x)");
        formula.push(component);

        String output = converter.convert(formula);

        assertEquals("sin(x)", output);
    }

    @Test
    public void should_convert_big_sum() {
        Formula formula = new Formula();
        FormulaElement component = new FormulaElement();
        component.setOperation(Operation.SUM);
        component.getBounds().setLower("i=0");
        component.getBounds().setUpper("N");
        component.setValue("i");
        formula.push(component);

        String output = converter.convert(formula);

        assertEquals("\\sum_{i=0}^{N}{i}", output);
    }

    @Test
    public void should_convert_big_product() {
        Formula formula = new Formula();
        FormulaElement component = new FormulaElement();
        component.setOperation(Operation.PRODUCT);
        component.getBounds().setLower("i=0");
        component.getBounds().setUpper("N");
        component.setValue("i");
        formula.push(component);

        String output = converter.convert(formula);

        assertEquals("\\prod_{i=0}^{N}{i}", output);
    }

    @Test
    public void should_convert_root() {
        Formula formula = new Formula();
        FormulaElement component = new FormulaElement();
        component.setOperation(Operation.ROOT);
        component.getBounds().setUpper("3");
        component.setValue("x");
        formula.push(component);

        String output = converter.convert(formula);

        assertEquals("\\sqrt[3]{x}", output);
    }

    @Test
    public void should_convert_square_root() {
        Formula formula = new Formula();
        FormulaElement component = new FormulaElement();
        component.setOperation(Operation.SQUARE_ROOT);
        component.setValue("x");
        formula.push(component);

        String output = converter.convert(formula);

        assertEquals("\\sqrt{x}", output);
    }

    @Test
    public void should_convert_integral() {
        Formula formula = new Formula();
        FormulaElement component = new FormulaElement();
        component.setOperation(Operation.INTEGRAL);
        component.getBounds().setLower("i=0");
        component.getBounds().setUpper("N");
        component.setValue("i");
        formula.push(component);

        String output = converter.convert(formula);

        assertEquals("\\int_{i=0}^{N}{i}", output);
    }

    @Test
    public void should_convert_arithmetical_sum() {
        Formula formula = new Formula();
        FormulaElement component = new FormulaElement();
        component.setOperation(Operation.ARITHMETICAL_SUM);
        FormulaElement term1 = new FormulaElement();
        term1.setValue("X");
        component.addChild(term1);
        FormulaElement term2 = new FormulaElement();
        term2.setValue("Y");
        component.addChild(term2);
        formula.push(component);

        String output = converter.convert(formula);

        assertEquals("{X}+{Y}", output);
    }

    @Test
    public void should_convert_arithmetical_product() {
        Formula formula = new Formula();
        FormulaElement component = new FormulaElement();
        component.setOperation(Operation.ARITHMETICAL_PRODUCT);
        FormulaElement term1 = new FormulaElement();
        term1.setValue("X");
        component.addChild(term1);
        FormulaElement term2 = new FormulaElement();
        term2.setValue("Y");
        component.addChild(term2);
        formula.push(component);

        String output = converter.convert(formula);

        assertEquals("{X}\\times{Y}", output);
    }

    @Test
    public void should_convert_arithmetical_division() {
        Formula formula = new Formula();
        FormulaElement component = new FormulaElement();
        component.setOperation(Operation.ARITHMETICAL_DIVISION);
        FormulaElement term1 = new FormulaElement();
        term1.setValue("X");
        component.addChild(term1);
        FormulaElement term2 = new FormulaElement();
        term2.setValue("Y");
        component.addChild(term2);
        formula.push(component);

        String output = converter.convert(formula);

        assertEquals("\\frac{X}{Y}", output);
    }

    @Test
    public void should_convert_arithmetical_subtraction() {
        Formula formula = new Formula();
        FormulaElement component = new FormulaElement();
        component.setOperation(Operation.ARITHMETICAL_SUBTRACTION);
        FormulaElement term1 = new FormulaElement();
        term1.setValue("X");
        component.addChild(term1);
        FormulaElement term2 = new FormulaElement();
        term2.setValue("Y");
        component.addChild(term2);
        formula.push(component);

        String output = converter.convert(formula);

        assertEquals("{X}-{Y}", output);
    }

    @Test
    public void should_convert_complex_formula() {
        Formula formula = new Formula();
        FormulaElement component = new FormulaElement();
        component.setOperation(Operation.SUM);
        component.getBounds().setLower("i=0");
        component.getBounds().setUpper("N");

        FormulaElement term1 = new FormulaElement();
        term1.setOperation(Operation.ARITHMETICAL_PRODUCT);
        FormulaElement productTerm1 = new FormulaElement();
        productTerm1.setValue("X");
        term1.addChild(productTerm1);
        FormulaElement productTerm2 = new FormulaElement();
        productTerm2.setValue("i");
        term1.addChild(productTerm2);
        component.addChild(term1);
        formula.push(component);

        String output = converter.convert(formula);

        assertEquals("\\sum_{i=0}^{N}{{X}\\times{i}}", output);
    }

    @Test
    public void should_convert_complex_formula2() {
        Formula formula = new Formula();
        FormulaElement component = new FormulaElement();
        component.setOperation(Operation.ARITHMETICAL_PRODUCT);

        FormulaElement term1 = new FormulaElement();
        term1.setValue("X");
        component.addChild(term1);

        FormulaElement term2 = new FormulaElement();
        term2.setOperation(Operation.SUM);
        term2.getBounds().setLower("i=0");
        term2.getBounds().setUpper("N");
        term2.setValue("i");
        component.addChild(term2);

        formula.push(component);

        String output = converter.convert(formula);

        assertEquals("{X}\\times{\\sum_{i=0}^{N}{i}}", output);
    }

}
