package io.tlobjects.tl.api.contacts;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLContactsNotModified extends TLAbsContacts {
    public static final int CONSTRUCTOR_ID = 0xb74ba9d2;

    private final String _constructor = "contacts.contactsNotModified#b74ba9d2";

    public TLContactsNotModified() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
