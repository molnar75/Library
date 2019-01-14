package hu.simplesoft.dualis.library.data.validator;

import hu.simplesoft.dualis.library.exception.IsNullException;

public class ObjectValidator {

    public static void entityIsNull(Object object, long searchedEntityId) throws IsNullException {
        if(object == null) {
            new IsNullException("Object is null! Id: " + searchedEntityId);
        }
    }
}
