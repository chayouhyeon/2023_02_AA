package com.KoreaIT.java.AM;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.AM.controller.articleController;
import com.KoreaIT.java.AM.controller.MemberController;

import com.KoreaIT.java.AM.dto.Article;
import com.KoreaIT.java.AM.dto.Member;
import com.KoreaIT.java.AM.util.Util;
public class App {
	public static List<Article> articles;
	public static List<Member> members;
	static {
		articles = new ArrayList<>();
		members = new ArrayList<>();
	}
	public void run() {
		System.out.println("==프로그램 시작==");
		makeTestData();
		Scanner sc = new Scanner(System.in);
		int lastArticleId = 3;
		
		MemberController memberController = new MemberController(members, sc);
		articleController articleController = new articleController(articles, sc);
		
		while (true) {
			System.out.printf("명령어 ) ");
			String command = sc.nextLine().trim();
			if (command.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			if (command.equals("system exit")) {
				break;
			}
			if (command.equals("member join")) {
				memberController.doJoin();

				
			} else if (command.equals("article list")) {
				articleController.showList();
			} else if (command.equals("article write")) {
				articleController.doWrite();
			} else if (command.startsWith("article detail ")) {
				articleController.showDetail(command);
			} else if (command.startsWith("article modify ")) {
				articleController.doModify(command);
			} else if (command.startsWith("article delete ")) {
				articleController.doDelete(command);
			}
			else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}
		System.out.println("==프로그램 끝==");
		sc.close();

	}

	
	private int getArticleIndexById(int id) {
		int i = 0;
		for (Article article : articles) {
			if (article.id == id) {
				return i;
			}
			i++;
		}
		return -1;
	}
	private Article getArticleById(int id) {
		int index = getArticleIndexById(id);
		if (index != -1) {
			return articles.get(index);
		}
		return null;
	}
	public static void makeTestData() {
		System.out.println("테스트를 위한 데이터를 생성합니다");
		articles.add(new Article(1, Util.getNowDateTimeStr(), "제목1", "내용1", 11));
		articles.add(new Article(2, Util.getNowDateTimeStr(), "제목2", "내용2", 22));
		articles.add(new Article(3, Util.getNowDateTimeStr(), "제목3", "내용3", 33));
	}
}