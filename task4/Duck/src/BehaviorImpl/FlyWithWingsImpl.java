package BehaviorImpl;

import IBehavior.IFlyBehavior;
/**
 * 飞接口的实现
 * @author zhang
 * @date  2016年5月27日 下午2:23:47
 * @doing TODOWithWings的飞
 */
public class FlyWithWingsImpl implements IFlyBehavior{

	@Override
	public void fly() {
		System.out.println("拍翅膀Fly With Wings");
	}

}
