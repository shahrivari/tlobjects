package io.objects.tl.core;


import io.objects.tl.TLContext;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Basic object for RPC method.
 * It contains special method for deserializing result of RPC method call.
 *
 * @param <T> return type of method
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLMethod<T extends TLObject> extends TLObject {

    private transient T response;

    public T deserializeResponse(byte[] data, TLContext context) throws IOException {
        return response = deserializeResponse(new ByteArrayInputStream(data), context);
    }

    public abstract T deserializeResponse(InputStream stream, TLContext context) throws IOException;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
