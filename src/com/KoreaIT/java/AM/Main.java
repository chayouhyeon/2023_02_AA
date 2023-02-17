package com.KoreaIT.java.AM;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);

		System.out.printf("명령어 ) ");

		String cmd = sc.nextLine();

		System.out.printf("입력된 명령어 :  %s\n", cmd);
		while (true) {
			System.out.printf("명령어 ) ");
			String command = sc.nextLine();

			if (command.equals("system exit")) {
				break;
			}
		}

		System.out.println("==프로그램 끝==");

		sc.close();
	}
}