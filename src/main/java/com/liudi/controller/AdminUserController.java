package com.liudi.controller;

import com.liudi.common.Constants;
import com.liudi.common.Result;
import com.liudi.common.ResultGenerator;
import com.liudi.pojo.AdminUser;
import com.liudi.service.AdminUserService;
import com.liudi.utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/11/12 下午2:19
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class AdminUserController {

    @Autowired
    AdminUserService adminUserService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "参数异常！");
        }
        //查询列表数据
        PageUtil pageUtil = new PageUtil(params);
        Result result = ResultGenerator.genSuccessResult(adminUserService.getAdminUserPage(pageUtil));

        log.info(">>>>>>>>>>>result:{}", result);
        return result;
    }



}
