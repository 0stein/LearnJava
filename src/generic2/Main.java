package generic2;

public class Main {
    public static void main(String[] args){
        //참조변수의 형 Box<Integer>를 기반으로 makeBox 메소드의 T를 결정하게된다 이를 타겟타입 이라고 한다.
        Box<Integer> iBox = EmptyBoxFactory.makeBox();
        iBox.setOb(25);
        System.out.println(iBox.getOb());

        /*
        peekBox1(iBox);
        Box<Integer> 는 Box<Object>를 상속하지 않는다.
        peekBox1과 peekBox2는 기능적으로 완전히 동일하다.
        와일드카드가 좀더 깔끔해보여서 추천되는 방식이다.
         */
    }
    public static void peekBox1(Box<Object> box){
        System.out.println(box);
    }

    public static <T> void peekBox2(Box<T> box){
        System.out.println(box);
    }

    public static void peekBox3(Box<?> box){
        System.out.println(box);
    }
}
