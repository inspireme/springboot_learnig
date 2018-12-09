## 初めてのspringboot web app

### prjのフォルダ構成の説明
- src/main/java/jp.whisper.learning.firstweb.SpringbootWebApplication
>埋め込んだサーバー（tomcat,jettyなど）を利用し、APPを起動するクラス
- src/main/resources/static
>静的なリソースを置く場所。（js/css/imagesなど）
- src/main/resources/templates
>htmlテンプレートを置く場所。
- src/main/resources/application.propertiesやsrc/main/resources/bootstrap.properties
>APP起動するときにロードされる設定値など。後者の優先度が高い



### 検証ポイント
- 外部立ち上げられたサーバーの代わりに, 埋め込んだコンテナーを利用する
- restfull serviceを立ち上げる
- lombokを利用して、通常domain class に作らなければならないgetter/setterメソッドを省くことが可能。さらに@Slf4jを利用することで、log（slf4j loggerインスタンス）を生成してくれる
- application.propertiesに設定値を変えることで、サーバーのポートが変更される
