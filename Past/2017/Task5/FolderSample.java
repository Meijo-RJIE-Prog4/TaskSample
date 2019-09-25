import java.io.File;

/**
 * 発展課題5Aのヒント：ディレクトリおよびファイルの一覧取得サンプル
 * @author Hidekazu Suzuki
 * @version 1.0. 2014/11/25
 */
public class FolderSample {
	
	/**
	 * メインメソッド
	 * @param args	ディレクトリパス（指定しなくてもよい）
	 */
    public static void main(String[] args) {
    	String path;
    	if (args.length == 1) {
    		// コマンドライン引数で指定されたパスを取得
    		path = args[0];
    	} else {
    		// コマンドライン引数で指定が無い場合はカレントディレクトリのパスを取得
    		path = System.getProperty("user.dir");
    	}
		System.out.println(path);
		
		// 指定されたディレクトリのインスタンスを生成
		File directory = new File(path);
		// 指定したディレクトリ内に存在するディレトリとファイルの一覧を取得
		File[] files = directory.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			/*
			 * 取得したディレクトリ名とファイル名を出力する．
			 * なお，参照しているインスタンスの種類に応じて"D","F"を表記する．
			 * - isDirectory()メソッドでディレクトリかどうかを判定
			 *   （isFile()メソッドでファイルかどうかを判定してもよい）
			 * - getName()メソッドでディレクトリ名またはファイル名を取得
			 */
			if (file.isDirectory())
				System.out.println((i + 1) + ":D: " + file.getName());
			else
				System.out.println((i + 1) + ":F: " + file.getName());
		}
	}
}
