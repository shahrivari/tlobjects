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
public class TLChannelParticipantAdmin extends TLAbsChannelParticipant {
    public static final int CONSTRUCTOR_ID = 0xa82fa898;

    protected int flags;

    protected boolean canEdit;

    protected int inviterId;

    protected int promotedBy;

    protected int date;

    protected TLAbsChannelAdminRights adminRights;

    private final String _constructor = "channelParticipantAdmin#a82fa898";

    public TLChannelParticipantAdmin() {
    }

    public TLChannelParticipantAdmin(boolean canEdit, int userId, int inviterId, int promotedBy,
            int date, TLAbsChannelAdminRights adminRights) {
        this.canEdit = canEdit;
        this.userId = userId;
        this.inviterId = inviterId;
        this.promotedBy = promotedBy;
        this.date = date;
        this.adminRights = adminRights;
    }

    private void computeFlags() {
        flags = 0;
        flags = canEdit ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(userId, stream);
        writeInt(inviterId, stream);
        writeInt(promotedBy, stream);
        writeInt(date, stream);
        writeTLObject(adminRights, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        canEdit = (flags & 1) != 0;
        userId = readInt(stream);
        inviterId = readInt(stream);
        promotedBy = readInt(stream);
        date = readInt(stream);
        adminRights = readTLObject(stream, context, TLAbsChannelAdminRights.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += adminRights.computeSerializedSize();
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

    public boolean getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getInviterId() {
        return inviterId;
    }

    public void setInviterId(int inviterId) {
        this.inviterId = inviterId;
    }

    public int getPromotedBy() {
        return promotedBy;
    }

    public void setPromotedBy(int promotedBy) {
        this.promotedBy = promotedBy;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLAbsChannelAdminRights getAdminRights() {
        return adminRights;
    }

    public void setAdminRights(TLAbsChannelAdminRights adminRights) {
        this.adminRights = adminRights;
    }
}
