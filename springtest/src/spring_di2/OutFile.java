package spring_di2;

import java.io.IOException;

//특정 경로에 파일을 생성하여, 내용을 출력시키는 메서드(write())를 선언
public interface OutFile {
	void write(String message) throws IOException;
}
