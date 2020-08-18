# LearnJava
##Java sample codes

###generic

----------

`public class Box<T extends SolidMaterial & Eatable> {
    T value;
    ...
}`

generic1 패키지에서는 기본적인 제네릭 문법을 담았습니다.
Box는 SolidMaterial클래스를 확장하거나, Eatable인터페이스를 구현하는 Type을 지정할 수 있습니다.