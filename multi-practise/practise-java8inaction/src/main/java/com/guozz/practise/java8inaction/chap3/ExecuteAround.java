package com.guozz.practise.java8inaction.chap3;

import java.io.BufferedReader;
import java.io.IOException;

public class ExecuteAround {





    public interface  BufferedReaderProcessor{
        public String process(BufferedReader b) throws IOException;
    }
}
