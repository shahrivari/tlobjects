package io.objects.tl.api;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import io.objects.tl.TLContext;
import io.objects.tl.api.help.TLGetTermsOfServiceUpdate;
import io.objects.tl.core.TLBool;
import io.objects.tl.core.TLObject;
import io.objects.tl.mtproto.tl.MTInvokeAfter;
import io.objects.tl.mtproto.tl.MTMessage;

import java.lang.reflect.Modifier;

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
        String pkg = "io.objects.tl";
        try (ScanResult scanResult = new ClassGraph()
                // .verbose()
                // .enableAllInfo()
                .whitelistPackages(pkg)
                .ignoreMethodVisibility()
                .ignoreParentClassLoaders()
                .ignoreClassVisibility()
                .ignoreParentModuleLayers()
                .ignoreFieldVisibility()
                .scan()) {

            for (ClassInfo info : scanResult.getSubclasses("io.objects.tl.core.TLObject")) {
                Class<? extends TLObject> tlClass = (Class<? extends TLObject>) info.loadClass();

                if (Modifier.isAbstract(tlClass.getModifiers()) || TLBool.class.isAssignableFrom(tlClass)
                        || tlClass == MTInvokeAfter.class || tlClass == TLGetTermsOfServiceUpdate.class
                        || tlClass == MTMessage.class)
                    continue;

                int constructorId;
                try {
                    constructorId = (int) tlClass.getField("CONSTRUCTOR_ID").get(null);
                    registerClass(constructorId, tlClass);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                    System.err.println(tlClass.getName());
                }
            }
        }
    }
}
