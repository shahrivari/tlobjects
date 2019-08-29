package io.objects.tl.api.request;

import io.objects.tl.TLObjectUtils;
import io.objects.tl.api.TLInputPeerUser;
import io.objects.tl.api.TLReplyInlineMarkup;
import io.objects.tl.core.TLVector;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;

class TLRequestScheduledSendMessageTest {

    @Test
    public void SerializeDeserialize() throws IOException {
        TLRequestScheduledSendMessage message = new TLRequestScheduledSendMessage();
        message.time = 5;
        message.entities = new TLVector<>();

        TLReplyInlineMarkup markup = new TLReplyInlineMarkup();
        markup.setRows(TLVector.EMPTY_ARRAY);
        message.replyMarkup = markup;

        message.message = "test";
        message.background = true;
        message.clearDraft = false;
        message.noWebpage = true;
        message.peer = new TLInputPeerUser();
        message.silent = true;

        byte[] bytes = message.serialize();
        TLRequestScheduledSendMessage deserialize = TLObjectUtils.deserialize(bytes);
        assertThat(message.time).isEqualTo(deserialize.time);
        assertThat(message.message).isEqualTo(deserialize.message);
        assertThat(message.silent).isEqualTo(deserialize.silent);
        assertThat(message.background).isEqualTo(deserialize.background);
        assertThat(message.noWebpage).isEqualTo(deserialize.noWebpage);
        assertThat(message.clearDraft).isEqualTo(deserialize.clearDraft);
    }

}