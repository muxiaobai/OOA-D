package BehaviorImpl;

import IBehavior.IQuackBehavior;
/**
 * 叫实现
 * @author zhang
 * @date  2016年5月27日 下午2:21:53
 * @doing FackQuack的叫
 */
public class FackQuack implements IQuackBehavior {

	@Override
	public void quack() {
		System.out.println("FackQuack");
	}

}
