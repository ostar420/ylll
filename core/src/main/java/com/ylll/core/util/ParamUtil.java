package com.ylll.core.util;

import com.ylll.core.annotation.ParamVali;
import com.ylll.core.conf.Environment;
import com.ylll.core.conf.Service;
import com.ylll.core.exception.AccessDeniedException;
import com.ylll.core.exception.ParameterException;
import com.ylll.core.model.ProjectPO;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 校验处理类
 */
public class ParamUtil {

    private static final Logger logger = LoggerFactory.getLogger(ParamUtil.class);

    /**
     *
     */
    public static final String PROJECT_SEQ = "project_seq";

    /**
     *
     */
    public static final String PROJECT_VERSION = "project_version";

    /**
     *
     */
    public static final String DATA = "data";

    /**
     *
     * 分页传入参数 页数 包含在data 参数里 如 data:{_page:1,_rows:10,name='张三'}
     */
    public static final String PAGE_PARAM = "_page";

    /**
     * 分页传入参数 行数 包含在data 参数里 如 data:{_page:1,_rows:10,name='张三'}
     */
    public static final String ROWS_PARAM = "_rows";

    private static final Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * 通过request获取 ProjectPO 对象
     *
     * @param request
     * @return
     */
    public static ProjectPO getProjectPOFromRequest(HttpServletRequest request) {
        ProjectPO po = new ProjectPO();
        String seq = request.getParameter(PROJECT_SEQ);
        String version = request.getParameter(PROJECT_VERSION);
        logger.debug("project_seq:{}", seq);
        logger.debug("project_version:{}", version);
        po.setProject_seq(seq);
        po.setProject_version(version);
        return po;
    }

    /**
     *
     * @param request
     * @throws java.lang.Exception
     */
    public static void executeValiProjectInfo(HttpServletRequest request) throws Exception {
        executeValiProjectInfo(validator, request);
    }

    /**
     *
     * @param validator
     * @param request
     * @throws java.lang.Exception
     */
    public static void executeValiProjectInfo(Validator validator, HttpServletRequest request) throws Exception {
        ProjectPO po = getProjectPOFromRequest(request);
        Set<ConstraintViolation<ProjectPO>> constraintViolations = validator.validate(po);
        if (constraintViolations != null && constraintViolations.size() > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<ConstraintViolation<ProjectPO>> it = constraintViolations.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getMessage()).append(";");
            }
            throw new AccessDeniedException(sb.toString());
        }

    }

    /**
     * 返回参数 校验
     *
     * @param request
     * @return
     */
    public static String getDataStrFromRequest(HttpServletRequest request) {
        return request.getParameter(DATA);
    }

    /**
     * 分页参数 获取页数 注意:这时data参数内放置的是对象 ,不能是数组
     *
     * @param request
     * @return
     */
    public static int getPage(HttpServletRequest request) {
        int defualt = 1;
        try {
            String json = getDataStrFromRequest(request);
            if (json == null) {
                return defualt;
            }
            JSONObject obj = JSONObject.fromObject(json);
            String page = obj.getString(PAGE_PARAM);
            return Common.convertToInt(page, defualt);

        }
        catch (Exception e) {
            return defualt;
        }
    }
/**
     * 分页参数 获取行数 注意:这时data参数内放置的是对象 ,不能是数组
     *
     * @param request
     * @return
     */
    public static int getRows(HttpServletRequest request) {
        int defualt = Service.getPageRows();
        try {
            String json = getDataStrFromRequest(request);
            if (json == null) {
                return defualt;
            }
            JSONObject obj = JSONObject.fromObject(json);
            String page = obj.getString(ROWS_PARAM);
            return Common.convertToInt(page, defualt);
        }
        catch (Exception e) {
            return defualt;
        }
    }
    /**
     *
     * @param request
     * @param paramVali
     * @throws Exception
     */
    public static void executeValiPara(HttpServletRequest request, ParamVali paramVali) throws Exception {
        executeValiPara(request, validator, paramVali);
    }

    /**
     *
     * @param request
     * @param validator
     * @param paramVali
     * @throws Exception
     */
    public static void executeValiPara(HttpServletRequest request, Validator validator, ParamVali paramVali) throws Exception {

        String dataJson = getDataStrFromRequest(request);
        if (dataJson == null) {
            throw new ParameterException(" request params data is null.");
        }
        Class cla = paramVali.bean();
        Set<ConstraintViolation<Object>> constraintViolations = null;
        if (!paramVali.isList()) {
            Object obj = JsonToBean.convertToBean(dataJson, cla);
            constraintViolations = valiBeanParam(obj, validator, paramVali);
            if (constraintViolations != null && constraintViolations.size() > 0) {
                throw new ParameterException(getErrorMessages(constraintViolations));
            }
        } else {
            List<Object> list = JsonToBean.convertToBeanList(dataJson, cla);
            for (Object obj : list) {
                constraintViolations = valiBeanParam(obj, validator, paramVali);
                if (constraintViolations != null && constraintViolations.size() > 0) {
                    throw new ParameterException(getErrorMessages(constraintViolations));
                }
            }
        }
    }

    private static String getErrorMessages(Set<ConstraintViolation<Object>> constraintViolations) {
        StringBuilder sb = new StringBuilder();
        Iterator<ConstraintViolation<Object>> it = constraintViolations.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getMessage()).append(";");
        }
        return sb.toString();
    }

    private static Set<ConstraintViolation<Object>> valiBeanParam(Object obj, Validator validator, ParamVali paramVali) {
        Set<ConstraintViolation<Object>> constraintViolations = null;
        String[] params = paramVali.params();
        if (params != null && params.length != 0) {//vali  property
            for (int i = 0; i < params.length; i++) {
                if (i == 0) {
                    constraintViolations = validator.validateProperty(obj, params[i]);
                    continue;
                }
                constraintViolations.addAll(validator.validateProperty(obj, params[i]));
            }
        } else {
            //vali all params
            constraintViolations = validator.validate(obj);
        }
        return constraintViolations;
    }

}
