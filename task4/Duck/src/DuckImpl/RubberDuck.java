package DuckImpl;

import AbDuck.Duck;
import BehaviorImpl.FlyNoWay;
import BehaviorImpl.Squack;
/**
 * RubberDuck
 * @author zhang
 * @date  2016年5月27日 下午2:31:47
 * @doing TODO
 */
public class RubberDuck extends Duck {
	public RubberDuck() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new Squack());
	}
	@Override
	public void display() {
		System.out.println("RubberDuck");
	}

}
