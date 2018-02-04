package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKDynamicProxyHandler implements InvocationHandler {
	
	public Animal animal;
	
	public JDKDynamicProxyHandler() {
	}

	public JDKDynamicProxyHandler(Animal animal) {
		this.animal = animal;
	}
	
	/**
	 * 锟斤拷态锟斤拷锟斤拷锟诫静态锟斤拷锟斤拷锟斤拷鹊锟斤拷诺悖�
	 * 	锟斤拷锟斤拷锟斤拷锟絚lass锟侥硷拷锟斤拷锟斤拷使锟斤拷时锟斤拷态锟斤拷锟斤拷锟侥ｏ拷锟斤拷省锟斤拷锟斤拷时锟斤拷锟斤拷诖妫�
	 * 	锟斤拷锟斤拷锟侥碉拷锟斤拷也锟角讹拷态锟侥ｏ拷
	 * 	锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷欠锟斤拷锟节硷拷锟斤拷锟斤拷锟侥革拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷式锟侥ｏ拷锟斤拷装锟斤拷InvocationHandler锟斤拷invoker锟斤拷锟斤拷锟斤；
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("JDK锟斤拷态锟斤拷锟斤拷锟斤拷玫锟角帮拷么锟斤拷锟�");
		method.invoke(animal, args);
		System.out.println("JDK锟斤拷态锟斤拷锟斤拷锟斤拷玫暮锟斤拷么锟斤拷锟�");
		return null;
	}

}
