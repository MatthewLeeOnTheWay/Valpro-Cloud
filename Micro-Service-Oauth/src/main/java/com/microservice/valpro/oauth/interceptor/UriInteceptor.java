package com.microservice.valpro.oauth.interceptor;

import com.microservice.valpro.oauth.entity.SysUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

/*不依赖servlet容器，还可以操作action上下文*/
public class UriInteceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1,
                                Object arg2, Exception arg3) throws Exception {

    }
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg2) throws Exception {

        SysUser user = (SysUser) request.getSession().getAttribute("user");
        /*if(false){//说明用户当前没有登录，所以需要记录用户在未登录前访问的页面地址，然后等用户登录以后再跳回之前的页面
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(20);
            String uri = request.getRequestURI();//拿到上一个页面地址
            String path = uri.substring(request.getContextPath().length());//去掉项目地址长度的字符（因为我的默认项目地址是给出的）
            String query = request.getQueryString();//得到参数
            if(query == null) {
                query="";
            }
            else {
                query="?"+query;
            }
            String beforePath = path+query;
            System.out.println(beforePath+"=====method"+request.getMethod());//测试用
            session.setAttribute("beforePath", beforePath);
            session.setAttribute("method", request.getMethod());//测试
        }*/
        return true;
    }
}
