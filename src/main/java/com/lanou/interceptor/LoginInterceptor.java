package com.lanou.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 17/11/19.
 */
public class LoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {

        Object loginName = ServletActionContext.getRequest().getSession().getAttribute("login");
        if (loginName == null) {
            ServletActionContext.getContext().getSession().put("msg","未登录状态");
            return "login";
        }
        return invocation.invoke();
    }
}
