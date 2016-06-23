package kr.pe.okjsp.util;

import java.io.IOException;

import kr.pe.okjsp.Article;

public class Spam {
	public static String[] words = { "Ǯ��", "Ǯ��", "5738", "��Ǯ", "����", "����",
			"ab88", "ī����", "qpr1000", "imc100", "dmlover", "��", "����", "r69o",
			"first-shop", "first-dm", "rkdrkdskarn", "venezia", "baekhee",
			".lu.to", "jjr8858", "�þ˹�", "�º���", "clippers", "�ξ�", "hyejin000",
			"caspinmsn", "��ī��", "��ī", "tt54" };

	public static String getBannedWords() {
		return StringHelper.toStringWrapped(words, "\"");
	}

	public static void checkSpammer(long sid) throws IOException {
		if (sid == 21797 || sid == 6297 || sid == 15548 || sid == 19847
				|| sid == 24706 || sid == 24830 || sid == 25663) {
			throw new IOException("NO RIGHT TO USE!!!");
		}
	}

	public static boolean checkContent(Article article) {
		for (String ban : words) {
			if (article.getContent().toLowerCase().contains(ban)) {
				return true;
			}
		}
		return false;
	}

}
