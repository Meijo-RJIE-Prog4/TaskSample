/**
 * 基本課題5.1 気象データクラス雛型
 * カプセル化されるようにアクセス修飾子およびstatic修飾子を各自で適切に設定すること
 */
public class WeatherData {
	/** 年 */
	? int year;
	/** 月 */
	? int month;
	/** 日 */
	? int date;
	/** 最高気温 */
	? double maxTemperature;
	/** 最低気温 */
	? double minTemperature;
	/** 降水量の合計 */
	? double rainfall;
	/** 日照時間 */
	? double hoursOfDaylight;
	
	/** 月間最高温度 */
	? double monthlyMaxTemperature;
	/** 月間最低温度 */
	? double monthlyMinTemperature;
	/** 月間降水量（合計） */
	? double monthlyRainfall;
	/** 月間日照時間（合計） */
	? double monthlyHoursOfDaylight;
	
	/**
	 * 指定値で初期化するコンストラクタ
	 * @param year	年
	 * @param month	月
	 * @param date	日
	 * @param maxTemperature	最大気温
	 * @param minTemperature	最低気温
	 * @param rainfall			降水量
	 * @param hoursOfDaylight	日照時間
	 */
	public WeatherData(int year, int month, int date, double maxTemperature, double minTemperature,
			double rainfall, double hoursOfDaylight) {
		
	}

	/**
	 * 月間の気象情報を出力する関数
	 * ※メソッドのアクセス修飾子は変更しないこと
	 */
	public static void showMonthlySummary() {
		System.out.println(" * 月間最高気温 = " + monthlyMaxTemperature + "℃");
		System.out.println(" * 月間最低気温 = " + monthlyMinTemperature + "℃");
		System.out.println(" * 月間降水量合計 = " + monthlyRainfall + "mm");
		System.out.println(" * 月間日照時間合計 = " + monthlyHoursOfDaylight + "時間");
	}
}
