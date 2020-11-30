package com.liudi.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.servlet.http.HttpServletResponse;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class)
@Import({})
@WebMvcTest(controllers = {CategoryController.class})
@Slf4j
public class CategoryControllerTest {

    @Autowired
    MockMvc mockMvc;
//8.30 10.28 1.28 4.28 7.28
    public void testCategoryPage() {
//        mockMvc.perform(MockMvcRequestBuilders.get("").header());
    }

    public void testList() {
    }

    public void testSave() {
    }

    public void testInfo() {
    }

    public void testUpdate() {
    }

    public void testDelete() {
    }
}