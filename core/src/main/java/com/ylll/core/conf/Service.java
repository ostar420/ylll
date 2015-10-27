package com.ylll.core.conf;

import java.util.Properties;

public class Service {

    private static Properties properties = Environment.getProperties();

    private Service() {

    }

    public static void reload() {
        Environment.reload();
        properties = Environment.getProperties();
    }

    public static String getProjectLanguage() {
        return properties.getProperty(Environment.PROJECT_LANGUAGE);
    }

    public static String getProjectVersion() {
        return properties.getProperty(Environment.PROJECT_VERSION);
    }

    public static String getJdbDRiverclass() {
        return properties.getProperty(Environment.JDBC_DRIVERCLASS);
    }

    public static String getJdbUrl() {
        return properties.getProperty(Environment.JDBC_URL);
    }

    public static String getJdbUser() {
        return properties.getProperty(Environment.JDBC_USER);
    }

    public static String getJdbcPassword() {
        return properties.getProperty(Environment.JDBC_PASSWORD);
    }

    public static String getMessageOptSuccess() {
        return properties.getProperty(Environment.OPT_SUCCESS);
    }

    public static String getMessageOptError() {
        return properties.getProperty(Environment.OPT_ERROR);
    }

    public static String getMessageValidationSuccess() {
        return properties.getProperty(Environment.VALIDATION_SUCCESS);
    }

    public static String getMessageValidationError() {
        return properties.getProperty(Environment.VALIDATION_ERROR);
    }

    public static String getMessageAccessDenied() {
        return properties.getProperty(Environment.ACCESS_DENIED);
    }

    public static String getMessageExceptionAccessDenied() {
        return properties.getProperty(Environment.EXCEPTION_ACCESS_DENIED);
    }

    public static String getMessageExceptionParameter() {
        return properties.getProperty(Environment.EXCEPTION_PARAMETER);
    }

    public static String getMessageExceptionSystem() {
        return properties.getProperty(Environment.EXCEPTION_SYSTEM);
    }
    public static String getProjectSeq() {
        return properties.getProperty(Environment.PROJECT_SEQ);
    }
    
}
