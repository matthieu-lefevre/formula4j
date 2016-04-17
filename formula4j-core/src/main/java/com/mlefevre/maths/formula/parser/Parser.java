package com.mlefevre.maths.formula.parser;

import com.mlefevre.maths.formula.Formula;

public interface Parser {

    Formula parse(String input) throws ParsingException;

}
