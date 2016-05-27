package BehaviorImpl;

import IBehavior.IQuackBehavior;
/**
 * 叫接口的实现
 * @author zhang
 * @date  2016年5月27日 下午2:22:43
 * @doing Quack的叫
 */
public class Quack implements IQuackBehavior {

	@Override
	public void quack() {
		System.out.println("呱呱 Quack");
	}

}
