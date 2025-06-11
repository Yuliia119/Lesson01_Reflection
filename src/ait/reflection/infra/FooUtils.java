package ait.reflection.infra;

import ait.reflection.model.Foo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class FooUtils {
    public static void caller(String functionName, String arg) throws NoSuchMethodException {
        Class<Foo> clazz = Foo.class;
        try {
            Method metod = clazz.getDeclaredMethod(functionName, String.class);
            metod.setAccessible(true);
            //metod.invoke(new Foo(), arg);
            Constructor constructor = clazz.getDeclaredConstructor();
            metod.invoke(constructor.newInstance(),arg);
        } catch (Exception e){
            System.out.println(functionName + "doesn't exists");
        }

    }
}
