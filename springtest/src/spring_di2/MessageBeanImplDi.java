package spring_di2;

public class MessageBeanImplDi implements MessageBeanDi {
	
	private String name1, name2;	//생성자를 통해 값을 삽입할 변수 
	private String greeting;		//setter를 통해 값을 삽입할 변수
	
	//-> write()를 위한 멤버변수 (setter를 통해 값 저장)
	private OutFile out;
	
	//1. 생성자를 통해서 값을 저장
	public MessageBeanImplDi(String name1, String name2) {
		this.name1 = name1;
		this.name2 = name2;
		System.out.println("MessageBeanImplDi 생성자 호출됨!");
	}//생성자
	

	//2.Setter Getter를 통해 값을 저장
	public void setGreeting(String greeting) {
		this.greeting = greeting;
		System.out.println("setGreeting 메서드 호출됨!");
	}

	
	public void setOut(OutFile out){	//call by reference
		this.out = out;
		System.out.println("setOut 메서드 호출됨!");
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		String message = greeting + name1 + ", " + name2 + "!";
		System.out.println("message= "+message);
		//추가코딩 write()
		try{
			out.write(message);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}//sayHello

}
