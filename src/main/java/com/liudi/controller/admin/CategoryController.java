package com.liudi.controller.admin;

import com.liudi.service.CategoryService;
import com.liudi.utils.PageQueryUtil;
import com.liudi.utils.PageResult;
import com.liudi.utils.Result;
import com.liudi.utils.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/11/16 下午6:09
 */

@Controller
@RequestMapping("/admin")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 跳转
     *
     * @param request
     * @return
     */
    @GetMapping("/categories")
    public String categoryPage(HttpServletRequest request) {
        request.setAttribute("path", "categories");
        return "admin/category";
    }

    //    分类列表分页接口
    @RequestMapping(value = "/categories/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常");
        }
        PageQueryUtil queryUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(categoryService.getBlogCategoryPage(queryUtil));
    }

    //    添加分类接口
    @RequestMapping(value = "/categories/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestParam("categoryName") String categoryName,
                       @RequestParam("categoryIcon") String categoryIcon) {
        if (StringUtils.isEmpty(categoryName)) {
            return ResultGenerator.genFailResult("请输入分类名称！");
        }
        if (StringUtils.isEmpty(categoryIcon)) {
            return ResultGenerator.genFailResult("请选择分类图标！");
        }
        if (categoryService.saveCategory(categoryName, categoryIcon)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("分类名称重复");
        }
    }

//    根据 id 获取单条分类记录接口
//    public Result info() {
//
//    }

//    修改分类接口
//    删除分类接口


}
