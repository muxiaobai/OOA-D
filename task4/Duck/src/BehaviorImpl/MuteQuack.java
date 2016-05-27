package BehaviorImpl;

import IBehavior.IQuackBehavior;
/**
 * 叫实现
 * @author zhang
 * @date  2016年5月27日 下午2:21:29
 * @doing MuteQuack的叫
 */
public class MuteQuack implements IQuackBehavior {

	@Override
	public void quack() {
		System.out.println("不会叫MuteQuack");
	}

}
