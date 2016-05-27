package BehaviorImpl;

import IBehavior.IQuackBehavior;
/**
 * 叫实现
 * @author zhang
 * @date  2016年5月27日 下午2:22:19
 * @doing Squack的叫
 */
public class Squack implements IQuackBehavior {

	@Override
	public void quack() {
		System.out.println("吱吱吱Squack");
	}

}
