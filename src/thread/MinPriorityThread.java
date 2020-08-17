package thread;

public class MinPriorityThread extends Thread{
    public MinPriorityThread(String name){
        super(name);
    }
    public void run(){
        for(int i=0; i<10;i++){
            for(int j=0;j<10;j++){
                System.out.print("!");
            }
            System.out.println();
        }
    }
}
