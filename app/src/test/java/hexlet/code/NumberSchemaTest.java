package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public final class NumberSchemaTest {
    private NumberSchema numberSchema;
    private Validator validator;

    @BeforeEach
    public void beforeEach() {
        validator = new Validator();
        numberSchema = validator.number();
    }

    @Test
    public void requiredTest() {
        assertTrue(numberSchema.isValid(null));
        numberSchema.required();
        assertFalse(numberSchema.isValid(null));
    }

    @Test
    public void positiveTest() {
        numberSchema.positive();
        assertTrue(numberSchema.isValid(10));
        assertFalse(numberSchema.isValid(-10));
        assertTrue(numberSchema.isValid(null));
    }

    @Test
    public void rangeTest() {
        assertTrue(numberSchema.range(5, 10).isValid(5));
        assertTrue(numberSchema.range(-3, -7).isValid(-5));
        assertTrue(numberSchema.isValid(null));
    }
}
