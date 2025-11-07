package lsp;

public class Penguin implements Bird {
    @Override
    public void eat() { System.out.println("<звуки пингвина>, ем рыбу, <еще звуки пингвина>"); }

    @Override
    public void fly() { System.out.println("Пингвины не летают АЛЛЕ"); }
}
