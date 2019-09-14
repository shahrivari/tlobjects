package io.objects.tl.api

import io.github.classgraph.ClassGraph
import io.objects.tl.api.help.TLGetTermsOfServiceUpdate
import io.objects.tl.core.*
import io.objects.tl.mtproto.tl.MTInvokeAfter
import io.objects.tl.mtproto.tl.MTMessage
import org.junit.jupiter.api.Test
import java.lang.reflect.Modifier

internal class TLApiContextTest {
    @Test
    internal fun `test constructorId duplicate`() {
        val map = HashMap<Int, Class<out TLObject>>()
        val pkg = "io.objects.tl"

        ClassGraph()
                // .verbose()
                // .enableAllInfo()
                .whitelistPackages(pkg)
                .ignoreMethodVisibility()
                .ignoreParentClassLoaders()
                .ignoreClassVisibility()
                .ignoreParentModuleLayers()
                .ignoreFieldVisibility()
                .scan().use { scanResult ->
                    for (info in scanResult.getSubclasses("io.objects.tl.core.TLObject")) {
                        val tlClass = info.loadClass() as Class<out TLObject>

                        if (Modifier.isAbstract(tlClass.modifiers) || TLBool::class.java.isAssignableFrom(tlClass)
                                || tlClass == MTInvokeAfter::class.java || tlClass == TLGetTermsOfServiceUpdate::class.java
                                || tlClass == MTMessage::class.java || tlClass == TLIntVector::class.java
                                || tlClass == TLLongVector::class.java || tlClass == TLStringVector::class.java)
                            continue

                        val constructorId: Int
                        try {
                            constructorId = tlClass.getField("CONSTRUCTOR_ID").get(null) as Int
                            check(!map.containsKey(constructorId)) {
                                "${tlClass.name} == ${map[constructorId]!!.name}"
                            }
                            map[constructorId] = tlClass
                        } catch (e: NoSuchFieldException) {
                            e.printStackTrace()
                            System.err.println(tlClass.name)
                        } catch (e: IllegalAccessException) {
                            e.printStackTrace()
                            System.err.println(tlClass.name)
                        }

                    }
                }
    }
}