package BehaviorImpl;

import IBehavior.IFlyBehavior;
/**
 * 飞接口的实现
 * @author zhang
 * @date  2016年5月27日 下午2:23:15
 * @doing RockerPowered的叫飞
 */
public class FlyRockerPoweredImpl implements IFlyBehavior {

	@Override
	public void fly() {
		System.out.println("喷射火箭飞Fly With RockerPowered");
	}

}
