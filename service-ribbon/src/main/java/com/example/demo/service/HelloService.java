package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    public String hiService() {
        return restTemplate.getForObject("http://EUREKACLINET/ztgSpringCloud/eureckclient/test", String.class);
    }

    /**
     * 指定调用其他服务出错后，执行的方法
     * 好处：控制了容器的线程阻塞
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://EUREKACLINET/ztgSpringCloud/eureckclient/test", String.class);
    }

    public String hiError(String name) {
        return "hi" + name + "sorry";
    }
}
