package io.objects.tl.api;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

import io.objects.tl.core.TLObject;
import java.lang.String;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLBotUserProfilePhoto}: botUserProfilePhoto#d55a5618</li>
 * <li>{@link TLBotUserProfilePhotoEmpty}: botUserProfilePhotoEmpty#4ef16b01</li>
 * </ul>
 *
 * This class is generated by Mono's TL class generator
 */
public abstract class TLAbsBotUserProfilePhoto extends TLObject {
    protected long requestId;

    protected int responseCode;

    protected String error;

    public TLAbsBotUserProfilePhoto() {
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

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLBotUserProfilePhoto getAsBotUserProfilePhoto() {
        return null;
    }
}
