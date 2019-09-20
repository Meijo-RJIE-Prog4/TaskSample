# 2019年度プログラミング演習Ⅳ　基本課題1



## 基本課題1.1

ファイルサイズとスループットをキーボードから入力し，ダウンロード時間を表示するプログラムを作成せよ．

#### 仕様：

- クラス名は`Task11`とする．
- 次の仕様を満たすメソッド`getDownloadTime()`を定義して使用する．
  - 第1引数：ファイルサイズ（整数値，単位：GB），第2引数：スループット（実数値，単位：Mbps）
  - 戻り値：ダウンロード時間の文字列（出力フォーマット：$h$時間$m$分$s$秒
    - ただし，60分未満なら$h$時間は出力しない．
    - $m \neq 0$となる場合のみ$m$分を出力すること．
- 1GB=1,024MB，1MB=1,024KB，1KB=1,024B，1B=8bitとする．

#### 実行例：

```shell-session
ファイルサイズ（GB）： 2
スループット（Mbps）： 7.2
予想ダウンロード時間：37分55秒
```



## 基本課題1.2

じゃんけんゲームを作成せよ．

#### 仕様：

* クラス名は`Task12`とする．
* ゲーム開始時にプログラムがランダムにグー（$r=0$），チョキ（$r=1$），パー（$r=2$）のいずれかを決定する．整数乱数$r$の生成は教科書pp.89-90に掲載されている`java.util.Random`クラスの`nextInt()`メソッドを利用すること．
* プレーヤーがキーボードで整数値$i$を入力し，出す手を決める．入力が不適切な場合は再度入力を求めること．
* じゃんけんの結果を表示し，勝ち負けが決まればプログラムを終了する．引き分けだった場合は繰り返す．

#### 実行例：

```shell-session
### じゃんゲーム ###
じゃんけん
（0:グー，1:チョキ，2:パー）> 0
ポン！　あなた「グー」，相手「パー」　負け
```

```shell-session
### じゃんゲーム ###
じゃんけん
（0:グー，1:チョキ，2:パー）> 1
ポン！　あなた「チョキ」，相手「チョキ」　あいこで
（0:グー，1:チョキ，2:パー）> 3
（0:グー，1:チョキ，2:パー）> 2
ポン！　あなた「パー」，相手「グー」　勝ち
```



## 基本課題1.3

次の表の行と列を入れ替えるプログラムを作成せよ．

| 日付 | 平均気温 | 最高気温 | 最低気温 | 平均湿度 | 降水量 |
| ---- | -------- | -------- | -------- | -------- | ------ |
| 9/1  | 24.5     | 26.9     | 23.4     | 85       | 14.5   |
| 9/2  | 25.6     | 30.6     | 22.4     | 72       | 1.5    |
| 9/3  | 26.7     | 32.3     | 22.8     | 68       | 3.0    |

#### 仕様：

- クラス名は`Task13`とする．
- 表データは2次元配列で管理すること．
- 次の仕様を満たす行と列を入れ替えるメソッド`showTable()`を定義して使用する．
  - 第1引数：表データ
  - 戻り値：なし
  - **拡張for文**を利用して表示すること．その際，各列の先頭が揃うように表示すること．
- 次の仕様を満たす行と列を入れ替えるメソッド`transpose()`を定義して使用する．
  - 第1引数：元の表データ
  - 戻り値：行と列を入れ替えた表データ
  - **通常のfor文**を利用してデータを設定すること．
- 入れ替え前後の表を出力すること．

#### 実行例：

```shell-session
元の表：
日付	平均気温	最高気温	最低気温	平均湿度	降水量	
9/1		24.5		26.9		 23.4			85			14.5	
9/2		25.6		30.6		 22.4			72			1.5	
9/3		26.7		2.3			 22.8			68			3.0	

入れ替え後の表：
日付　　 9/1     9/2     9/3	
平均気温 24.5    25.6    26.7	
最高気温 26.9    30.6    32.3	
最低気温 23.4    22.4    22.8	
平均湿度 85      72      68	
降水量　 14.5	   1.5     3.0
```

※表示上，各列の先頭が左揃えになっていないように見えるが，プログラムの出力は揃えること．




## 基本課題1.4

指定した値未満の最大素数を求めるプログラムを作成せよ．

#### 仕様：

- クラス名は`Task14`とする．
- 値の指定はコマンドライン引数から行うこと．コマンドライン引数が指定されていない場合や，入力された値が不適切な場合（1未満）は，`System.exit(1);`でプログラムを終了する．
- 素数を求めるために**エラトステネスのふるい**を利用すること（アルゴリズム・データ構造Ⅰで学習済み）．
- エラトステネスのふるいで使用する配列はboolean型とすること．
- 指定した値未満の素数が見つからない場合は，その旨を表示すること．

#### 実行例：

```shell-session
> java Task14 1000
1000未満の最大素数は997
```

```shell-session
> java Task14
コマンドライン引数に数値が指定されていません．プログラムを終了します．
```

```shell-session
> java Task14 0
コマンドライン引数に不正な値が指定されました．プログラムを終了します．
```

```shell-session
> java Task14 2
2未満の素数はありません．
```



----

### 課題の提出方法

- `学生番号_1`フォルダを作成し，その中に下記のファイルを格納する．
  
  - 基本課題1.1〜1.4のJavaソースファイル（*.javaファイル）
  
    - 各ソースコードの先頭に指定された形式で学籍番号と氏名をコメントで記載しているか確認すること．
  
    - ```java
      /**
       * 基本課題1.1　メインクラス
       * @author 180441xxx　名城太郎
       */
      ```
- 上記フォルダをZIP圧縮する．ZIPファイル名は`学籍番号_1.zip`とする．
  
  - 例：学籍番号が180441xxxの場合　→　`180441xxx_1.zip`
- 作成したZIPファイルをGoogle Classroomの「基本課題1」から提出する．
  
  - 提出期限までに再提出する場合，ファイル名は同じとし，上書きアップロードすること．