package com.mlefevre.maths.formula;

public final class Formula {

    private FormulaElements components;


    public FormulaElements getComponents() {
        return components;
    }

    public void push(FormulaElement component) {
        if(null == components) {
            components = new FormulaElements();
        }
        components.push(component);
    }

    public FormulaElement pop() {
        if(null == components) {
            return null;
        }
        return components.pop();
    }

}
