package com.guozz.designpattern.facade.facade;

import com.guozz.designpattern.facade.Shape;
import com.guozz.designpattern.facade.impl.Circle;
import com.guozz.designpattern.facade.impl.Rectangle;
import com.guozz.designpattern.facade.impl.Square;

public class Shagepmaker {

	private Shape circle;
	private Shape rectangle;
	private Shape square;
	
	public Shagepmaker(){
		circle=new Circle();
		rectangle=new Rectangle();
		square=new Square();
	}
	
   public void drawCircle(){
    circle.draw();
   }
   
   public void drawRectangle(){
      rectangle.draw();
   }
   
   public void drawSquare(){
      square.draw();
   }
}
