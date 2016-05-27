package BehaviorImpl;

import IBehavior.IFlyBehavior;
/**
 * 飞实现
 * @author zhang
 * @date  2016年5月27日 下午2:20:54
 * @doing NoWay的飞
 */
public class FlyNoWay implements IFlyBehavior {

	@Override
	public void fly() {
		System.out.println("不会飞FlyNoWay");
	}

}
