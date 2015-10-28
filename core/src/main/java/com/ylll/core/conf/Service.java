package com.ylll.core.conf;

import com.ylll.core.util.Common;
import java.util.Properties;

/**
 *
 * @author YL
 */
public class Service {

    private static Properties properties = Environment.getProperties();

    private Service() {

    }

    /**
     *
     */
    public static void reload() {
        Environment.reload();
        properties = Environment.getProperties();
    }

    /**
     *
     * @return
     */
    public static String getProjectLanguage() {
        return properties.getProperty(Environment.PROJECT_LANGUAGE);
    }

    /**
     *
     * @return
     */
    public static String getProjectVersion() {
        return properties.getProperty(Environment.PROJECT_VERSION);
    }

    /**
     *
     * @return
     */
    public static String getJdbDRiverclass() {
        return properties.getProperty(Environment.JDBC_DRIVERCLASS);
    }

    /**
     *
     * @return
     */
    public static String getJdbUrl() {
        return properties.getProperty(Environment.JDBC_URL);
    }

    /**
     *
     * @return
     */
    public static String getJdbUser() {
        return properties.getProperty(Environment.JDBC_USER);
    }

    /**
     *
     * @return
     */
    public static String getJdbcPassword() {
        return properties.getProperty(Environment.JDBC_PASSWORD);
    }

    /**
     *
     * @return
     */
    public static String getMessageOptSuccess() {
        return properties.getProperty(Environment.OPT_SUCCESS);
    }

    /**
     *
     * @return
     */
    public static String getMessageOptError() {
        return properties.getProperty(Environment.OPT_ERROR);
    }

    /**
     *
     * @return
     */
    public static String getMessageValidationSuccess() {
        return properties.getProperty(Environment.VALIDATION_SUCCESS);
    }

    /**
     *
     * @return
     */
    public static String getMessageValidationError() {
        return properties.getProperty(Environment.VALIDATION_ERROR);
    }

    /**
     *
     * @return
     */
    public static String getMessageAccessDenied() {
        return properties.getProperty(Environment.ACCESS_DENIED);
    }

    /**
     *
     * @return
     */
    public static String getMessageExceptionAccessDenied() {
        return properties.getProperty(Environment.EXCEPTION_ACCESS_DENIED);
    }

    /**
     *
     * @return
     */
    public static String getMessageExceptionParameter() {
        return properties.getProperty(Environment.EXCEPTION_PARAMETER);
    }

    /**
     *
     * @return
     */
    public static String getMessageExceptionSystem() {
        return properties.getProperty(Environment.EXCEPTION_SYSTEM);
    }

    /**
     *
     * @return
     */
    public static String getProjectSeq() {
        return properties.getProperty(Environment.PROJECT_SEQ);
    }
    /**
     *读取配置文件 分页行数 
     * 默认返回10
     * @return
     */
    public static int getPageRows() {
        return Common.convertToInt(properties.getProperty(Environment.PAGE_ROWS), 10);
    }
    
}
