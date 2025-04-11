package janken;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JankenView extends JFrame implements Param{
	
	static String jankenResult;
	
	public JankenView(String title) {
		// 初期設定
		//フレーム作成
		setTitle(title);
		setSize(600, 400); // 解像度
		setLocationRelativeTo(null); // 画面をディスプレイの中央に配置
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 閉じたらプログラム終了
		
		//コンテンツパネルに、レイアウトマネージャとしてBorderLayoutを指定
		contentsPanel.setLayout(new BorderLayout());
		//コンテンツパネルにテキストを追加	
		contentsPanel.add(contentsLabel);
		//ウィンドウにコンテンツパネルを追加
		add(contentsPanel, BorderLayout.CENTER);
		
		//ヘッダーパネルの作成
		headerPanel.setLayout(new BorderLayout());
		//ヘッダーラベルの作成
		headerlabel.setForeground(Color.WHITE);
		headerlabel.setHorizontalAlignment(JLabel.CENTER);
		headerlabel.setFont(new Font("メイリオ", Font.BOLD, 24));
		headerPanel.add(headerlabel);//パネルにテキストを追加
		add(headerPanel, BorderLayout.NORTH);//ウインドウにパネルを追加
		
		//グーボタンの作成
		btnRock.setFont(new Font("メイリオ", Font.BOLD, 12));
		btnRock.setPreferredSize(new Dimension(50,50));
		btnRock.setAlignmentY(TOP_ALIGNMENT);
	
		//チョキボタンの作成
		btnScissors.setFont(new Font("メイリオ", Font.BOLD, 12));
		btnScissors.setPreferredSize(new Dimension(50,50));

		//パーボタンの作成
		btnPaper.setFont(new Font("メイリオ", Font.BOLD, 12));
		btnPaper.setPreferredSize(new Dimension(50,50));
		
		//ハンマーボタンの作成
		btnHammer.setFont(new Font("メイリオ", Font.BOLD, 12));
		btnHammer.setPreferredSize(new Dimension(50,50));
		btnHammer.setVisible(false);
		
		//ヘルメットボタンの作成
		btnHelmet.setFont(new Font("メイリオ", Font.BOLD, 12));
		btnHelmet.setPreferredSize(new Dimension(50,50));
		btnHelmet.setVisible(false);
		
		//ボタンを押した場合の実行
		btnRock.addActionListener(new myListenerRock());
		btnScissors.addActionListener(new myListenerScissors());
		btnPaper.addActionListener(new myListenerPaper());
		
		//コンテニューボタンの作成
		btnContinue.setFont(new Font("メイリオ", Font.BOLD, 12));
		btnContinue.setPreferredSize(new Dimension(50,50));
		btnContinue.setVisible(false);
		
		//終了ボタンの作成
		btnExit.setFont(new Font("メイリオ", Font.BOLD, 12));
		btnExit.setPreferredSize(new Dimension(50,50));
		btnExit.setVisible(false);
		
		//
		btnpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		btnpanel.add(btnRock);
		btnpanel.add(btnScissors);
		btnpanel.add(btnPaper);
		btnpanel.add(btnHammer);
		btnpanel.add(btnHelmet);
		btnpanel.add(btnContinue);
		btnpanel.add(btnExit);
		add(btnpanel, BorderLayout.SOUTH);
		
	}
	
	//グーを押したとき
	public class myListenerRock implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO ボタンを無効にする
			int pc = JankenGame.getPc();
			String result = JankenGame.judgeJanken(0, pc);
			myHand(0);
			pcHand(pc);
			judge(result);
			contentsLabel.setVisible(false);
			contentsPanel.setVisible(false);
			myPanel.setVisible(true);
			pcPanel.setVisible(true);
		}
	}
	
	//チョキを押したとき
	public class myListenerScissors implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO ボタンを無効にする
			int pc = JankenGame.getPc();
			String result = JankenGame.judgeJanken(1, pc);
			myHand(1);
			pcHand(pc);
			judge(result);
			contentsLabel.setVisible(false);
			contentsPanel.setVisible(false);
			myPanel.setVisible(true);
			pcPanel.setVisible(true);
		}
	}
	
	//パーを押したとき
	public class myListenerPaper implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO ボタンを無効にする
			int pc = JankenGame.getPc();
			String result = JankenGame.judgeJanken(2, pc);
			myHand(2);
			pcHand(pc);
			judge(result);
			contentsLabel.setVisible(false);
			contentsPanel.setVisible(false);
			myPanel.setVisible(true);
			pcPanel.setVisible(true);
		}
	}
	
	//初期画面に戻す
	public static void init() {
		// 初期設定
		//コンテンツパネルに、レイアウトマネージャとしてBorderLayoutを指定
		pcPanel.setVisible(false);
		myPanel.setVisible(false);
		contentsPanel.setVisible(true);
		contentsLabel.setVisible(true);
		popLabel.setVisible(false);
		contentsPanel.setLayout(new BorderLayout());
		contentsLabel.setText("じゃんけん……");
		contentsPanel.setVisible(true);
		//コンテンツパネルにテキストを追加
		headerlabel.setText("手を選んでください");
		contentsPanel.add(contentsLabel);
		//ウィンドウにコンテンツパネルを追加
				
		//ヘッダーパネルの作成
		headerPanel.setLayout(new BorderLayout());
		headerlabel.setForeground(Color.WHITE);
		headerlabel.setHorizontalAlignment(JLabel.CENTER);
		headerlabel.setFont(new Font("メイリオ", Font.BOLD, 24));
		headerPanel.add(headerlabel);//パネルにテキストを追加
				
		btnRock.setFont(new Font("メイリオ", Font.BOLD, 12));
		btnRock.setPreferredSize(new Dimension(50,50));
		btnRock.setVisible(true);
		// btnScissors = new JButton("チョキ");
		btnScissors.setFont(new Font("メイリオ", Font.BOLD, 12));
		btnScissors.setPreferredSize(new Dimension(50,50));
		btnScissors.setVisible(true);
		// btnPaper = new JButton("パー");
		btnPaper.setFont(new Font("メイリオ", Font.BOLD, 12));
		btnPaper.setPreferredSize(new Dimension(50,50));
		btnPaper.setVisible(true);
				
		btnHammer.setFont(new Font("メイリオ", Font.BOLD, 12));
		btnHammer.setPreferredSize(new Dimension(50,50));
		btnHammer.setVisible(false);
				
		btnHelmet.setFont(new Font("メイリオ", Font.BOLD, 12));
		btnHelmet.setPreferredSize(new Dimension(50,50));
		btnHelmet.setVisible(false);
				
		btnContinue.setFont(new Font("メイリオ", Font.BOLD, 12));
		btnContinue.setPreferredSize(new Dimension(50,50));
		btnContinue.setVisible(false);
				
		btnExit.setFont(new Font("メイリオ", Font.BOLD, 12));
		btnExit.setPreferredSize(new Dimension(50,50));
		btnExit.setVisible(false);
		
		PopView.jankenOn();
				
		btnpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		btnpanel.add(btnRock);
		btnpanel.add(btnScissors);
		btnpanel.add(btnPaper);
		btnpanel.add(btnHammer);
		btnpanel.add(btnHelmet);
		btnpanel.add(btnContinue);
		btnpanel.add(btnExit);
	}
	
	//自分の手を作成するメソッド
	public void myHand(int hand) {
		myPanel.setLayout(new BorderLayout());
		myPanel.setOpaque(false);
		myLabel.setHorizontalAlignment(JLabel.CENTER);
		myLabel.setVisible(true);
		if(hand == 0) {
			myLabel.setIcon(guu);
			myLabel.setText("あなた");
			myLabel.setFont(new Font("メイリオ", Font.BOLD, 24));
			myLabel.setHorizontalTextPosition(JLabel.LEFT);
			myLabel.setVerticalTextPosition(JLabel.BOTTOM);
			myPanel.add(myLabel);
		} else if(hand == 1){
			myLabel.setIcon(tyoki);
			myLabel.setText("あなた");
			myLabel.setFont(new Font("メイリオ", Font.BOLD, 24));
			myLabel.setHorizontalTextPosition(JLabel.LEFT);
			myLabel.setVerticalTextPosition(JLabel.BOTTOM);
			myPanel.add(myLabel);
		} else {
			myLabel.setIcon(paa);
			myLabel.setText("あなた");
			myLabel.setFont(new Font("メイリオ", Font.BOLD, 24));
			myLabel.setHorizontalTextPosition(JLabel.LEFT);
			myLabel.setVerticalTextPosition(JLabel.BOTTOM);
			myPanel.add(myLabel);
		}
		myPanel.repaint();
		add(myPanel,  BorderLayout.WEST);
	}
	
	//相手の手を作成するメソッド
		public void pcHand(int hand) {
		pcPanel.setLayout(new BorderLayout());
		pcPanel.setOpaque(false);
		pcLabel.setHorizontalAlignment(JLabel.CENTER);
		pcLabel.setVisible(true);
		if(hand == 0) {
			pcLabel.setIcon(guu);
			pcLabel.setText("相手");
			pcLabel.setFont(new Font("メイリオ", Font.BOLD, 24));
			pcLabel.setHorizontalTextPosition(JLabel.RIGHT);
			pcLabel.setVerticalTextPosition(JLabel.BOTTOM);
			pcPanel.add(pcLabel);
		} else if(hand == 1) {
			pcLabel.setIcon(tyoki);
			pcLabel.setText("相手");
			pcLabel.setFont(new Font("メイリオ", Font.BOLD, 24));
			pcLabel.setHorizontalTextPosition(JLabel.RIGHT);
			pcLabel.setVerticalTextPosition(JLabel.BOTTOM);
			pcPanel.add(pcLabel);
		} else {
			pcLabel.setIcon(paa);
			pcLabel.setText("相手");
			pcLabel.setFont(new Font("メイリオ", Font.BOLD, 24));
			pcLabel.setHorizontalTextPosition(JLabel.RIGHT);
			pcLabel.setVerticalTextPosition(JLabel.BOTTOM);
			pcPanel.add(pcLabel);
		}
		pcPanel.repaint();
		add(pcPanel,  BorderLayout.EAST);
	}
		
	//勝敗を判定するメソッド
	public void judge(String str) {
		headerlabel.setText("さあ、はやくハンマーかヘルメットを選べ！");
		if(str == "あいこ") {
			headerlabel.setText("あいこだ！もう一度手を選んで");
		}
		else if (str == "勝ち") {
			//TODO 内容記述
			PopView popView = new PopView();
		}
		else if (str == "負け") {
			//TODO 内容記述
			PopView popView = new PopView();
		}
		jankenResult = str;
	}
}