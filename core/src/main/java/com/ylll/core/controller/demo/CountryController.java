package com.ylll.core.controller.demo;

import com.github.pagehelper.PageInfo;
import com.ylll.core.annotation.ParamVali;
import com.ylll.core.mybatis.model.Country;
import com.ylll.core.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import javax.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author YL
 */
@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;
    @Autowired
    Validator validator;
    private final String page_list = "index";

    private final String redirect_list = "redirect:list";

    /**
     *
     * @param country
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"list", "index", "index.html", ""})
    public ModelAndView getList(Country country,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int rows) throws Exception {
        ModelAndView result = new ModelAndView(page_list);
        List<Country> countryList = countryService.selectByCountry(country, page, rows);
        result.addObject("pageInfo", new PageInfo<Country>(countryList));
        result.addObject("queryParam", country);
        result.addObject("page", page);
        result.addObject("rows", rows);
        return result;
    }

    /**
     *
     * @param country
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "view", method = RequestMethod.GET)
    public ModelAndView view(Country country) throws Exception {
        ModelAndView result = new ModelAndView();
        if (country.getId() != null) {
            country = countryService.selectByKey(country.getId());
        }
        result.addObject("country", country);
        return result;
    }

    @RequestMapping(value = "vali")
    @ResponseBody
    public void vali() {
        
    }

    /**
     *
     * @param country
     * @param bindingResult
     * @return
     */
    @ParamVali(bean=Country.class,params = {"countrycode"})
    @RequestMapping(value = "save", method = RequestMethod.POST)
    // @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public ModelAndView save(@Valid Country country, BindingResult bindingResult) {
        
        
        ModelAndView result = new ModelAndView(redirect_list);
       // validator.validate(country, bindingResult);
       // System.out.println("bindingResult = " + bindingResult.hasErrors());
        try {
            if (bindingResult.hasErrors()) {
            //输出错误信息  

                List<ObjectError> allErrors = bindingResult.getAllErrors();
                
result.addObject("allerrors", allErrors);
                for (ObjectError objectError : allErrors) {
                    //输出错误信息  
                    System.out.println(objectError.getDefaultMessage());
                }

                
                System.out.println("vali error");
            } else {
                if (country.getId() != null) {
                    countryService.updateAll(country);
                } else {
                    countryService.save(country);
                }
                result.addObject("msg", "success");
            }

        }
        catch (Exception e) {
            result.addObject("msg", "error");
            System.out.println("save error");
        }
        return result;
    }

    /**
     *
     * @param list
     * @return
     */
    @RequestMapping(value = "batchInsert", method = RequestMethod.POST)
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public int batchInsert(List<Country> list) {
        try {
            return countryService.batchInsertCountry(list);
        }
        catch (Exception e) {
            return -1;
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("delete")
    public String delete(Integer id) throws Exception {
        countryService.delete(id);
        return redirect_list;
    }

}
