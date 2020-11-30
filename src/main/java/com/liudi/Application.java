package com.liudi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello shiyanlou!
 *
 */
@SpringBootApplication
@MapperScan("com.liudi.dao")
public class Application {

    public static void main(String[] args) {
        System.out.println("启动 Spring Boot...");
        SpringApplication.run(Application.class, args);
    }
}
@OpenAPIDefinition(
        info = @Info(
                title = "LD-blog",
                description = "我的博客",
                version = "1.0",
                contact = @Contact(
                        name = "LD-blog",
                        url = "https://www.baidu.com",
                        email = "1529086578@qq.com"
                )),
        servers = @Server(url = "http://localhost:28083/admin/login")
)
class OpenAPIConfiguration {

}