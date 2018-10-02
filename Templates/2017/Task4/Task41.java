/**
 * 3次元空間上の点を扱う基本課題4.1
 */
public class Task41 {

	public static void main(String[] args) {
		// 原点に点P1を生成
		
		System.out.println("点P1" + p1.toString() + "を生成しました．");
		
		// キーボードで指定した座標に点P2を生成
		System.out.print("点P2の座標を入力して下さい[x y z]: ");
		
		System.out.println("点P2" + p2.toString() + "を生成しました．");

		// キーボードで点P2の移動量を入力して移動させる
		System.out.print("点P2の移動量を入力して下さい[dx dy dz]: ");

		System.out.println("移動後の点P2の座標 = " + p2.toString());
	}

}
