package com.bookspace.cloud.gateway.util;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class BannerApplicationRunner implements ApplicationRunner {

    @Value("${server.port}")
    private String port;

    @Value("${server.servlet.context-path:}")
    private String path;

    @Override
    public void run(ApplicationArguments args) {
        ThreadUtil.execute(() -> {
            ThreadUtil.sleep(1, TimeUnit.SECONDS); // 延迟 1 秒，保证输出到结尾
            String ip = "localhost";
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            //String port = env.getProperty("server.port");
            String path = Optional.ofNullable(this.path).orElse(""); // (env.getProperty("server.servlet.context-path"));
            log.info("\n----------------------------------------------------------\n\t" +
                            "Book Space started！\n\t" +
                            "Local: \t\t\t{} \n\t" +
                            "External: \t\t{} \n\t" +
                            "Swagger doc: \t{} \n\t" +
                            "----------------------------------------------------------",
                    "http://localhost:" + port + path,
                    "http://" + ip + ":" + port + path,
                    "http://localhost:" + port + "/doc.html");
        });

    }

}
