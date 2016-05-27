package AbDuck;

import IBehavior.IFlyBehavior;
import IBehavior.IQuackBehavior;
/**
 * 鸭子抽象类 包含两个接口属性
 * @author zhang
 * @date  2016年5月27日 下午2:27:34
 * @doing 其他的鸭子继承此抽象类
 */
public abstract class Duck {
	IFlyBehavior flyBehavior;
	IQuackBehavior quackBehavior;
	public void swin(){
		System.out.println("I can swin");
	}
	public void parformFly(){
		flyBehavior.fly();
	}
	public void parformQuack(){
		quackBehavior.quack();
	}
	public abstract void display();
	public void setFlyBehavior(IFlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
	public void setQuackBehavior(IQuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
}
