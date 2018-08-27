minion - Object data exchange helper
====================================

Overview
--------

minion is integrated following 3 functions mainly. It aimed the central class (My) calls each functions easily and commonly from anywhere in the system.

* the hash function
* JSON functions（[GSON](https://github.com/google/gson)）
* camelize and tableize, etc.（[ModeShape](https://github.com/ModeShape/modeshape)'s Inflector）

minion as a kind of JSON
------------------------

The GSON embedded in minion is added the following rules of the JSON serialization. By this means, the JSON string generated is to be unique. (Of course it is readable by general JSON deserializers.)

* sorting keys by the ASCII order.
* the exchange rules of escape characters is defined in one way.

In the case telling the difference by normal JSON, we call it minion especially.
