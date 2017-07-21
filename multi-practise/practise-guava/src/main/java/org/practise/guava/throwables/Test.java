package org.practise.guava.throwables;

import java.sql.SQLException;

import com.google.common.base.*;

public class Test {

	
    public void doIt() throws SQLException {
        try {
            doSomething();
        } catch (Throwable throwable) {
            Throwables.propagateIfInstanceOf(throwable, SQLException.class);
            Throwables.propagateIfPossible(throwable);
        }
    }
	
    
    public void doSomething() throws Throwable {
        //ignore method body
    }

    public void doSomethingElse() throws Exception {
        //ignore method body
    }
}
