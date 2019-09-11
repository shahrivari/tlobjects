package io.objects.tl.mtproto.tl;

import io.objects.tl.core.TLObject;

public abstract class MTAbsDestroySessionResponse extends TLObject {
    protected long sessionId;

    public MTAbsDestroySessionResponse() {

    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }
}
