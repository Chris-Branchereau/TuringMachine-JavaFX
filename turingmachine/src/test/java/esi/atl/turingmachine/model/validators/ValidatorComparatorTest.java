package esi.atl.turingmachine.model.validators;

import esi.atl.turingmachine.model.Code;
import esi.atl.turingmachine.model.TuringException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ValidatorComparatorTest {

    @Test
    void validateCompararator1() throws TuringException {
        ValidatorComparator validator = new ValidatorComparator(1);
        Code code = new Code(123);
        assertTrue(validator.validate(code, new Code(123)));
        assertFalse(validator.validate(code, new Code(451)));
    }

    @Test
    void validateCompararator2() throws TuringException {
        ValidatorComparator validator = new ValidatorComparator(2);
        Code code = new Code(123);
        assertTrue(validator.validate(code, new Code(123)));
        assertFalse(validator.validate(code, new Code(424)));
        assertFalse(validator.validate(code, new Code(324)));
    }

    @Test
    void validateCompararator3() throws TuringException {
        ValidatorComparator validator = new ValidatorComparator(3);
        Code code = new Code(444);
        assertTrue(validator.validate(code, new Code(555)));
        assertFalse(validator.validate(code, new Code(132)));
        assertFalse(validator.validate(code, new Code(421)));
    }
    @Test
    void validateCompararator4() throws TuringException {
        ValidatorComparator validator = new ValidatorComparator(4);
        Code code = new Code(444);
        assertTrue(validator.validate(code, new Code(541)));
        assertFalse(validator.validate(code, new Code(132)));
        assertFalse(validator.validate(code, new Code(152)));
    }
    @Test
    void validateCompararator19() throws TuringException {
        ValidatorComparator validator = new ValidatorComparator(19);
        Code code = new Code(444);
        assertTrue(validator.validate(code, new Code(541)));
        assertFalse(validator.validate(code, new Code(132)));
        assertFalse(validator.validate(code, new Code(152)));
    }
}