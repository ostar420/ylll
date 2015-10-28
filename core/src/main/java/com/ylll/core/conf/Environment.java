package com.ylll.core.conf;

import com.ylll.core.util.Common;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统参数
 *
 * @author YL
 */
public final class Environment {

    /**
     *
     */
    public static final String CONF_PATH = Common.FILE_SEPARATOR + "config.properties";

    /**
     *
     */
    public static final String MESSAGE_DIR = Common.FILE_SEPARATOR + "messages";

    private static final Properties GLOBAL_PROPERTIES;

    private static final Logger log = LoggerFactory.getLogger(Environment.class);

    /**
     *
     */
    public static final String PROJECT_LANGUAGE = "project.language";

    /**
     *
     */
    public static final String PROJECT_VERSION = "project.version";

    /**
     *
     */
    public static final String JDBC_DRIVERCLASS = "jdbc.driverClass";

    /**
     *
     */
    public static final String JDBC_URL = "jdbc.url";

    /**
     *
     */
    public static final String JDBC_USER = "jdbc.user";

    /**
     *
     */
    public static final String JDBC_PASSWORD = "jdbc.password";
    
    /**
     *
     */
    public static final String PROJECT_SEQ = "project.seq";
    //messages

    /**
     *
     */
        public static final String OPT_SUCCESS = "opt.success";

    /**
     *
     */
    public static final String OPT_ERROR = "opt.error";

    /**
     *
     */
    public static final String VALIDATION_SUCCESS = "validation.success";

    /**
     *
     */
    public static final String VALIDATION_ERROR = "validation.error";

    /**
     *
     */
    public static final String ACCESS_DENIED = "access.denied";

    /**
     *
     */
    public static final String EXCEPTION_ACCESS_DENIED = "exception.access.denied";

    /**
     *
     */
    public static final String EXCEPTION_PARAMETER = "exception.parameter";

    /**
     *
     */
    public static final String EXCEPTION_SYSTEM = "exception.system";
    
    /**
     *
     */
    public static final String PAGE_ROWS = "page.rows";
    

    static {
        GLOBAL_PROPERTIES = new Properties();
        init();
    }

    private Environment() {
    }

    /**
     *
     */
    public static void reload() {
        init();
    }

    /**
     *
     * @return
     */
    public static Properties getProperties() {
        Properties copy = new Properties();
        copy.putAll(GLOBAL_PROPERTIES);
        return copy;
    }

    private static void init() {
        InputStream conf_stream = Environment.class.getClassLoader().getResourceAsStream(CONF_PATH);
        if (conf_stream == null) {
            log.info(CONF_PATH + "not found");
            return;
        }

        try {
            GLOBAL_PROPERTIES.load(conf_stream);
            log.info("loaded properties from resource " + CONF_PATH + ": " + GLOBAL_PROPERTIES);
        }
        catch (IOException ex) {
            log.error("problem loading properties from " + CONF_PATH);
        }
        finally {
            try {
                conf_stream.close();
            }
            catch (IOException ioe) {
                log.error("could not close stream on " + CONF_PATH + "", ioe);
            }
        }

        String project_languang = GLOBAL_PROPERTIES.getProperty(PROJECT_LANGUAGE);

        String messages_path = MESSAGE_DIR + Common.FILE_SEPARATOR + "messages_" + project_languang + ".properties";

        InputStream messages_stream = Environment.class.getClassLoader().getResourceAsStream(messages_path);
        if (messages_stream == null) {
            log.info(messages_path + " not found");
            return;
        }

        try {
            GLOBAL_PROPERTIES.load(messages_stream);
            log.info("loaded properties from resource " + messages_path + ": "
                    + GLOBAL_PROPERTIES);
        }
        catch (Exception e) {
            log.error("problem loading properties from " + messages_path);
        }
        finally {
            try {
                messages_stream.close();
            }
            catch (IOException ioe) {
                log.error("could not close stream on " + messages_path, ioe);
            }
        }

        GLOBAL_PROPERTIES.putAll(System.getProperties());

    }

}
