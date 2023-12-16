package esi.atl.turingmachine.model.validators;

import esi.atl.turingmachine.model.Code;
import esi.atl.turingmachine.model.TuringException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorCountTest {

    @Test
    void validateCount() throws TuringException {
        ValidatorCount validator = new ValidatorCount(2);
        Code code = new Code(123);
        assertTrue(validator.validate(code, new Code(123)));
        assertFalse(validator.validate(code, new Code(424)));
        assertFalse(validator.validate(code, new Code(324)));
    }



}