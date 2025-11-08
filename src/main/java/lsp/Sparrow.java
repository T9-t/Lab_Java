package lsp;

public class Sparrow implements Bird {
    @Override
    public void eat() {
        System.out.println("Чирик-чирик, клюю семечки, чирик-чирик");
    }

    @Override
    public void fly() {
        System.out.println("Чирик-чирик, я лечу, чирик-чирик");
    }
}
