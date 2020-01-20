# タイトル: 課題レポート6: Java最終課題（ソケットを利用した通信-curlになんて負けない-）
### 195755E
### 宮良一生

## リポジトリのURL: https://github.com/Issei0804-ie/report6

## 課題説明
1. ソケットを用いてコンピュータ間でTCP通信を行い、データを送受信する。
2. また、上記を応用してHTTPServerを構築する。

### 取り組み方
まずコードを書く前にシーケンス図を用いて 1 の課題を取り組む順序を決める。

<img src="image-socket.png" width=400>

---

次にクラス図を書き、骨組みを作る。先ほどのシーケンス図を参考にしてフィールド変数やメソッドを記述している。実際にこのクラス図で動くわけではなく、後々少し修正する。

<img src="image-class.png" width=400>


まずサーバー側からコーディングしていく。
調べたところ `java.net.Socket` というパッケージを使用することにより通信できそうなので使用した。接続が確認できると何かしらのデータを返すサーバーを準備する。

Mainクラス

``` Java
Server server = new Server(8080);
 server.listen();
 int e = server.listen();
 if (e != 1){
     System.out.println("ConnectionError");
 }
 server.read();
```

まずインスタンスを生成する。その際にバインドするポートの番号を渡す。次に与えられたポートを使用してServerでソケットを用意し、クライアントとコネクトする。戻り値を返しているが、それは何かしらコネクションにエラーがあった際に int でそのエラーを知らせる仕組みにしたかった。しかし、最終的にはエラー処理等は全てメソッド内で解決するようにした。その理由はServerに関する処理はエラーも含めそのクラスで解決するほうが良いと考えたからだ。

<br>
ここからはHTTPServerを構築していく。
ここで、私が使用していたクラスに `InputStream` というクラスがあったのだが、色々と調べていくうちにラッパークラスという `InputStream` を使用しやすく加工したクラスがあることを知った。そのため、今後は `PrintStream` と `BufferedReader` というクラスを使用していく。

その前に実装する内容を考える。

- GETだけを処理する
- クライアントがどこにアクセスしたか表示する。

世間一般論、これがHTTPServerと称して良いかわからないくらい機能がないが、とりあえず今回はこのように定義する。

例えば、クライアントからGETのリクエストがきた場合、クライアントがアクセスした場所を返せばいいので、サーバーの処理を下記に示す。

- リクエストヘッダーからエンドポイントをパース
- レスポンスヘッダーを構築
- Bodyをセット(リクエストヘッダー)
- レスポンスを送信

クラス図

<img src="ClassOFServer.svg" width=400>

とりあえず各クラスを実装していく。

<br>
実装後のMainクラスが下記である。

```java
public class Main {
    public static void main(String[] args){
        int port = 8080;

        ArrayList<Route> routes = new ArrayList<Route>();
        routes.add(new Route("/index.html", "index.html"));
        routes.add(new Route("/hogehoge","hoge"));
        HTTPServer server = new HTTPServer(8080, routes);
        server.listen();
        server.close();
    }
}
```

Routeクラスでは指定されたパスにアクセスされた場合、返す静的ファイルを指定できる。それらをリスト化し、HTTPServerに引数として渡すことにより、ルーティングを行ってくれる。その後、listenメソッドを呼び出すとポートにバインドしたりするなど、WebServerとして必要な動作を行ってくれる。

エンドポイントにアクセス後、ルーティングの結果によってステータスコード(200と404)を返す実装まではできた。現時点でのクラス図は下記である。
<br><br>

<img src="Class_now.svg" width=500>

<br><br>

期限が目前なので以上で終了します。
実際にWebブラウザ(Chrome)から確認することもできますので、お手数ですがお試しください。(localhost:8080)


## コード解説

この課題で実装したメソッドの一つとしてはServer.javaのlistenメソッドがある。ソケットの概念が難しく、少ないコードだが多くの時間をかけた。また、javaのラッパークラスを使用して実装を楽に行った。

```java
public void listen() {
    try{
        System.out.println("*****\nWaitClient\n*****\n");
        socket = ssocket.accept(); //接続されると別ソケットを作成
        writer = new PrintStream(socket.getOutputStream()); //ラッパーを使用した。
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("*****\nConnectClient\n*****\n");
    }catch (java.io.IOException e){
        e.printStackTrace();
        System.out.println("*****\nConnectionError*****\n");
    }
}
```

## 実行結果

実際のルーティング処理

```
$ curl -LI localhost:8080/index.html -o /dev/null -w '%{http_code}\n' -s
200
$ curl -LI localhost:8080/hoge -o /dev/null -w '%{http_code}\n' -s
404
```

## 考察

全体的にエラー処理が雑である。また、全体的にコメントが少なかった。クラス設計をもう少し頑張れば楽な実装になったはずである。しかし、ソケット通信という概念を自力で実装できたことはこれから様々な情報系講義等で必ず役に立つであろう。理由はソケットを使用しないサービスはほぼ無いからである。
