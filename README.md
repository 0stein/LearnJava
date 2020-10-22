# LearnJava

## generic

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
public class Water{ ... }
public class Cube extends SolidMaterial{ ... }
public class Apple extends SolidMaterial implements Eatable{ ... }
```
여기 Water, Cube 클래스와 Apple 클래스가 있다.  
Water은 아무것도 상속하거나 구현하지 않는다.  
Cube는 SolidMaterial 를 상속하고, Apple 은 Eatable 을 구현까지 하고있다.  
  
간혹 T라는 타입인자에 제한을 주고 싶을 때가 있다.  
```
public class Box<T extends SolidMaterial>{ ... }

```
이제 이 Box 클래스는 SolidMaterial을 상속하는 클래스만 타입인자로 전달 할 수 있다.  
즉 Water는 이제 조건을 만족시키지 못하여 타입인자로 넘겨 줄 수 없다.

```
public class Box<T extends SolidMaterial implements Eatable>{ ... }
```
제한을 한층 더 높여 SolidMaterial을 상속하고 Eatable 을 구현하는 클래스를 타입으로 전해 줄 수 있다.  
즉 Apple 클래스 만이 조건을 충족하는 것이다.

## generic2  
---------------
### 와일드 카드  
  
```
public static <T> void peekBox(Box<T> box){ ... }  
```
이 같은 메서드는 호출 할 때 T 라는 타입 인자에 어떤 타입을 줄 것인지 결정 해야 한다.  
Integer 이면 Integer를, String 이면 String을 전달 해 주어야 하는 것이다.  
그러나 만약 프로그래머나 사용자가 어떤 타입의 Box 를 전달 해줄지 모르는 상황이라면 어떻게 해야될까?  
```
public static void peekBox(Box<Object> box){ ... } 
```
Integer 나 String 모두 Object 를 상속하니 Box<Integer> 이나 Box<String> 도 Box<Object> 를 상속 할 것이라 기대 할 지도 모른다.  
그러나 이는 잘못된 방식이다. 이 둘은 상속관계가 아니다. 그러므로 이런 상활에서는 와일드 카드를 사용해야한다.  
```
public static void peekBox(Box<?> box){ ... }
```
