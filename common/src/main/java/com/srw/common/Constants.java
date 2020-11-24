package com.srw.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 常量类
 * @Author: songrenwei
 * @Date: 2020/10/14/15:15
 */
public class Constants {
    public static String RESULT_SUCCESS_CODE = "10000";
    public static String RESULT_ERROR_CODE = "10001";

    /**
     * 自定义异常code
     */
    public static Map EXCEPTION_CODE_MAP = new HashMap<String, String>(100) {
        private static final long serialVersionUID = 5089868132306478837L;

        {
            put("BusinessException", "20000");
        }
    };
}
