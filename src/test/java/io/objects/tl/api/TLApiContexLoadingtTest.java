package io.objects.tl.api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TLApiContexLoadingtTest {
    @Test
    void shouldLoadAllTLObjectsCorrectly() {
        TLApiContext context = TLApiContext.getInstance();

        assertThat(context).isNotNull();
    }
}