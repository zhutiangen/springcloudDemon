package com.example.servicefiegn.myInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * FeignClient value表示服务名
 * fallback： 表示失败后执行方法
 */
@FeignClient(value = "eurekaclinet", fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

    /**
     * 表示服务中调用对应的接口
     * @return
     */
    @RequestMapping(value = "/ztgSpringCloud/eureckclient/test", method = RequestMethod.GET)
    String sayHiFromClientOne();

}
