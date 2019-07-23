package io.tlobjects.tl.api.help;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.TLContext;
import io.tlobjects.tl.api.TLAbsDocument;
import io.tlobjects.tl.api.TLAbsMessageEntity;
import io.tlobjects.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLAppUpdate extends TLAbsAppUpdate {
    public static final int CONSTRUCTOR_ID = 0x1da7158f;

    protected int flags;

    protected boolean popup;

    protected int id;

    protected String version;

    protected String text;

    protected TLVector<TLAbsMessageEntity> entities;

    protected TLAbsDocument document;

    protected String url;

    private final String _constructor = "help.appUpdate#1da7158f";

    public TLAppUpdate() {
    }

    public TLAppUpdate(boolean popup, int id, String version, String text,
            TLVector<TLAbsMessageEntity> entities, TLAbsDocument document, String url) {
        this.popup = popup;
        this.id = id;
        this.version = version;
        this.text = text;
        this.entities = entities;
        this.document = document;
        this.url = url;
    }

    private void computeFlags() {
        flags = 0;
        flags = popup ? (flags | 1) : (flags & ~1);
        flags = document != null ? (flags | 2) : (flags & ~2);
        flags = url != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeString(version, stream);
        writeString(text, stream);
        writeTLVector(entities, stream);
        if ((flags & 2) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            writeTLObject(document, stream);
        }
        if ((flags & 4) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            writeString(url, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        popup = (flags & 1) != 0;
        id = readInt(stream);
        version = readTLString(stream);
        text = readTLString(stream);
        entities = readTLVector(stream, context);
        document = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsDocument.class, -1) : null;
        url = (flags & 4) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(version);
        size += computeTLStringSerializedSize(text);
        size += entities.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            size += document.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            size += computeTLStringSerializedSize(url);
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

    public boolean getPopup() {
        return popup;
    }

    public void setPopup(boolean popup) {
        this.popup = popup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }

    public TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsDocument document) {
        this.document = document;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
