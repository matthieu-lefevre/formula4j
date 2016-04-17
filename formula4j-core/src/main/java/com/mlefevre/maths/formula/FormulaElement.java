package com.mlefevre.maths.formula;

public final  class FormulaElement {

    private Operation operation = Operation.UNKNOWN;
    private String value;
    private FormulaElementBounds bounds;

    private FormulaElements children;
    private FormulaElement parent;


    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public FormulaElementBounds getBounds() {
        if(null == bounds) {
            bounds = new FormulaElementBounds();
        }
        return bounds;
    }

    public void setBounds(FormulaElementBounds bounds) {
        this.bounds = bounds;
    }

    public FormulaElements getChildren() {
        return children;
    }

    public void addChild(FormulaElement child) {
        if(null == children) {
            children = new FormulaElements();
        }
        children.push(child);
    }

    public boolean hasChildren() {
        return null != children;
    }

    public FormulaElement getParent() {
        return parent;
    }

    public void setParent(FormulaElement parent) {
        this.parent = parent;
    }

    public boolean hasParent() {
        return null != parent;
    }



}
