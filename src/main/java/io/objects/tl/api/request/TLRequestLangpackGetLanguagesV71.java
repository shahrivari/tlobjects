package io.objects.tl.api.request;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

import io.objects.tl.TLContext;
import io.objects.tl.api.TLLangPackLanguage;
import io.objects.tl.core.TLMethod;
import io.objects.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLRequestLangpackGetLanguagesV71 extends TLMethod<TLVector<TLLangPackLanguage>> {
    public static final int CONSTRUCTOR_ID = 0x800fd57d;

    private final String _constructor = "langpack.getLanguagesV71#800fd57d";

    public TLRequestLangpackGetLanguagesV71() {
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLVector<TLLangPackLanguage> deserializeResponse(InputStream stream, TLContext context)
            throws IOException {
        return readTLVector(stream, context);
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
