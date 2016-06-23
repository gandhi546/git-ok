package kr.pe.okjsp.mobile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.pe.okjsp.DeleteServlet;
import kr.pe.okjsp.util.DbCon;

/**
 * ������ �Խù� ����
 * @author hwayoung.kang
 *
 */
public class MobileDeleteServlet extends DeleteServlet {
	private static final long serialVersionUID = 1L;
	DbCon dbCon = new DbCon();

	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {

		saveArticle(req);
		
		//�����ڿ� ȭ���� ���� �����ϴ°���...�ϴ� �ش� bbs ����Ʈ�� ����
		//req.getRequestDispatcher(resourceName+"?bbs="+req.getParameter("bbs")).forward(req, res);
		//req.getRequestDispatcher(resourceName+"?bbs="+req.getParameter("bbs")+"&act=MLIST").forward(req, res);
		//String togo = "/bbs?bbs="+req.getParameter("bbs")+"&act=MLIST";	//��ġ�߳� Ÿ��Ʋ�� ��� �ؾ� �ϳ� ��,.��
		res.sendRedirect("/m");

	} // end doPost()

}
