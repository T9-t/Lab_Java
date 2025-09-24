
public class Bell {

    private boolean onBell = true;

    public void start(){

        sound();
        sound();
        sound();
        sound();
    }
    private void sound(){

        if (onBell){
            System.out.println("ding");
        }
        else {
            System.out.println("dong");
        }
        onBell = !onBell;
    }
}