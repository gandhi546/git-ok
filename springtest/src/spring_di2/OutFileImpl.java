package spring_di2;

import java.io.FileWriter;
import java.io.IOException;

public class OutFileImpl implements OutFile {
	private String filepath; //c:\web\spring\good.txt
	
	
/*	public OutFileImpl(String filepath) {
		this.filepath = filepath;
		System.out.println("OutFileImpl 생성자 호출됨!");
	}*/
	public void setFilepath(String filepath) {
		this.filepath = filepath;
		System.out.println("setFilepath() 호출됨!");
	}

	@Override
	public void write(String message) throws IOException {
		// TODO Auto-generated method stub
		//파일에 내용을 저장
		/*
		 * FileWriter : 한글 위주로 파일에 저장
		 * FileOutputStream : 영문 위주로 파일에 저장
		 * */
		FileWriter out = new FileWriter(filepath);
		out.write(message);
		System.out.println("write() 호출 성공!");
		out.close(); //메모리 해제
	}//write()

}
