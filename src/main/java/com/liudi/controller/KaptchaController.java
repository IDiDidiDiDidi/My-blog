package com.liudi.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/11/13 上午11:50
 */
@Controller
@Slf4j
public class KaptchaController {

    @Autowired
    private DefaultKaptcha captchaProducer;

    @GetMapping("/kaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        byte[] captchaOutputStream;
        ByteArrayOutputStream imgOutputStream = new ByteArrayOutputStream();
        String verifyCode = captchaProducer.createText();
        httpServletRequest.getSession().setAttribute("verifyCode", verifyCode);
        BufferedImage challenge = captchaProducer.createImage(verifyCode);
        try {
            ImageIO.write(challenge, "jpg", imgOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_ACCEPTED);
            return;
        }
        captchaOutputStream = imgOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaOutputStream);
        responseOutputStream.flush();
        responseOutputStream.close();
    }


    @GetMapping("/verify")
    @ResponseBody
    public String verify(@RequestParam("code") String code, HttpSession session) {
        log.info(">>>>>>>>>>>>>>>code:{}, session:{}", code, session);
        if (StringUtils.isEmpty(code)) {
            return "验证码不能为空";
        }
        String kaptchaCode = session.getAttribute("verifyCode") + "";
        if (StringUtils.isEmpty(kaptchaCode) || !code.equals(kaptchaCode)) {
            return "验证码错误";
        }
        return "验证成功";
    }


}
