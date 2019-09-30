package gorillaBot;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import org.riversun.slacklet.Slacklet;
import org.riversun.slacklet.SlackletRequest;
import org.riversun.slacklet.SlackletResponse;
import org.riversun.slacklet.SlackletService;
import org.riversun.xternal.simpleslackapi.SlackUser;

public class GorillaBot {

	static String url = "jdbc:mariadb://192.168.100.234/mydb";
	static String userdb = "root";
	static String password = "xxxxxxxxx";

	public static void main(String[] args) throws IOException {

		String botToken = ResourceBundle.getBundle("credentials").getString("slack.bot_api_token");

		SlackletService slackService = new SlackletService(botToken);

		// slackletを追加する
		slackService.addSlacklet(new Slacklet() {

			@Override

			// メッセージがユーザーからポストされましたよ
			public void onMessagePosted(SlackletRequest req, SlackletResponse resp) {

				// メッセージを投下したユーザーの情報を取得
				SlackUser user = req.getSender();

				// ユーザー情報の中からユーザー名を取り出し変数userNameに代入
				String userName = user.getUserName();

				// メッセージ本文を取得
				String content = req.getContent();

				if (!(userName.equals("slackbot"))) {

					// ランダムで１～１０の整数を生成
					int N;
					N = (int) (Math.random() * 10) + 1;

					// 投下されたメッセージによって条件分岐
					switch (content) {

					// 天気予報機能
					case "!weather":
						resp.reply("全国の天気はこちらウホ　" + "https://weather.yahoo.co.jp/weather/");
						break;

					case "!weather 東京":
						resp.reply("東京の天気はこちらウホ　" + "https://weather.yahoo.co.jp/weather/jp/13/4410.html");
						break;

					case "!weather 札幌":
						resp.reply("札幌の天気はこちらウホ　" + "https://weather.yahoo.co.jp/weather/jp/1b/1400.html");
						break;

					case "!weather 名古屋":
						resp.reply("名古屋の天気はこちらウホ　" + "https://weather.yahoo.co.jp/weather/jp/23/5110.html");
						break;

					case "!weather 大阪":
						resp.reply("大阪の天気はこちらやでゴリ　" + "https://weather.yahoo.co.jp/weather/jp/27/6200.html");
						break;

					case "!weather 福岡":
						resp.reply("福岡の天気はこちらウホ　" + "https://weather.yahoo.co.jp/weather/jp/40/8210.html");
						break;

					//運行情報お知らせ機能
					case "!train 総武線":
						resp.reply("JR総武線の運行情報はこちらだウホ　" + "https://transit.yahoo.co.jp/traininfo/detail/40/0/");
						break;

					case "!train 北総線":
						resp.reply("北総線の運行情報はこちらだウホ　" + "https://transit.yahoo.co.jp/traininfo/detail/141/0/");
						break;

					case "!train シーサイドライン":
						resp.reply("シーサイドラインの運行情報はこちらだウホ　" + "https://transit.yahoo.co.jp/traininfo/detail/159/0/");
						break;

					case "!train 根岸線":
						resp.reply("根岸線の運行情報はこちらだウホ　" + "https://transit.yahoo.co.jp/traininfo/detail/40/0/");
						break;

					case "!train 京成線":
						resp.reply("京成線の運行情報はこちらだウホ　" + "https://transit.yahoo.co.jp/traininfo/detail/96/0/");
						break;

					case "!train 東急目黒線":
						resp.reply("東急目黒線の運行情報はこちらだウホ　" + "https://transit.yahoo.co.jp/traininfo/detail/113/0/");
						break;

					case "!train 南北線":
						resp.reply("東京メトロ南北線の運行情報はこちらだウホ　" + "https://transit.yahoo.co.jp/traininfo/detail/139/0/");
						break;

					//ゴリラ知識機能
					case "ゴリラ":
						resp.reply("ゴリラ豆知識その" + N);
						switch (N) {

						case 1:
							resp.reply("世界の動物園で飼育されているゴリラのほとんどがニシローランドゴリラであるが、このゴリラの学名は「ゴリラ・ゴリラ・ゴリラ」である。");
							break;

						case 2:
							resp.reply(
									"ゴリラはマウンテン、ニシローランド、ヒガシローランド、クロスリバーの４種に分けられ、生息数は計２１万頭といわれる。これは文京区の人口とほぼ同じであり、文京区はゴリラ区ともいえるだろう。");
							break;

						case 3:
							resp.reply("ゴリラといえばバナナ好きのイメージを抱いている人も多いが、野生のゴリラが食べるのは堅いバナナの茎であり、人間たちが想像する黄色いバナナを食べることはない。");
							break;

						case 4:
							resp.reply("ゴリラが胸をたたく行為はドラミングと呼ばれ、2km先まで届く音が出る。すごいだろウホ。");
							break;

						case 5:
							resp.reply("ゴリラが胸をたたく際、手はグーではなくパーである。自身の胸を太鼓のように叩いているのだ。");
							break;

						case 6:
							resp.reply("ゴリラの握力は推定500kgと言われている。ライオンの噛む力が300kg前後であることを鑑みるといかに強いかがわかるだろう。");
							break;

						case 7:
							resp.reply("子どもを大事にするのもゴリラの特徴である。生まれてから少なくとも1年は赤ちゃんを離すことはない。人間どもと違ってな。");
							break;

						case 8:
							resp.reply("ゴリラは関節の成長の仕方が人と異なるため、オーバースロー（上投げ）が出来ない。ボール投げの記録であれば人はゴリラに勝てるのである。");
							break;

						case 9:
							resp.reply("1986年公開、アーノルドシュワルツェネッガー主演の映画「ゴリラ」の原題は「Raw Deal」であり、これは「不当な扱い」「ひどい仕打ち」等の意である。");
							break;

						case 10:
							resp.reply("ウッホーウッホーウッホッホー。ウホウホ！ウッホウッホウホウッホウッホッホー！");
							break;

						}

						break;

					case "!BGM":
						int random = (int) (Math.random() * 9);

						switch (random) {

						//アフリカンシンフォニー
						case 0:
							resp.reply("https://www.youtube.com/watch?v=BAv_RpEo458" + "\r\n" + "吾輩は猫ではない！ゴリラである！");
							break;

						//エルクンバンチェロ
						case 1:
							resp.reply("https://www.youtube.com/watch?v=Y1rR8v687iE" + "\r\n" + "努力は裏切らないウホ");
							break;

						//Spheres : Yorkshire
						case 2:
							resp.reply("https://www.youtube.com/watch?v=HRAjXBxh0SQ" + "\r\n" + "諦めなければ人生で敗北することはないウホ");
							break;

						//Highland :
						case 3:
							resp.reply("https://www.youtube.com/watch?v=xp8Ut7G05D0" + "\r\n" + "いつの日かは決して実現しないウホ");
							break;

						//ブラ1 : ベルリン
						case 4:
							resp.reply("https://www.youtube.com/watch?v=3xiFFmJoTnQ" + "\r\n"
									+ "着想から完成まで21年の歳月がかかったそうですが、野生のゴリラの平均寿命は35-40年と言われているそうです。"
									+ "当時22歳から書き始めたそうなのでゴリラの一生分をかけて作曲されたことになるウホ。");
							break;

						//ブル８ : ウィーン
						case 5:
							resp.reply(
									"https://www.youtube.com/watch?v=0ytSj6mSgJg" + "\r\n" + "状況は絶望的だが、未来は必ずあるはずだウホ");
							break;

						//月の光
						case 6:
							resp.reply("https://www.youtube.com/watch?v=jEc_r33ODos" + "\r\n" + "紅茶でもいかがウホ？");
							break;

						//Beethoven Piano Sonata No. 17
						case 7:
							resp.reply("https://www.youtube.com/watch?v=6KMGcOYHSs0" + "\r\n" + "少し休憩しませんかウホ？");
							break;

						//Les Miserables
						case 8:
							resp.reply("https://www.youtube.com/watch?v=Oqa49h4HWgg" + "\r\n"
									+ "フランスにゴリラをペットにする夫婦がいるらしいウホ");
							break;

						}

						break;

					case "!start":
						resp.reply("https://www.youtube.com/watch?v=pAk0e1Rohag" + "\r\n"
								+ "やってみないうちから諦めるのかい？私たちは高い目標を持っているからこそ、これほど多くのことをやり遂げられるんだ");
						break;

					case "!encore":
						resp.reply("https://www.youtube.com/watch?v=F_GjJWYTU40" + "\r\n" + "人間、限界だと思ってからもう少し行ける。");
						break;

					case "!spring":
						int random1 = (int) (Math.random() * 4);
						switch (random1) {

						case 0:
							resp.reply("https://www.youtube.com/watch?v=7SORGD1PnFc" + "\r\n" + "花粉が飛んでるウホ");
							break;

						case 1:
							resp.reply("https://www.youtube.com/watch?v=RRekUBmRlVU" + "\r\n" + "ゴリラだって花見に行きたいウホ");
							break;

						case 2:
							resp.reply("https://www.youtube.com/watch?v=F0GvYj8VJow" + "\r\n" + "きれいな桜を見つけに行くウホ");
							break;

						case 3:
							resp.reply("https://www.youtube.com/watch?v=QzOow42XSZU" + "\r\n" + "新しいことを始めてみるウホ");
							break;
						}

						break;

					case "!summer":
						int random2 = (int) (Math.random() * 4);

						switch (random2) {

						case 0:
							resp.reply("https://www.youtube.com/watch?v=q9rqedDDNxE" + "\r\n "
									+ "水分と塩分をこまめにとって熱中症には気を付けるウホ");
							break;

						case 1:
							resp.reply("https://www.youtube.com/watch?v=VoiWcOmIg2s" + "\r\n" + "塩飴は持ったウホか？");
							break;

						case 2:
							resp.reply(
									"https://www.youtube.com/watch?v=hHkbravdbB8&list=PLVSflsp5xI9Bp2g4XxmtKeLwak2KwAvwc"
											+ "\r\n" + "レインボーブリッジまでドライブだウホ");
							break;

						case 3:
							resp.reply("https://www.youtube.com/watch?v=eJHgxkvtNoM"
									+ "コンクールは夏なのに最近タイトルに春関係のワードが入ってる曲多いウホね。");
							break;

						}

						break;

					case "!autumn":
						int random3 = (int) (Math.random() * 4);

						switch (random3) {

						case 0:
							resp.reply("https://www.youtube.com/watch?v=_EUvNjsCxVc" + "\r\n" + "芸術の秋より食欲の秋ウホ");
							break;

						case 1:
							resp.reply("https://www.youtube.com/watch?v=Im43R4chyiw" + "\r\n"
									+ "秋を表すFallとAutumnの違いは アメリカ英語「Fall」かイギリス英語「Autumn」かというシンプルな違いなのですが、元々は両国とも同じ言葉が使われていたようウホ");
							break;

						case 2:
							resp.reply("https://www.youtube.com/watch?v=WBBE0u2Fg2E" + "\r\n" + "トリック・オア・バナナ！");
							break;

						case 3:
							resp.reply("https://www.youtube.com/watch?v=lOU7v6-WkkI" + "\r\n" + "秋は月見がしたいウホ");
							break;

						}

						break;

					case "!winter":
						int random4 = (int) (Math.random() * 4);

						switch (random4) {

						case 0:
							resp.reply("https://www.youtube.com/watch?v=Ej6TX3JZr7s" + "\r\n" + "寒さに負けないウホ");
							break;

						case 1:
							resp.reply("https://www.youtube.com/watch?v=HKKe7p44PDY" + "\r\n"
									+ "炬燵に蜜柑、そんな理想の冬を経験したことのある人間はどれほどいるウホか");
							break;

						case 2:
							resp.reply("https://www.youtube.com/watch?v=W8zrGhyK7rI" + "\r\n" + "クリスマスと正月、どっちが好きウホ？");
							break;

						case 3:
							resp.reply("https://www.youtube.com/watch?v=RA5JVBYSzrE" + "\r\n" + "お餅を食べすぎないでね！");
							break;
						}

						break;

					}

					//挨拶機能
					if (content.contains("おはよ") || content.contains("おはー") || content.contains("morning")) {
						resp.reply("≦(o･ｪ･o)≧ウッホ！ウッホ！");
						resp.reply("(訳:おはよう)");
					}

					else if (content.contains("こんにちは") || content.contains("こんちは") || content.equals("hello")) {
						resp.reply("≦(o･ｪ･o)≧ウッホーウッホーウッホッホー！");
						resp.reply("(訳:こんにちは)");
					}

					else if (content.contains("こんばん") || content.contains("evening")) {
						resp.reply("≦(o･ｪ･o)≧ウホウホ！ウッホッホー！");
						resp.reply("(訳:こんばんは)");
					}

					else if (content.contains("おやす") || content.contains("night")) {
						resp.reply("(￣••￣)zzz｡o〇○");

					} else if (content.contains("ウホ")) {
						resp.reply("🦍ウホッ!!");

					} else if (content.contains("ドラミング")) {
						resp.reply("🦍ドコドコポコポコ！");

					}

					// リマインダー機能
					if (content.contains("!timer")) {
						resp.reply("了解ウホ！時間になったらお知らせするゴリ！");

						String[] bun1 = content.split("\\.");
						int x = Integer.parseInt(bun1[1]);
						int y = x * 60000;

						TimerTask task = new TimerTask() {
							public void run() {
								slackService.sendDirectMessageTo(userName, bun1[2] + "の時間になったウホ。まあ無理せずがんばれよ。ウホ。");
							}
						};

						Timer timer = new Timer();
						timer.schedule(task, y);
					}

					if (content.equals("おみくじ")) {
						resp.reply("おみくじを引くゴリ！");

						int num = (int) (Math.random() * 7) + 1;
						int i = (int) (Math.random() * 3);

						resp.reply("あなたの今日の運勢は……");

						if (num == 7) {
							resp.reply("　大凶　だウホ！");

							if (i == 3) {
								resp.reply("今日は気を付けて過ごしましょう！ウホ！");

							} else if (i == 2) {
								resp.reply("ここから運気が上がって行くかな…。ウホ！");

							} else {
								resp.reply("ある意味運がいいかも!?ウホ！");
							}

						} else if (num == 6) {
							resp.reply("　凶　だウホ！");

							if (i == 3) {
								resp.reply("今日はあまり良くない一日でしょう。ウホ！");

							} else if (i == 2) {
								resp.reply("何かが起きそうな予感…。ウホ！");

							} else {
								resp.reply("注意して過ごしましょう…。ウホ！");
							}

						} else if (num == 5) {
							resp.reply("　大吉　だウホ！");

							if (i == 3) {
								resp.reply("使ったお金が戻ってくるかも!?ウホ！");

							} else if (i == 2) {
								resp.reply("とてもいい運気！でも油断は禁物!?ウホ！");

							} else {
								resp.reply("何をしてもうまくいきそう！ウホ！");

							}

						} else if (num == 4) {
							resp.reply("　中吉　だウホ！");

							if (i == 3) {
								resp.reply("今日はまあまあいい日になるでしょう。ウホ！");

							} else if (i == 2) {
								resp.reply("新しい趣味で散財してしまうかも…。ウホ！");

							} else {
								resp.reply("予定通りに事が進むでしょう。ウホ！");

							}

						} else if (num == 3) {
							resp.reply("　末吉　だウホ！");

							if (i == 3) {
								resp.reply("今日は悪くない一日でしょう。ウホ！");

							} else if (i == 2) {
								resp.reply("計画を十分練って生活しよう。ウホ！");

							} else {
								resp.reply("掃除して気分リフレッシュ！ウホ！");

							}

						} else if (num == 2) {
							resp.reply("　小吉　だウホ！");

							if (i == 3) {
								resp.reply("今日はそこそこの一日でしょう。ウホ！");

							} else if (i == 2) {
								resp.reply("50%の確率で願い事が叶いそう。ウホ！");

							} else {
								resp.reply("奇跡的な一瞬に出会えるかも。ウホ！");

							}

						} else {
							resp.reply("　吉　だウホ！");

							if (i == 3) {
								resp.reply("今日は普通の一日でしょう。ウホ！");

							} else if (i == 2) {
								resp.reply("今日は無難な一日でしょう。ウホ！");

							} else {
								resp.reply("今日は平凡な一日でしょう。ウホ！");

							}

						}

					}

					if (content.equals("!train")) {
						resp.reply(userName + "さんが使う路線の運行情報はこちらウホ");

						String sql = "SELECT * FROM user";
						String un, tr;

						// データベースに接続
						try (Connection conn = DriverManager.getConnection(url, userdb, password);

								PreparedStatement ps = conn.prepareStatement(sql);) {

							ResultSet rs = ps.executeQuery();

							for (;;) {

								rs.next();
								un = rs.getString(1);

								if (userName.equals(un)) {
									tr = rs.getString(2);
									resp.reply(tr);
								}
							}

						} catch (SQLException e) {
							e.printStackTrace();

						}

						switch (N) {

						case 1:
						case 2:
						case 3:
							resp.reply("こんな鉄の箱を使わないと移動もできないとは人間とは愚かな種族ウホねえ");

							break;

						case 4:
						case 5:
						case 6:
							resp.reply("台湾にはバナナをイメージした電車があるらしいウホ。乗ってみたいゴリ。");

							break;

						case 7:
						case 8:
						case 9:
						case 10:
							resp.reply("いつも電車が動いているのが当たり前だと思わず、動かしてくれている人たちに感謝をしなさい。ウホ。");
						}
					}

					if (!(content.equals("ゴリラ")) && content.contains("ゴリラ")) {
						resp.reply("呼んだか？");
					}

				}

			}

		});

		// slackletserviceを開始(slackに接続)
		slackService.start();

	}

}