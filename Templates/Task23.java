/**
 * 基本課題2.3 メインクラス
 */


public class Task23 {
	/** 初期残高 */
	static final int INITIAL_BALANCE = 1000;
	
	/**
	 * スマートカードを作成するメソッド
	 * @param name 所有者氏名
	 * @param telephoneNumber 電話番号
	 * @return 作成したスマートカード
	 */
	public static SmartCard createSmartCard(String name, String telephoneNumber) {

	}
	
	/**
	 * スマートカードをチャージするメソッド
	 * @param card スマートカード
	 * @param amount チャージ金額
	 */
	public static void charge(SmartCard card, long amount) {

	}
	
	/**
	 * 支払をするメソッド
	 * @param card スマートカード
	 * @param payment 支払金額
	 * @return 支払処理結果（true:支払完了，false:支払い不可）
	 */
	public static boolean pay(SmartCard card, long payment) {

	}
	
	/**
	 * スマートカード情報を表示するメソッド
	 * @param card スマートカード
	 */
	public static void show(SmartCard card) {

	}

	public static void main(String[] args) {
		/*
		 * 1. キーボードで入力した氏名と電話番号を用いてスマートカードを作成
		 */
		System.out.println("スマートカードを作成します．");
		
		
		/*
		 * 2. 電車運賃650円，480円，980円を支払う．途中で残額が不足した場合はその都度チャージする．
		 */
		int[] fares = { 650, 480, 980 };
		
		
		/*
		 * 3. カード残高を表示する 
		 */
		System.out.println("スマートカードの情報を表示します．");
		
	}

}
