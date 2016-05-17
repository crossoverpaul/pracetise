<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.guozz.action.*"%>
<%
    Employee employee=new Employee();
    employee.setId(1);
    employee.setUserName("jiqinlin");
    employee.setPwd("123456");
    request.getSession().setAttribute("employee", employee);
%>

客户已经登录