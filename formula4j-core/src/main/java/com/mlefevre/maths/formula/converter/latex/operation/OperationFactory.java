package com.mlefevre.maths.formula.converter.latex.operation;

import com.mlefevre.maths.formula.Operation;
import com.mlefevre.maths.formula.converter.ConverterOperation;

import java.util.HashMap;
import java.util.Map;

public final class OperationFactory {

    private static Map<Operation, ConverterOperation> operations = new HashMap<>();
    static {
        operations.put(Operation.UNKNOWN, new Text());
        operations.put(Operation.ARITHMETICAL_SUM, new Sum());
        operations.put(Operation.ARITHMETICAL_PRODUCT, new Product());
        operations.put(Operation.ARITHMETICAL_SUBTRACTION, new Subtraction());
        operations.put(Operation.ARITHMETICAL_DIVISION, new Division());
        operations.put(Operation.SUM, new BigSum());
        operations.put(Operation.PRODUCT, new BigProduct());
        operations.put(Operation.INTEGRAL, new Integral());
        operations.put(Operation.SQUARE_ROOT, new SquareRoot());
        operations.put(Operation.ROOT, new Root());
    }


    public static ConverterOperation get(Operation operation) {
        return operations.get(operation);
    }


}
