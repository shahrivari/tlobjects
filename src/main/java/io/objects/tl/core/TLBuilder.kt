package io.objects.tl.core

import kotlin.reflect.KMutableProperty0

open class TLBuilder protected constructor(val list: MutableList<KMutableProperty0<Any>>) {

    companion object {
        fun generateSerializer(): PropertyBuilder = PropertyBuilder()
    }

    class PropertyBuilder {
        private val list = mutableListOf<KMutableProperty0<*>>()

        fun withProperty(property: KMutableProperty0<*>): PropertyBuilder {
            list.add(property)
            return this
        }

        fun build(): TLBuilder {
            val list2 = mutableListOf<KMutableProperty0<Any>>()
            list.forEach { list2.add(it as KMutableProperty0<Any>) }
            return  TLBuilder(list2)
        }
    }
}
