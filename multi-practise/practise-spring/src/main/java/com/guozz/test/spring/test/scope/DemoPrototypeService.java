package com.guozz.test.spring.test.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 郭智忠
 * prototype
 */
@Service
@Scope("prototype")
public class DemoPrototypeService {

}
