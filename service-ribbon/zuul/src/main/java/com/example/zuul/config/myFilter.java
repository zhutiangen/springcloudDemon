package com.example.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class myFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(ZuulFilter.class);

    /**
     * 解析：
     * 返回字符串，代表过滤器的类型
     * pre: 在路由之前
     * routing: 在路由之时
     * post: 在路由之后
     * error: 发送错误时
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 这里可以写逻辑判断，是否要过滤，本文true,永远过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();

        HttpServletRequest request = requestContext.getRequest();

        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURI().toString()));

        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            logger.warn("token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try{
                requestContext.getResponse().getWriter().print("token is empty");
            }catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("ok");
        return null;
    }
}
