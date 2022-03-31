package com.yqx.ssm.controller;

import com.yqx.ssm.config.UUIdUtils;
import com.yqx.ssm.domain.Syslog;
import com.yqx.ssm.service.impl.SysLogServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author YangQX   2022/3/31 - 19:32
 */
@Component
@Aspect
public class LoggerAop
{
    private Date visitTime;
    private Class clazz;
    private Method method;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysLogServiceImpl sysLogService;

    /**
     * 获取开始时间和执行的方法名称
     */
    @Before("execution(* com.yqx.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException
    {
//        开始时间
        visitTime = new Date();
//        获取类名
        clazz = jp.getTarget().getClass();
//        获取方法名字
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
//        获取到执行方法的method对象
        if (args == null || args.length == 0)
        {
            method = clazz.getMethod(methodName);
        } else
        {
            Class[] classes = new Class[args.length];
            for (int i = 0; i < args.length; i++)
            {
                classes[i] = args[i].getClass();
            }
            clazz.getMethod(methodName, classes);
        }

    }

    @After("execution(* com.yqx.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp)
    {
        long time = System.currentTimeMillis() - visitTime.getTime();
//        反射获取链接地址url
        String url = null;
        if(clazz!=null&&method!=null&&clazz!= LoggerAop.class)
        {
//            获取类上注解的值
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(classAnnotation!=null)
            {
//                获取value值
                String classValue = classAnnotation.value()[0];
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if(methodAnnotation!=null)
                {
                    String methodValue = methodAnnotation.value()[0];
                    url = classValue+methodValue;
                    //        获取Ip地址
                    String ip = request.getRemoteAddr();
//        获取操作用户,通过SpringSecurity获取用户名称
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();
                    Syslog syslog = new Syslog();
                    syslog.setExecutionTime(time);
                    syslog.setIp(ip);
                    syslog.setUsername(username);
                    syslog.setUrl(url);
                    syslog.setVisitTime(visitTime);
                    syslog.setMethod("[类名]"+clazz.getName()+"[方法名]"+method.getName());
                    syslog.setId(UUIdUtils.getId());
//        调用Service完成数据库的记录操作
                    sysLogService.save(syslog);
                }
            }
        }
    }
}
