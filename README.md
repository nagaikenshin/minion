minion - オブジェクトデータ交換支援クラス
====================================

概要
----

minionは概ね次の3つの機能を組み込んでおり、 中心クラス（My）からシステムのどこからでも簡便かつ共通的に呼び出すことを目的としています。

* ハッシュ関数
* JSON関数（[GSON](https://github.com/google/gson)）
* camelize等（[ModeShape](https://github.com/ModeShape/modeshape)のInflector）

JSONの一種としてのminion
----------------------

minionに組み込まれたGSONは、通常のものと比べてJSONシリアライズに次の規則を加えています。これにより生成されるJSON文字列が一意になります。（もちろん一般のJSONデシリアライザで読み取れます。）

* キーをASCII順にソートする。
* エスケープ文字の変換規則を一通りに定める。

通常のJSONと区別する場合、特にminionと呼ぶことにします。
