package spring_di2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;	//인터페이스

public class HelloDi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//자바에서 객체를 생성하고 메서드 호출은 비일비재한 일
		//스프링에서는 자주 객체를 생성하거나, 소스내용 변경이 잦은 클래스는 따로
		//xml로 만들어서 불러오자!
		
		//1단계 : 스프링환경설정 파일을 불러오기
		Resource resource = new FileSystemResource("C:/web/jsp/sou/springtest/src/spring_di2/initContext.xml");
		//import org.springframework.core.io.Resource;	//인터페이스(Resource는) 호출해야함
		//절대경로로 xml 파일을 불러온다.
		
		//2단계 : BeanFactory 객체를 생성
		BeanFactory factory = new XmlBeanFactory(resource);
		//Xml을 통한 Bean 객체를 생성하기 위해 resource(xml 정보를 담고 있는)를 XmlBeanFactory 매개변수로 넣는다.
		
		//3단계 : BeanFactory 객체를 통해 원하는 객체를 생성
		//Message2 me = (Message2)factory.getBean("messageBean");
		MessageBeanDi me = (MessageBeanDi)factory.getBean("mBean");
		//인터페이스로 객체를 받으면 다양한 객체를 xml 수정만으로 표현가능. 소스코드 수정 최소화
		me.sayHello();
		
		System.out.println( "spring version => " + org.springframework.core.SpringVersion.getVersion() );
		System.exit(0);
		/* 버그 대체용 코드 한줄
		 * ERROR: JDWP Unable to get JNI 1.2 environment, jvm->GetEnv() return code = -2
				 JDWP exit error AGENT_ERROR_NO_JNI_ENV(183):  */
		
	}//main

}
