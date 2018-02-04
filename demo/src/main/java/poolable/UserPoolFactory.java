package poolable;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class UserPoolFactory implements PooledObjectFactory<User>{

	@Override
	public PooledObject<User> makeObject() throws Exception {
		System.out.println("make Object");
	    User user = new User(Thread.currentThread().getName(), 26, "178cm");
	    return new DefaultPooledObject<User>(user);
	}

	@Override
	public void destroyObject(PooledObject<User> p) throws Exception {
		System.out.println("destroy Object");
	    User user = p.getObject();
	    user = null;
	}

	@Override
	public boolean validateObject(PooledObject<User> p) {
		System.out.println("validate Object");
	    return true;
	}

	@Override
	public void activateObject(PooledObject<User> p) throws Exception {
		System.out.println("activate Object");
	}

	@Override
	public void passivateObject(PooledObject<User> p) throws Exception {
		System.out.println("passivate Object");
	}

}
