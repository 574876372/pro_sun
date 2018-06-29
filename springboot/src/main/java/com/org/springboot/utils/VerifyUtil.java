package com.org.springboot.utils;

import com.org.springboot.enums.ErrorMsgEnum;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


/**
 * 请求参数验证工具类
 * 验证失败，抛异常
 * Created by paopaobing on 16/9/6.
 */
//@Slf4j
public class VerifyUtil {

    private final static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    /**
     * 请求参数非空、格式验证，请求对象
     *
     * @param object
     * @throws BusinessServiceException
     */
    public static void validateObject(Object object) throws BusinessServiceException{
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        if (violations.size() == 0) {
            return;
        }
        for (ConstraintViolation<Object> violation : violations) {
            throw new BusinessServiceException(ErrorMsgEnum.ERROR_CODE_0002.getCode(), violation.getMessage());
        }
    }

    /**
     * 多个对象 请求参数非空、格式验证，请求对象
     *
     * @param objects
     * @throws BusinessServiceException
     */
    public static void validateObjects(Object... objects) throws BusinessServiceException {
        for (Object obj : objects) {
            validateObject(obj);
        }
    }

    /**
     * 请求参数校验 指定属性
     *
     * @param object
     * @param propertys
     * @throws BusinessServiceException
     */
    public static void validateProperty(Object object, String... propertys) throws BusinessServiceException{
        Validator validator = factory.getValidator();
        for (String property : propertys) {
            Set<ConstraintViolation<Object>> violations = validator.validateProperty(object, property);
            if (violations.size() == 0) {
                continue;
            }
            for (ConstraintViolation<Object> violation : violations) {
                throw new BusinessServiceException(ErrorMsgEnum.ERROR_CODE_0002.getCode(), violation.getMessage());
            }
        }
    }

}


