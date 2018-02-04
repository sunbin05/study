package poolable;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class UserPool {
	
	public static void main(String[] args) throws Exception {
		UserPoolFactory factory = new UserPoolFactory();
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		GenericObjectPool pool = new GenericObjectPool<>(factory, config);
		for(int i = 0; i < 3; i++){
			User user = (User)pool.borrowObject();
			//pool.returnObject(user);
			System.out.println(user);
			System.out.println();
		}
	}

}
