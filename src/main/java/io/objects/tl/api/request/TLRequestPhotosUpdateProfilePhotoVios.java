package io.objects.tl.api.request;

import io.objects.tl.TLContext;
import io.objects.tl.api.TLAbsUserProfilePhoto;
import io.objects.tl.api.TLInputPhotoCropAutoVios;
import io.objects.tl.api.TLInputPhotoVios;
import io.objects.tl.core.TLMethod;
import io.objects.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.StreamUtils.readTLObject;
import static io.objects.tl.StreamUtils.writeTLObject;
import static io.objects.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

public class TLRequestPhotosUpdateProfilePhotoVios extends TLMethod<TLAbsUserProfilePhoto> {
    public static final int CONSTRUCTOR_ID = 0xeef579a0;
    private final String _constructor = "photos.updateProfilePhotoVios#eef579a0";
    protected TLInputPhotoVios id;
    protected TLInputPhotoCropAutoVios crop;

    public TLRequestPhotosUpdateProfilePhotoVios() {
    }

    public TLRequestPhotosUpdateProfilePhotoVios(TLInputPhotoVios id, TLInputPhotoCropAutoVios crop) {
        this.id = id;
        this.crop = crop;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsUserProfilePhoto deserializeResponse(InputStream stream, TLContext context) throws
            IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUserProfilePhoto)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsUserProfilePhoto) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(id, stream);
        writeTLObject(crop, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readTLObject(stream, context, TLInputPhotoVios.class, -1);
        crop = readTLObject(stream, context, TLInputPhotoCropAutoVios.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += id.computeSerializedSize();
        size += crop.computeSerializedSize();
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

    public TLInputPhotoVios getId() {
        return id;
    }

    public void setId(TLInputPhotoVios id) {
        this.id = id;
    }

    public TLInputPhotoCropAutoVios getCrop() {
        return crop;
    }

    public void setCrop(TLInputPhotoCropAutoVios crop) {
        this.crop = crop;
    }
}
