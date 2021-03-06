package io.objects.tl.api;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

import io.objects.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLBotMessageMediaVenue extends TLAbsBotMessageMedia {
    public static final int CONSTRUCTOR_ID = 0x29b92700;

    protected TLAbsGeoPoint geo;

    protected String title;

    protected String address;

    protected String provider;

    protected String venueId;

    protected String venueType;

    private final String _constructor = "botMessageMediaVenue#29b92700";

    public TLBotMessageMediaVenue() {
    }

    public TLBotMessageMediaVenue(TLAbsGeoPoint geo, String title, String address, String provider,
            String venueId, String venueType, long requestId, int responseCode, String error) {
        this.geo = geo;
        this.title = title;
        this.address = address;
        this.provider = provider;
        this.venueId = venueId;
        this.venueType = venueType;
        this.requestId = requestId;
        this.responseCode = responseCode;
        this.error = error;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(geo, stream);
        writeString(title, stream);
        writeString(address, stream);
        writeString(provider, stream);
        writeString(venueId, stream);
        writeString(venueType, stream);
        writeLong(requestId, stream);
        writeInt(responseCode, stream);
        writeString(error, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        geo = readTLObject(stream, context, TLAbsGeoPoint.class, -1);
        title = readTLString(stream);
        address = readTLString(stream);
        provider = readTLString(stream);
        venueId = readTLString(stream);
        venueType = readTLString(stream);
        requestId = readLong(stream);
        responseCode = readInt(stream);
        error = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += geo.computeSerializedSize();
        size += computeTLStringSerializedSize(title);
        size += computeTLStringSerializedSize(address);
        size += computeTLStringSerializedSize(provider);
        size += computeTLStringSerializedSize(venueId);
        size += computeTLStringSerializedSize(venueType);
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(error);
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

    public TLAbsGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(TLAbsGeoPoint geo) {
        this.geo = geo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getVenueType() {
        return venueType;
    }

    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
