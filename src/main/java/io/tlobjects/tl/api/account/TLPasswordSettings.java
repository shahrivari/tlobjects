package io.tlobjects.tl.api.account;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.TLContext;
import io.tlobjects.tl.api.TLSecureSecretSettings;
import io.tlobjects.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLPasswordSettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x9a5c33e5;

    protected int flags;

    protected String email;

    protected TLSecureSecretSettings secureSettings;

    private final String _constructor = "account.passwordSettings#9a5c33e5";

    public TLPasswordSettings() {
    }

    public TLPasswordSettings(String email, TLSecureSecretSettings secureSettings) {
        this.email = email;
        this.secureSettings = secureSettings;
    }

    private void computeFlags() {
        flags = 0;
        flags = email != null ? (flags | 1) : (flags & ~1);
        flags = secureSettings != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (email == null) throwNullFieldException("email", flags);
            writeString(email, stream);
        }
        if ((flags & 2) != 0) {
            if (secureSettings == null) throwNullFieldException("secureSettings", flags);
            writeTLObject(secureSettings, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        email = (flags & 1) != 0 ? readTLString(stream) : null;
        secureSettings = (flags & 2) != 0 ? readTLObject(stream, context, TLSecureSecretSettings.class, TLSecureSecretSettings.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (email == null) throwNullFieldException("email", flags);
            size += computeTLStringSerializedSize(email);
        }
        if ((flags & 2) != 0) {
            if (secureSettings == null) throwNullFieldException("secureSettings", flags);
            size += secureSettings.computeSerializedSize();
        }
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TLSecureSecretSettings getSecureSettings() {
        return secureSettings;
    }

    public void setSecureSettings(TLSecureSecretSettings secureSettings) {
        this.secureSettings = secureSettings;
    }
}
