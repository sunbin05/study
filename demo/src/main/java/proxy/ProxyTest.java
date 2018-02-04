package proxy;

public class ProxyTest {
	
	public static void main(String[] args) {
		
		/**
		 * ��̬����
		 */
//		Pet pet = new Pet(new Dog());
//		pet.eat();
//		
//		Pet pet2 = new Pet(new Cat());
//		pet2.eat();
		
		/**
		 * JDK��̬����
		 */
//		JDKDynamicProxyHandler handler = new JDKDynamicProxyHandler(new Dog());
//		Animal animal = (Animal)Proxy.newProxyInstance(Animal.class.getClassLoader(), new Class[]{Animal.class}, handler);
//		animal.eat();
//		
//		JDKDynamicProxyHandler handler2 = new JDKDynamicProxyHandler(new Cat());
//		Animal animal2 = (Animal)Proxy.newProxyInstance(Animal.class.getClassLoader(), new Class[]{Animal.class}, handler2);
//		animal2.eat();
		
		/**
		 * CGLIB����
		 */
		CglibProxy cglibProxy = new CglibProxy();
		Animal animal = (Animal)cglibProxy.getInstance(new Dog());
		animal.eat();
	}

}
