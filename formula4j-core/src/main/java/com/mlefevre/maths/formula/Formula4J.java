package com.mlefevre.maths.formula;

import com.mlefevre.maths.formula.converter.ConversionException;
import com.mlefevre.maths.formula.converter.Converter;
import com.mlefevre.maths.formula.parser.Parser;
import com.mlefevre.maths.formula.parser.ParsingException;

public final class Formula4J {

    private Parser parser;
    private Converter converter;


    public Formula4J(Parser parser, Converter converter) {
        this.parser = parser;
        this.converter = converter;
    }


    public String build(String input) {
        String output = null;
        try {
            Formula formula = parser.parse(input);
            output = converter.convert(formula);
        } catch(ParsingException | ConversionException e) {
            e.printStackTrace();
        }
        return output;
    }

}
