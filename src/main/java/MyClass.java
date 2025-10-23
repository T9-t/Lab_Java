
public class MyClass {

    @Repeat(times = 5)
    public void public1(){
        System.out.println("This is public method #1");
    }
    public void public2(){
        System.out.println("This is public method #2");
    }
    @Repeat(times = 3)
    protected void protected1(){
        System.out.println("This is protected method #1");
    }
    protected void protected2(){
        System.out.println("This is protected method #2");
    }
    @Repeat(times = 2)
    private void private1(){
        System.out.println("This is private method #1");
    }
    @Repeat(times = 4)
    private void private2(){
        System.out.println("This is private method #2");
    }
}
