package io.tlobjects.tl.mtproto;

import io.tlobjects.tl.core.TLObject;

import static io.tlobjects.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * This class is generated by Alxan and Xanjar: V85a
 */
public class MTRpcAnswerUnknown extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x5e2ad36e;

    private final String _constructor = "rpc_answer_unknown#cd050916";

    public MTRpcAnswerUnknown() {
    }

    @Override
    public int computeSerializedSize() {
        return SIZE_CONSTRUCTOR_ID;
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
