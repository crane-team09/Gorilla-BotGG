# Gorilla-Bot
Slack上で稼働するBot

天気予報やリマインダー等、あなたの生活を便利にしてくれる機能を搭載

ゴリラとの会話を楽しんでください

## 機能一覧

**1.挨拶機能**

挨拶に対して返答してくれる機能


**2.天気予報機能**

「!weather」とメッセージを投下すると全国の天気を教えてくれる機能

「!weather (地名)」とメッセージを投下するとその地方の天気予報ページのurlを表示（札幌、東京、名古屋、大阪、福岡に対応）
(ex.)「!weather 東京」とメッセージを投下→東京の天気を表示

  **3.運行情報表示機能**

  「!train」とメッセージを投下すると、登録されている路線の運行情報を表示する機能

 「!train (路線名）」とメッセージを投下すると指定した路線の運行情報を表示

 (ex.)「!train 総武線」とメッセージを投下→総武線の運行情報を表示


 **4.リマインダー機能**

 「!timer.(時間).(予定)」とメッセージを投下すると、設定した時間にダイレクトメッセージを送ってくれる機能

   (ex.)「!timer.4.ミーティング」を投下すると4分後に「ミーティングの時間です」とダイレクトメッセージを送信する



  **5.ゴリラ知識機能**

  ゴリラに関する豆知識をランダムで教えてくれる機能

「ゴリラ」を送信すると9種類の中からランダムで一つ豆知識を表示


   文章中に「ゴリラ」が含まれていると「呼んだか？」と反応する

   **6.おみくじ機能**

   今日の運勢を占ってくれる機能

   「おみくじ」を入力すると今日の運勢とメッセージを送ってくれる

   **7.BGM機能**

   おすすめの曲をランダムで表示してくれる機能

   「!BGM」「!start」「!encore」「!spring」「!summer」「!autumn」「!winter」のいずれかのメッセージを投下すると
   ランダムでおすすめの曲のURLとメッセージを投下


## 必要なライブラリ
Slackletのjarファイル
https://search.maven.org/artifact/org.riversun/slacklet/1.0.4/jar

MariaDBのjarファイル
 https://downloads.mariadb.org/connector-java

 上記2つのファイルをダウンロードしてください

## BOT用API Tokenの取得
1.以下のurlに飛ぶ
https://my.slack.com/services/new/bot

2.Botのusernameを決め、[Add bot integration]をクリック

3.API Tokenが生成され、[xoxb-〇〇〇〇〇〇]の形で画面に表示される

（参照ページ：https://qiita.com/riversun/items/25f64f285699223a992d
)

## Eclipseへのインポートと実行

### Eclipseへのインポート

1.ファイル>インポート>Git - Gitからプロジェクト

2.クローン URIを選択

3.New-Gorilla-BotリポジトリのURL(https://github.com/crane-team09/New-Gorilla-Bot )をロケーションのURIに貼り付け

4.適宜[次へ]を押していく

5."一般的なプロジェクトしてインポート"をチェックして、"完了"  を押す


### プロジェクトのmaven化

1.プロジェクト上で、右クリック

2.構成>maven プロジェクトに変換

3.(これでmaven projectとしてEclipseに読み込まれます)


### Slack\_bot\_API\_tokenをセットする

上記で取得したAPI Tokenをセットします

1.src/main/javaの直下にcredentials.propertiesというファイルを作成

2.取得したappのページからxoxo- で始まるAPI Tokenをコピー

3.credentials.propertiesにAPI Tokenをセット

（参照： https://qiita.com/riversun/items/25f64f285699223a992d )


```
slack.bot_api_token=xoxb-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
```
### ライブラリーをセットする

1.プロジェクト上で右クリック

2.ビルドパス>ビルドパスの構成

3.Javaのビルドパス>ライブラリータブを選択

4.外部jarの追加を選択

5.上記「必要なライブラリ」でダウンロードした2つのjarファイルを追加

6.適用して閉じる


