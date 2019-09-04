package io.objects.tl.api

import io.github.classgraph.ClassGraph
import io.objects.tl.api.help.TLGetTermsOfServiceUpdate
import io.objects.tl.core.TLBool
import io.objects.tl.core.TLObject
import io.objects.tl.mtproto.tl.MTInvokeAfter
import io.objects.tl.mtproto.tl.MTMessage
import org.junit.jupiter.api.Test
import java.lang.reflect.Modifier

internal class TLApiContextTest {
    @Test
    internal fun `test constructorId duplicate`() {
        val set = HashSet<Int>()

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
                                || tlClass == MTMessage::class.java)
                            continue

                        val constructorId: Int
                        try {
                            constructorId = tlClass.getField("CONSTRUCTOR_ID").get(null) as Int

                            if (map.containsKey(constructorId))
                                println("${tlClass.name}  |****|  ${map[constructorId]!!.name}")
                            else
                                map[constructorId] = tlClass
/*
                            if (set.contains(constructorId))
                                println("This constructorId is exist:$constructorId")
                            else
                                set.add(constructorId)
*/
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