package com.ylll.core.controller.demo;

import com.github.pagehelper.PageInfo;
import com.ylll.core.model.Country;
import com.ylll.core.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author YL
 */
@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

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

    /**
     *
     * @param country
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public ModelAndView save(Country country) {
        ModelAndView result = new ModelAndView(redirect_list);
        try {
            if (country.getId() != null) {
                countryService.updateAll(country);
            } else {
                countryService.save(country);
            }
            result.addObject("msg", "success");
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
            return  countryService.batchInsertCountry(list);
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
