package com.guozz.test.spring.interfaces.aop2;

public interface IHelloWorldService2 {

    public void sayBefore(String param);

    public boolean sayAfterReturning();
    
    public void sayAfterThrowing();
    
    public void sayAfterFinally();
    
    public void sayAround(String param);


}
