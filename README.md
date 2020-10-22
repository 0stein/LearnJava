# LearnJava

###generic

----------
```
public class Box<T> {
    T value;
    T getValue(){
        return value;
    }
    ...
}
```
위와 같은 클래스는 제네릭 문법이 적용된 클래스이다.  
T는 타입을 인자로 넘겨받은 것이다. getValue() 의 반환 타입도 T 라는 인자로넘어온 타입.  

```
public class cube extends SolidMaterial{ ... }
public class Apple extends SolidMaterial implements Eatable{ ... }
```
간혹 T라는 타입에 어떠한 조건을 달아 주고 싶을 때 가 있다.  
SolidMaterial을 상속하는 클래스를 타입 인자로 전달 해 주고 싶다면,
```
