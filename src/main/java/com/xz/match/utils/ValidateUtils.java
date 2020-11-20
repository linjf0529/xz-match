package com.xz.match.utils;

import com.xz.match.utils.exception.CommonException;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: xz-match
 * @description:
 * @author: Linjf
 * @create date: 2020-11-17 10:02
 **/
public class ValidateUtils {
    public ValidateUtils() {
    }

    public static void isTrue(boolean expression, int code) {
        isTrue(expression, code, "The validated expression is false");
    }

    public static void isTrue(boolean expression, int code, String message) {
        if (!expression) {
            throw new CommonException(code, message);
        }
    }


    public static void isFalse(boolean expression, int code) {
        isTrue(expression, code, "The validated expression is false");
    }

    public static void isFalse(boolean expression, int code, String message) {
        if (expression) {
            throw new CommonException(code, message);
        }
    }



    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new CommonException(message);
        }
    }

    public static void notNull(Object object, int code) {
        notNull(object, code, "The validated object is null");
    }

    public static void notNull(Object object, int code, String message) {
        if (object == null) {
            throw new CommonException(code, message);
        }
    }

    /** @deprecated */
    @Deprecated
    public static void notNull(Object object) {
        notNull(object, 10100);
    }

    public static void notEmpty(Collection collection, int code) {
        notEmpty(collection, code, "The validated collection is empty");
    }

    public static void notEmpty(Collection collection, int code, String message) {
        if (collection == null || collection.size() == 0) {
            throw new CommonException(code, message);
        }
    }

    /** @deprecated */
    @Deprecated
    public static void notEmpty(Collection collection) {
        notEmpty((Collection)collection, 10101);
    }

    public static boolean notEmpty(Map map, int code) {
        return notEmpty(map, code, "The validated map is empty");
    }

    public static boolean notEmpty(Map map, int code, String message) {
        if (map != null && map.size() != 0) {
            return true;
        } else {
            throw new CommonException(code, message);
        }
    }

    /** @deprecated */
    @Deprecated
    public static boolean notEmpty(Map map) {
        if (map != null && map.size() != 0) {
            return true;
        } else {
            throw new IllegalArgumentException("The validated map is empty");
        }
    }

    public static void notEmpty(String string, int code) {
        notEmpty(string, code, "The validated string is empty");
    }

    public static void notEmpty(String string, int code, String message) {
        if (string == null || string.trim().length() == 0) {
            throw new CommonException(code, message);
        }
    }

    /** @deprecated */
    @Deprecated
    public static void notEmpty(String string) {
        notEmpty((String)string, 10101);
    }

    public static void noNullElements(Object[] array, int code) {
        noNullElements(array, code, "The validated array contains null element at index: ");
    }

    public static void noNullElements(Object[] array, int code, String message) {
        notNull(array, code);

        for(int i = 0; i < array.length; ++i) {
            if (array[i] == null) {
                throw new CommonException(code, message + i);
            }
        }

    }


    public static void noNullElements(Collection collection, int code) {
        noNullElements(collection, code, "The validated collection contains null element at index: ");
    }

    public static void noNullElements(Collection collection, int code, String message) {
        notNull(collection, code);
        int i = 0;

        for(Iterator it = collection.iterator(); it.hasNext(); ++i) {
            if (it.next() == null) {
                throw new CommonException(code, message + i);
            }
        }

    }

    public static void allElementsOfType(Collection collection, Class clazz, int code) {
        notNull(collection, code);
        notNull(clazz, code);
        int i = 0;

        for(Iterator it = collection.iterator(); it.hasNext(); ++i) {
            if (!clazz.isInstance(it.next())) {
                throw new CommonException(code, "The validated collection contains an element not of type " + clazz.getName() + " at index: " + i);
            }
        }

    }

    public static void allElementsOfType(Collection collection, Class clazz, int code, String message) {
        notNull(collection, code);
        notNull(clazz, code);
        int i = 0;

        for(Iterator it = collection.iterator(); it.hasNext(); ++i) {
            if (!clazz.isInstance(it.next())) {
                throw new CommonException(code, message + "; " + clazz.getName() + " at index: " + i);
            }
        }

    }

    public static void eq(String string, int len, int code) {
        int length = StringUtils.msNull(string).length();
        if (length != len) {
            throw new CommonException(code, "The validated string length is " + length + ", expect length is " + length);
        }
    }

    public static void min(String string, int min, int code) {
        int length = StringUtils.msNull(string).length();
        if (length < min) {
            throw new CommonException(code, "The validated string length is " + length + ", min length is " + length);
        }
    }

    public static void max(String string, int max, int code) {
        int length = StringUtils.msNull(string).length();
        if (length > max) {
            throw new CommonException(code, "The validated string length is " + length + ", max length is " + length);
        }
    }

    public static void min(int value, int min, int code) {
        if (value < min) {
            throw new CommonException(code, "The validated value is " + value + ", min is " + min);
        }
    }

    public static void max(int value, int max, int code) {
        if (value > max) {
            throw new CommonException(code, "The validated value is " + value + ", max is " + max);
        }
    }
}
