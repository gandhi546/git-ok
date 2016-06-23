package kr.pe.okjsp.member;

import java.sql.SQLException;

import kr.pe.okjsp.Navigation;
import kr.pe.okjsp.util.MailUtil;

public class MemberService {

	public String[] sendRecoverPassword(String email) {
		
		String mailto = email;
		String token = getTokenWithEmail(email);
		if (token == null) {
			return new String[] { "false", "��ϵ��� ���� �̸����Դϴ�." };
		}
		String subject = "[OKJSP]��й�ȣ ���� �ȳ�";
		String textMessage = "<h1>OKJSP ��й�ȣ ������ ��û�Ǿ����ϴ�.</h1>"
				+ "��û���� ���� �����̶�� �����Ͻñ� �ٶ��ϴ�."
				+ "<br /><br /><a href=\"" +
				Navigation.getPath("SECURE_DOMAIN") +
				"/member?act=fromEmail&p="
				+ email + "&t=" + token + "\">��й�ȣ �����ϱ�</a><br />";

		String success;
		String message;
		try {
			new MailUtil().send(mailto, subject, textMessage,
					"text/html; charset=euc-kr");
			success = "true";
			message = email + "�� ������ �߼��߽��ϴ�.";
		} catch (Exception e) {
			System.out.println(e.toString() + "\nfailed: " + email);
			success = "false";
			message = email + "�� �߼����� ���߽��ϴ�.";
		}
		return new String[] { success, message };
	}

	private String getTokenWithEmail(String email) {
		if (isMemberEmail(email)) {
			try {
				MemberDao dao = new MemberDao();
				String token = String.valueOf(System.nanoTime());
				dao.addEmailWithToken(email, token);
				return token;
			} catch (SQLException e) {
			}
		}
		return null;
	}

	public int changePassword(String email, String password,
			String confirmPassword) {
		if (password == null || !password.equals(confirmPassword)) {
			return 2;
		}
		if (!isMemberEmail(email)) {
			return 3;
		}
		MemberDao dao = new MemberDao();
		int result = 0;
		try {
			result = dao.setPasswordByEmail(email, password);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	public int changePassword(String email, String password,
			String confirmPassword, String token) {
		if (password == null || !password.equals(confirmPassword)) {
			return 2;
		}
		if (!isMemberEmail(email)) {
			return 3;
		}
		MemberDao dao = new MemberDao();
		int result = 0;
		try {
			result = dao.setPasswordByEmail(email, password);
			if (result == 1) {
				result = dao.setTokenUsed(token);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	private boolean isMemberEmail(String email) {
		MemberHandler handler = new MemberHandler();
		boolean emailExist = false;
		try {
			emailExist = handler.isEmailExist(email);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return emailExist;
	}

	public int validateParams(String email, String token) {
		MemberDao dao = new MemberDao();
		return dao.validateParams(email, token);
	}

	public boolean checkBySid(long sid) {
		MemberDao dao = new MemberDao();
		return dao.checkBySid(sid);
	}

}
