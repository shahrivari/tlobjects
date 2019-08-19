package io.objects.tl.api;

import io.objects.tl.TLContext;
import io.objects.tl.core.TLBool;
import io.objects.tl.core.TLObject;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Set;

/**
 * This class is generated by Mono's TL class generator
 */
@SuppressWarnings("unused")
public class TLApiContext extends TLContext {
    private static TLApiContext instance;

    public TLApiContext() {
        super(665);
    }

    public static TLApiContext getInstance() {
        if (instance == null) {
            instance = new TLApiContext();
        }
        return instance;
    }

    @Override
    public void init() {
        Reflections reflections = new Reflections("io.objects.tl");
        Set<Class<? extends TLObject>> tlObjectClasses = reflections.getSubTypesOf(TLObject.class);
        for (Class<? extends TLObject> tlObjectClass : tlObjectClasses) {
            if (Modifier.isAbstract(tlObjectClass.getModifiers()) || TLBool.class.isAssignableFrom(tlObjectClass))
                continue;

            try {
                Constructor<? extends TLObject> constructor = tlObjectClass.getConstructor();
                registerClass((Integer) tlObjectClass.getMethod("getConstructorId").invoke(constructor.newInstance()), tlObjectClass);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
