package proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	
	private Object target;
	
	public Object getInstance(Object target){
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("cglib锟斤拷锟斤拷前锟矫达拷锟斤拷锟斤拷锟斤拷");
		proxy.invokeSuper(obj, args);
		System.out.println("cglib锟斤拷锟斤拷锟斤拷么锟斤拷锟斤拷锟斤拷锟�");
		return null;
	}

}
