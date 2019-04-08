## spring boot properties

##### 検証ポイント
- クラスフィールドに設定値を利用する(SPEL)
- プロパティファイルにSPELを使い方
- ランダム(SPELにrandomの利用)
- application.properties以外に自分で作ったファイルを利用する(@PropertySourceで実現)
- キーのprefixが一緒である設定値に対して、@ConfigurationProperties(prefix)を利用する

##### propertyの注釈をカスタマイズ ([configuration-metadata](https://docs.spring.io/spring-boot/docs/current/reference/html/configuration-metadata.html, "configuration-metadata")を参考)

>\src\main\resources\META-INF\additional-spring-configuration-metadata.json`を作ることで、propertyの注釈をカスタマイズ可能。



>the annotation processor automatically merges items from META-INF/additional-spring-configuration-metadata.json into the main metadata file.

