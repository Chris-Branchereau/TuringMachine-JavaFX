package esi.atl.turingmachine.model.validators;

import esi.atl.turingmachine.model.Code;
import esi.atl.turingmachine.model.TuringException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorComparator2Test {

    @Test
    void validateCompararator11() throws TuringException {
        ValidatorComparator2 validator = new ValidatorComparator2(11);
        Code code = new Code(123);
        assertTrue(validator.validate(code, new Code(353)));
        assertFalse(validator.validate(code, new Code(543)));
        assertFalse(validator.validate(code, new Code(223)));
    }

    @Test
    void validateCompararator12() throws TuringException {
        ValidatorComparator2 validator = new ValidatorComparator2(12);
        Code code = new Code(123);
        assertTrue(validator.validate(code, new Code(123)));
        assertFalse(validator.validate(code, new Code(424)));
        assertFalse(validator.validate(code, new Code(322)));
    }

    @Test
    void validateCompararator13() throws TuringException {
        ValidatorComparator2 validator = new ValidatorComparator2(13);
        Code code = new Code(444);
        assertTrue(validator.validate(code, new Code(555)));
        assertFalse(validator.validate(code, new Code(132)));
        assertFalse(validator.validate(code, new Code(421)));
    }


    
}