import java.io.*;
import java.net.*;

/** 基本課題5.3：円周率計算プログラム（サーバ） */
public class Task53Server {
	/** 最大接続数（10クライアント） */
	private static final int MAX_CONNECTION = 10;
	/** サーバソケット */
	private static ServerSocket serverSocket;

	/**
	 * mainメソッド
	 * @param args	[0] リッスンポート番号
	 */
	public static void main(String[] args) {
		// コマンドライン引数の数をチェック
		if (args.length != 1) {
			System.out.println("引数が適切ではありません．");
			System.out.println("usage: Task53Server port");
			System.exit(1);
		}
		// コマンドライン引数からサリッスンするポート番号を設定
		int port = Integer.parseInt(args[0]);

		// ソケット変数の宣言
		Socket socket = null;
		DataInputStream socketDIS = null;
		DataOutputStream socketDOS = null;
		try {
			// サーバソケットの生成
			serverSocket = new ServerSocket();
			serverSocket.setReuseAddress(true);
			// 指定ポート番号にバインド
			serverSocket.bind(new InetSocketAddress(port), MAX_CONNECTION);
			System.out.println("ポート" + port + "番をリッスン中...");

			while (true) {
				/*
				 *  クライアントからの接続要求を待機（クライアント接続するまでブロッキング）
				 *  - 接続が完了すると，クライアントと通信するためのソケットが生成される
				 */
				socket = serverSocket.accept();

				// 接続したクライアントの情報を表示
				showClientInformation(socket);
				// ソケットの入出力ストリームを取得し，データ入力ストリームを連結
				socketDIS = new DataInputStream(socket.getInputStream());
				socketDOS = new DataOutputStream(socket.getOutputStream());

				// クライアントから演算回数を受信
				long n = socketDIS.readLong();	// long型8バイト
				// 円周率を計算するインスタンスを生成
				PiCalculator calculator = new PiCalculator(n);
				
				// クライアントへ送信するメッセージを作成
				System.out.println("クライアントへ演算を開始することを通知します.");
				String message = createMessage(socket);
				// クライアントへメッセージを送信
				socketDOS.writeUTF(message);
				socketDOS.flush();

				// 円周率の計算処理を実行
				System.out.print("演算回数" + n + "で円周率を演算開始...　");
				calculator.calculatePi();
				System.out.println("演算終了\n");

				// クライアントへ演算時間と演算結果を送信
				long time = calculator.getTime();
				double pi = calculator.getPi();
				double error = calculator.getError();
				System.out.println("クライアントへ演算結果[処理時間=" + time + "ms, pi=" + pi +
						", 誤差=" + error + "]を返信します．");
				socketDOS.writeLong(time);		// 処理時間（long型8バイト）
				socketDOS.writeDouble(pi);		// 演算結果（double型8バイト）
				socketDOS.writeDouble(error);	// 誤差（double型8バイト）
				socketDOS.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// データ送受信用ストリームを閉じる
			if (socketDIS != null)
				try {
					socketDIS.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (socketDOS != null)
				try {
					socketDOS.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			// ソケットを閉じる
			if (serverSocket != null)
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (socket != null)
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/**
	 * 接続したクライアントの情報を表示するメソッド
	 * @param socket	接続済みソケットオブジェクト
	 */
	private static void showClientInformation(Socket socket) throws IOException {
		// クライアントのIPアドレスを取得
		InetAddress address = socket.getInetAddress();
		// クライアントのポート番号を取得
		int port = socket.getPort();

		System.out.println("クライアント[" + address.toString() + ":" + port + "]が接続しました．");
	}

	/**
	 * クライアントに送信するメッセージを作成するメソッド
	 * @param socket	接続済みソケットオブジェクト
	 * @return	作成したメッセージ
	 */
	private static String createMessage(Socket socket) {
		// サーバのホスト名（またはIPアドレス）を取得
		String hostName = socket.getLocalAddress().getHostName();
		String message = "サーバ" + hostName + "が演算を開始しました．\n";
		return message;
	}
}
