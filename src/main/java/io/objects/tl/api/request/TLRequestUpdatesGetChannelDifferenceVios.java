package io.objects.tl.api.request;

import io.objects.tl.TLContext;
import io.objects.tl.api.TLAbsChannelMessagesFilter;
import io.objects.tl.api.TLAbsInputChannel;
import io.objects.tl.api.updates.TLAbsChannelDifference;
import io.objects.tl.core.TLMethod;
import io.objects.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static io.objects.tl.TLObjectUtils.SIZE_INT32;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLRequestUpdatesGetChannelDifferenceVios extends TLMethod<TLAbsChannelDifference> {
    public static final int CONSTRUCTOR_ID = 0xbb32d7c0;

    protected TLAbsInputChannel channel;

    protected TLAbsChannelMessagesFilter filter;

    protected int pts;

    protected int limit;

    private final String _constructor = "updates.getChannelDifferenceVios#bb32d7c0";

    public TLRequestUpdatesGetChannelDifferenceVios() {
    }

    public TLRequestUpdatesGetChannelDifferenceVios(TLAbsInputChannel channel,
                                                    TLAbsChannelMessagesFilter filter, int pts, int limit) {
        this.channel = channel;
        this.filter = filter;
        this.pts = pts;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsChannelDifference deserializeResponse(InputStream stream, TLContext context) throws
            IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsChannelDifference)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsChannelDifference) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(channel, stream);
        writeTLObject(filter, stream);
        writeInt(pts, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channel = readTLObject(stream, context, TLAbsInputChannel.class, -1);
        filter = readTLObject(stream, context, TLAbsChannelMessagesFilter.class, -1);
        pts = readInt(stream);
        limit = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {

        int size = SIZE_CONSTRUCTOR_ID;
        size += channel.computeSerializedSize();
        size += filter.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(TLAbsInputChannel channel) {
        this.channel = channel;
    }

    public TLAbsChannelMessagesFilter getFilter() {
        return filter;
    }

    public void setFilter(TLAbsChannelMessagesFilter filter) {
        this.filter = filter;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
