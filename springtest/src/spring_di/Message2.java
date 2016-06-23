package spring_di;

public class Message2 implements Messageinter{
	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("반가워요"+name+"씨!");
	}
/*	void sayHello(String name){
		System.out.println("반가워요"+name+"씨!");
	}*/
}
