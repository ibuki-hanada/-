package janken;

import java.util.Random;
import java.util.Scanner;

public class JankenGame {
	
	public static int getUser() {
		int input;
		// ユーザから0,1,2の数字を受け取る.
		Scanner sc = new Scanner(System.in);
		while (true) {
			if(sc.hasNextInt()) {
				input = sc.nextInt();
				if (0 <= input && input <= 2) {
					return input;
				}
				else {
					continue;
				}
			}
			else {
				sc.next();
					
			}
		}
	}
	
	public static int getPc() {
		// 乱数で0, 1, 2のいずれかを返す
		Random rand = new Random();
		return rand.nextInt(3);
		
	}
	
	public static String judgeJanken(int user, int pc) {
		String result;
		if(user==pc) {
			result = "あいこ";
		}else if(user==0 && pc==1 || user==1 && pc==2 || user==2 && pc==0) {
			result = "勝ち";
		}else {
			result = "負け";
		}
		
		return result;
	}
	
	
	public static void showResult(int user ,int pc , String result) {
		String showuser; String showpc;
		if(user==0) {
			showuser="グー";
		} else if(user==1) {
			showuser="チョキ";
		} else {
			showuser="パー";
		}
		
		if(pc==0) {
			showpc="グー";
		} else if(pc==1) {
			showpc="チョキ";
		} else {
			showpc="パー";
		}
	}
}
