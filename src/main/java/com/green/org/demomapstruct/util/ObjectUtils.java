package com.green.org.demomapstruct.util;

import java.util.Collection;
import java.util.Objects;

public class ObjectUtils {
   /**
    * Utility classes, which are collections of static members,
    * are not meant to be instantiated
    */
    private ObjectUtils(){
        throw new IllegalStateException("Utility class");
    }

    /**
     * Check whether an object is a non-collection or not.
     */
    public static boolean isNonCollection(Object obj) {
        return !(obj instanceof Collection);
    }

    /**
     * Check whether an object is a collection or not.
     */
    public static boolean isCollection(Object obj) {
        return obj instanceof Collection;
    }

    /**
     * Check whether an object is a not empty collection, or not.
     */
    public static boolean isNonEmptyCollection(Object obj) {
        return isCollection(obj) && !((Collection) obj).isEmpty();
    }

    /**
     * Check whether an object is null or not.
     */
    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }

    /**
     * Check whether an object is non-null, or not.
     */
    public static boolean isNotNull(Object obj) {
        return !Objects.isNull(obj);
    }

    /**
     * Check whether an object is a null or non-empty collection.
     */
    public static boolean isNullOrEmpty(Object obj) {
        return isNull(obj)|| (isCollection(obj) && ((Collection) obj).isEmpty());
    }
}
