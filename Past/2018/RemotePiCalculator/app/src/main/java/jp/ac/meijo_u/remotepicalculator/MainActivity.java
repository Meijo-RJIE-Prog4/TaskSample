package jp.ac.meijo_u.remotepicalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private EditText editServerIP, editServerPort, editCount;
    private Button buttonConnect;
    private TextView textPi, textError, textTime;
    private CommunicationTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // GUIコンポーネントの取得
        editServerIP = (EditText)findViewById(R.id.editServerIP);
        editServerPort = (EditText)findViewById(R.id.editServerPort);
        editCount = (EditText)findViewById(R.id.editCount);
        buttonConnect = (Button)findViewById(R.id.buttonConnect);
        textPi = (TextView)findViewById(R.id.textPi);
        textError = (TextView)findViewById(R.id.textError);
        textTime = (TextView)findViewById(R.id.textTime);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }public void handleButtonConnectAction(View view) {
        // サーバIPアドレスの取得
        String serverIP = editServerIP.getText().toString();
        // 入力されていない場合は警告ダイアログを表示
        if (serverIP.equals("")) {
            showAlertDialog("Please input server IP.");
            return;
        }

        // サーバポート番号を取得
        String tmp = editServerPort.getText().toString();
        // 入力されていない場合は警告ダイアログを表示
        if (tmp.equals("")) {
            showAlertDialog("Please input server Port.");
            return;
        }
        int serverPort = Integer.parseInt(tmp);

        // 演算回数を取得
        tmp = editCount.getText().toString();
        // 入力されていない場合は警告ダイアログを表示
        if (tmp.equals("")) {
            showAlertDialog("Please input count.");
            return;
        }
        long count = Long.parseLong(tmp);

        // サーバと通信するバックグラウンドタスクを生成・開始
        task = new CommunicationTask(serverIP, serverPort, count, this);
        task.execute();

        Toast.makeText(this, "Start!", Toast.LENGTH_SHORT).show();
    }

    public void setButtonEnabled(boolean enabled) {
        buttonConnect.setEnabled(enabled);
    }

    public void showResult(boolean result) {
        buttonConnect.setEnabled(true);
        Toast.makeText(this, (result) ? "Success!" : "Failed...", Toast.LENGTH_LONG).show();
        long time = task.getTime();
        double pi = task.getPi();
        textTime.setText(String.valueOf(time) + "ms");
        textPi.setText(String.valueOf(pi));
        textError.setText(String.valueOf(Math.PI - pi));
    }

    /**
     * 警告ダイアログを表示するメソッド
     * @param message	警告メッセージ
     */
    private void showAlertDialog(String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Error!");			// ダイアログタイトルの設定
        dialog.setMessage(message);			// ダイアログメッセージの設定
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialog.show();
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
