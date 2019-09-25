package jp.ac.meijo_u.remotepicalculator;

import android.os.AsyncTask;

import java.io.*;
import java.net.*;

/** Task53Serverと通信処理を行うバックグラウンドタスク */
public class CommunicationTask extends AsyncTask<Void, String, Boolean> {
    /** 接続先サーバIPアドレス */
    private String serverIP;
    /** 接続先サーバポート番号 */
    private int serverPort;
    /** 演算回数 */
    private long count;
    /** 演算時間 */
    private long time;
    /** 演算した円周率 */
    private double pi;

    private MainActivity mainActivity;

    /**
     * GUIで指定されたパラメータにより初期化するコンストラクタ
     * @param serverIP		接続先サーバIPアドレス
     * @param serverPort	接続先サーバポート番号
     * @param count			演算回数
     */
    public CommunicationTask(String serverIP, int serverPort, long count, MainActivity mainActivity) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        this.count = count;
        this.mainActivity = mainActivity;
    }

    /**
     * 演算時間を取得するゲッターメソッド
     * @return 演算時間
     */
    public long getTime() {
        return this.time;
    }

    /**
     * 演算した円周率を取得するゲッターメソッド
     * @return 演算した円周率
     */
    public double getPi() {
        return this.pi;
    }

    /**
     * バックグラウンド処理を行うメソッド
     * @param params    バックグラウンド開始元側から渡される可変長Void型のオブジェクト（今回は使用しない）
     * @return 処理結果（成功: true，失敗: false）
     */
    @Override
    protected Boolean doInBackground(Void... params) {
        Socket socket = null;
        DataInputStream socketDIS = null;
        DataOutputStream socketDOS = null;
        boolean result = false;

        try {
            // ソケットの生成
            socket = new Socket();
            // サーバに接続するために必要なIPソケットアドレスインスタンスを生成
            InetSocketAddress address = new InetSocketAddress(serverIP, serverPort);
            // ソケットとIPソケットアドレスを用いてサーバに接続
            socket.connect(address);

            // ソケットから入出力ストリームを取り出し，データ入出力ストリームを連結
            socketDIS = new DataInputStream(socket.getInputStream());
            socketDOS = new DataOutputStream(socket.getOutputStream());

            // サーバに演算回数を送信
            socketDOS.writeLong(count);
            socketDOS.flush();

            // サーバから演算開始の通知を受信
            String message = socketDIS.readUTF();
            publishProgress(message);

            // サーバから演算時間と演算結果を受信
            time = socketDIS.readLong();
            pi = socketDIS.readDouble();

            result = true;
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        } finally {
            // 入出力ストリームをクローズする
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
            // ソケットをクローズする
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    /**
     * バックグラウンドタスク開始時に呼び出されるメソッド
     */
    @Override
    protected void onPreExecute() {
        // コールバックメソッドを実行
        mainActivity.setButtonEnabled(false);
    }

    /**
     * バックグラウンドタスク実行時にpublishProgress()メソッドにより呼び出されるメソッド
     * @param values    コールバックメソッドへ渡す文字列（可変長引数）
     */
    @Override
    protected void onProgressUpdate(String... values) {
        mainActivity.showToast(values[0]);
    }

    /**
     * バックグラウンドタスク完了時に呼び出されるメソッド
     * @param result    コールバックメソッドへ渡すBoolean値（可変長引数）
     */
    @Override
    protected void onPostExecute(Boolean result) {
        mainActivity.showResult(result);
    }

}
