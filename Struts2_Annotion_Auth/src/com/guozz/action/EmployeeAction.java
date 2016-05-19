package com.guozz.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class EmployeeAction extends ActionSupport {

	/** 
     * 添加 
     *  
     * 请求该方法需要拥有对test的add权限，会通过拦截器拦截   
     *  
     * @return 
     */  
    @Auth(actionName="test", privilege="add")  
    public String add(){  
        System.out.println("add");  
        return SUCCESS;  
    }  
      
    /** 
     * 查找 
     *  
     * 请求该方法的时候需要拥有对test的find权限，会通过拦截器拦截   
     *  
     * @return 
     * @throws Exception 
     */  
    @Auth(actionName="test", privilege="find")  
    public String find() throws Exception {  
        System.out.println("find");  
        return SUCCESS;  
    }  
      
    /** 
     * 删除 
     *  
     * 不会通过拦截器拦截，因为没对actionName进行权限配置 
     *  
     * @return 
     * @throws Exception 
     */  
    public String delete() throws Exception {  
        System.out.println("delete");  
        return SUCCESS;  
    }  
}
