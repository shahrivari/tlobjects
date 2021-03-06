package io.objects.tl.api;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLChannelAdminLogEventActionParticipantJoin extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x183040d3;

    private final String _constructor = "channelAdminLogEventActionParticipantJoin#183040d3";

    public TLChannelAdminLogEventActionParticipantJoin() {
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
