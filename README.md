# fraction

`fraction` package allows you to create fraction objects and perform arithmetic operations on them and compare them.

`FractionImpl` implements `Fraction` interface and has `int` and `String` constructors. Fractions are normalised as they are created.

## Basic Example

```java

import fraction.*;

FractionImpl num1 = new FractionImpl(" 1 / 4");
FractionImpl num2 = new FractionImpl(3, 8);

System.out.println(num1.add(num2)

```
Result:
```
5/8
```

More examples can be seen in Main file.
