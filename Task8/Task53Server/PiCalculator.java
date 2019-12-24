/** 円周率計算クラス */
public class PiCalculator {
	/** 演算回数 */
	private long n;
	/** モンテカルロ法により求めた円周率 */
	private double pi;
	/** 実際の円周率との誤差 */
	private double error;
	/** 円周率演算処理時間 */
	private long time;
	
	/**
	 * 円周率演算インスタンスを初期化するクラス
	 * @param n	演算回数
	 */
	public PiCalculator(long n) {
		this.setN(n);
	}

	/**
	 * 演算回数を取得するゲッターメソッド
	 * @return 演算回数
	 */
	public long getN() {
		return this.n;
	}

	/**
	 * 演算回数を設定するセッターメソッド
	 * @param n 演算回数
	 */
	public void setN(long n) {
		// 指定された演算回数が0以下の場合，エラーを表示して終了
		if (n <= 0)
			throw new IllegalArgumentException("演算回数が不適切です．");
		this.n = n;
	}

	/**
	 * モンテカルロ法で求めた円周率を取得するゲッターメソッド
	 * @return 円周率
	 */
	public double getPi() {
		return this.pi;
	}

	/**
	 * 実際の円周率との誤差を取得するゲッターメソッド
	 * @return 誤差
	 */
	public double getError() {
		return this.error;
	}

	/**
	 * 円周率演算処理時間を取得するゲッターメソッド
	 * @return 演算処理時間
	 */
	public long getTime() {
		return this.time;
	}
	
	/**
	 * 円周率を計算するメソッド
	 */
	public void calculatePi() {
		double x, y;
		long m = 0;
		
		// 演算開始時の現在時刻を取得
		long startTime = System.currentTimeMillis();
		// 演算処理
		for (long i = 0; i < this.n; i++) {
			// 任意の座標を生成
			x = Math.random();
			y = Math.random();
			
			// 任意に生成した座標が半径1の扇型の中に存在していれば，mをインクリメント
			if (x * x + y * y <= 1.0)
				m++;
		}
		// 演算した円周率を返す
		this.pi = (double)(4 * m) / this.n;
		// 円周率の誤差を格納
		this.error = Math.PI - this.pi;
		
		// 演算終了時の現在時刻を取得
		long stopTime = System.currentTimeMillis();

		// 演算時間を格納
		this.time = stopTime - startTime;
	}
}
