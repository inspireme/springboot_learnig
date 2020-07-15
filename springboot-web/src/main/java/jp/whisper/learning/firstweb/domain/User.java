package jp.whisper.learning.firstweb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザー情報
 *
 * @author cndone
 */

/**
 *@Data アノテーションToString, EqualsAndHashCodeの機能を含んで、すべての属性に対して、getterメソッドを生成する。
 *さらに、non-finalの属性にたいして、setterメソッド（@Setter）とコンストラクタメソッド（@RequiredArgsConstructor）を自動生成する
 *
 *@Budilder 対象のビルダーを生成する。ビルダーパターンをご参考
 *
 *詳しくはhttps://projectlombok.org/features/index.htmlをご参考
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;
    private String name;
    private String kanaName;

}
