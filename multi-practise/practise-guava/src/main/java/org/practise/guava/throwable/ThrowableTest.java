package org.practise.guava.throwable;

import java.io.IOException;


import com.google.common.base.Throwables;

public class ThrowableTest {

    public void testThrowables(){
        try {
            throw new Exception();
        } catch (Throwable t) {
            String ss = Throwables.getStackTraceAsString(t);
            System.out.println("ss:"+ss);
            Throwables.propagate(t);
        }
    }
    
    public void call() throws IOException {
        try {
            throw new IOException();
        } catch (Throwable t) {
            Throwables.propagateIfInstanceOf(t, IOException.class);
            throw Throwables.propagate(t);
        }
    }    
}
