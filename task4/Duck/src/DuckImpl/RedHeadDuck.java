package DuckImpl;

import AbDuck.Duck;
import BehaviorImpl.FlyRockerPoweredImpl;
import BehaviorImpl.Quack;
/**
 * RedHeadDuck
 * @author zhang
 * @date  2016年5月27日 下午2:30:05
 * @doing TODO
 */
public class RedHeadDuck extends Duck {
public RedHeadDuck() {
	setFlyBehavior(new FlyRockerPoweredImpl());
	setQuackBehavior(new Quack() );
}
	@Override
	public void display() {
		System.out.println("I'm RedHeadDuck!");
	}

}
