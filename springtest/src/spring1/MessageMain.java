package spring1;

public class MessageMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message1 m1 = new Message1();
		Message2 m2 = new Message2();
		
		m1.sayHello("상윤");
		m2.sayHello("간디");
		System.out.println( "spring version => " + org.springframework.core.SpringVersion.getVersion() );
		System.exit(0);
		/* 버그 대체용 코드 한줄
		 * ERROR: JDWP Unable to get JNI 1.2 environment, jvm->GetEnv() return code = -2
				 JDWP exit error AGENT_ERROR_NO_JNI_ENV(183):  */
		
	}//main

}
