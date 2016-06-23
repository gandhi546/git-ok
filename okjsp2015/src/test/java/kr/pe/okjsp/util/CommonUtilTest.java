/*
 * Created on 2003. 5. 6.
 *
 */
package kr.pe.okjsp.util;

import junit.framework.TestCase;
import kr.pe.okjsp.Article;
import kr.pe.okjsp.util.CommonUtil;

/**
 * @author kenu
 *
 */
public class CommonUtilTest extends TestCase {

	/**
	 * Constructor for CommonUtilTest.
	 * @param arg0
	 */
	public CommonUtilTest(String arg0) {
		super(arg0);
	}

	public void testA2k() {
	}

	public void testK2a() {
	}

	public void testFormatDate() {
	}

	public void testShowHtml() {
		String str = "hello\r\nhello2";
		Article article = new Article();
		article.setContent(str);
		article.setHtml("0");
		assertEquals("hello\r<br>hello2", article.getContentView());
		article.setHtml("1");
		assertEquals("hello\r\nhello2", article.getContentView());
		article.setHtml("2");
		assertEquals(str, article.getContentView());
		article.setHtml("0   ");
		assertEquals("hello\r<br>hello2", article.getContentView());
		article.setHtml("1   ");
		assertEquals("hello\r\nhello2", article.getContentView());
		article.setHtml("2   ");
		assertEquals(str, article.getContentView());
	}

	/*
	 * Test for String nchk(String)
	 */
	public void testNchkString() {
	}

	/*
	 * Test for String nchk(String, String)
	 */
	public void testNchkStringString() {
		assertEquals("0", CommonUtil.nchk(null,"0"));
		assertEquals("", CommonUtil.nchk("","0"));
	}

	public void testRplc() {
	}

	public void testCrop() {
	}

	public void testCropByte() {
		String string = "123�����ٶ�";
		assertEquals("����", CommonUtil.cropByte(string, 3, 6));
		assertEquals("������", CommonUtil.cropByte(string, 3, 8));
		assertEquals("��", CommonUtil.cropByte(string, 9, 12));
	}
	
	/*
	 * Test for void setCookie(HttpServletResponse, String, String, int)
	 */
	public void testSetCookieHttpServletResponseStringStringint() {
	}

	/*
	 * Test for void setCookie(HttpServletResponse, String, String)
	 */
	public void testSetCookieHttpServletResponseStringString() {
	}

	public void testGetCookie() {
	}

	
	public void testGetNumberedSeq() {
		assertEquals(1234, CommonUtil.getNumberedSeq("/1234"));
		assertEquals(1234, CommonUtil.getNumberedSeq("/1234?"));
		assertEquals(1234, CommonUtil.getNumberedSeq("/1234?567"));
	}

}
