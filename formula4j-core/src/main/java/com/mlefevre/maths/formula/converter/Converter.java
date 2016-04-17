package com.mlefevre.maths.formula.converter;

import com.mlefevre.maths.formula.Formula;

public interface Converter {

    String convert(Formula formula) throws ConversionException;

}
