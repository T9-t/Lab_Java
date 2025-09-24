
public class Button {

    private int onClick = 0;

    public void start() {

        click();
        click();
        click();
        click();
        click();
        click();
    }
    private void click(){

        onClick++;
        System.out.println("click: " + onClick);
    }
}
