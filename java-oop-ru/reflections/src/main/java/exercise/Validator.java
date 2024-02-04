package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address obj) {
        List<String> result = new ArrayList<>();
        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (var field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(obj) == null && field.isAnnotationPresent(NotNull.class)) {
                    result.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public static Map<String, List<String>>  advancedValidate(Address obj) {
        String nullErrMsg = "can not be null";
        String minLengthErrMsg = "length less than ";
        Map<String, List<String>> result = new HashMap<>();
        List<String> resultList = new ArrayList<>();

        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for (var field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class) && field.get(obj) == null) {
                    resultList.add(nullErrMsg);
                    result.put(field.getName(), resultList);
                }
                if (field.isAnnotationPresent(MinLength.class)) {
                    MinLength minLength = field.getAnnotation(MinLength.class);
                    var value = (String) field.get(obj);
                    var givenMinLength = minLength.minLength();
                    if (givenMinLength > String.valueOf(value).length()) {
                        var errMsg = minLengthErrMsg + minLength.minLength();
                        resultList.add(errMsg);
                        result.put(field.getName(), resultList);
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
// END
