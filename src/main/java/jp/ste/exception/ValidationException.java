package jp.ste.exception;

import java.util.List;

/**
 * Thrown if an instruction is not valid. Contains messages about missing field or wrong values
 * Created by Stefano Formaggi on 29/06/17.
 */
public class ValidationException extends Exception {
    private final List<String> errors;

    public ValidationException(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
