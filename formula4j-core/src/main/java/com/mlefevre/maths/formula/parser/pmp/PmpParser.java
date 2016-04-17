package com.mlefevre.maths.formula.parser.pmp;

import com.mlefevre.maths.formula.Formula;
import com.mlefevre.maths.formula.parser.Parser;
import com.mlefevre.maths.formula.parser.ParsingException;

public class PmpParser implements Parser {

    private static PmpParser instance;

    private PmpParser() {

    }

    public synchronized static PmpParser getInstance() {
        if(null == instance) {
            instance = new PmpParser();
        }
        return instance;
    }


    public Formula parse(String input) throws ParsingException {
        return null;
    }
}
