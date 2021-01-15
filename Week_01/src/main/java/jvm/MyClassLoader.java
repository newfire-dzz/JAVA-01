package jvm;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author dzz
 */

public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, InvocationTargetException {
        Class clazz = new MyClassLoader().findClass("Hello");
        Method method = clazz.getMethod("hello");
        method.invoke(clazz.newInstance());
    }

    @Override
    protected Class<?> findClass(String name) {
        try {
            InputStream hello = MyClassLoader.class.getClassLoader().getResourceAsStream("Hello.xlass");
            byte[] bytes = new byte[hello.available()];
            hello.read(bytes);
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - (int)bytes[i]);
            }
            String[] strings = name.split("/");
            String className = strings[strings.length - 1].split("\\.")[0];
            return defineClass(className, bytes, 0, bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
