package proxy;

public class Pet implements Animal{
	
	public Animal animal;
	
	public Pet(Animal animal){
		this.animal = animal;
	}

	@Override
	public void eat() {
		System.out.println("锟斤拷态锟斤拷锟斤拷前锟矫达拷锟斤拷锟斤拷锟斤拷");
		animal.eat();
		System.out.println("锟斤拷态锟斤拷锟斤拷锟斤拷么锟斤拷锟斤拷锟斤拷锟�");
	}

}
