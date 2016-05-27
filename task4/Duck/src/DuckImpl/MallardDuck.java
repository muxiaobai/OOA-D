package DuckImpl;

import AbDuck.Duck;
import BehaviorImpl.FlyWithWingsImpl;
import BehaviorImpl.Quack;
/**
 * MallarDuck
 * @author zhang
 * @date  2016年5月27日 下午2:31:17
 * @doing TODO
 */
public class MallardDuck extends Duck {
public MallardDuck() {
	setFlyBehavior(new FlyWithWingsImpl());
	setQuackBehavior(new Quack());
}
	@Override
	public void display() {
		System.out.println("I'm MallarDuck!");
	}

}
