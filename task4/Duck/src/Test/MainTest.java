package Test;

import AbDuck.Duck;
import DuckImpl.MallardDuck;
import DuckImpl.RedHeadDuck;
import DuckImpl.RubberDuck;

public class MainTest {
	public static void main(String[] args) {
		System.out.println("===========redHead==================");
		Duck  redHead=new RedHeadDuck();
		redHead.display();
		redHead.parformFly();
		redHead.swin();
		System.out.println("===========rubber===================");
		Duck rubber=new RubberDuck();
		rubber.display();
		rubber.parformFly();
		rubber.parformQuack();
		rubber.swin();
		System.out.println("===========mallar===================");
		Duck mallar=new MallardDuck();
		mallar.display();
		mallar.parformFly();
		mallar.parformQuack();
		mallar.swin();
	}
}
