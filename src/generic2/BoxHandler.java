package generic2;

public class BoxHandler {
    //와일드 카드의 상한제한은 값을 넣는것을 금지시킴.
    public static void outBox(Box<? extends Toy> box){
        Toy t = box.getOb();
        //box.setOb(new Toy());
        System.out.println(t);
    }

    //하한제한은 값을 꺼내는 것을 금한다.
    public static void inBox(Box<? super Toy> box, Toy n){
        //box.getOb();
        box.setOb(n);
    }
}
