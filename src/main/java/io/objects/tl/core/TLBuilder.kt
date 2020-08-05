package io.objects.tl.core

import java.util.*
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty

class TLBuilder {
    val map = HashMap<KProperty<*>, Boolean>()

    fun withProperty(name: KMutableProperty0<*>, isNullable: Boolean = false): TLBuilder {
        map[name] = isNullable
        return this
    }

    fun build(): TLBuilder {
        return this
    }
}
