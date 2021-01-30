package edu.epam.cafe.validator;

public interface Validator<T> {

    boolean validate(T t);
}
