import java.lang.reflect.*;

public class Invoker extends MyClass {
    public void start() throws InvocationTargetException, IllegalAccessException {

        MyClass obj = new MyClass();

        for (Method method : MyClass.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Repeat.class)) {
                Repeat r = method.getAnnotation(Repeat.class);

                //method.setAccessible(true); Sonar says "This accessibility update should be removed"
                if (!method.trySetAccessible()){
                    throw new IllegalAccessException("Error");
                }
                for (int i = 0; i < r.times(); i++) {
                    method.invoke(obj);
                }
            }
        }
    }
}
