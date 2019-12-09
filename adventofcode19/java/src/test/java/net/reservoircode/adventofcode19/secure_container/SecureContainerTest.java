package net.reservoircode.adventofcode19.secure_container;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SecureContainerTest {
    @Test
    public void for_chall_1_should_find_with_set_1() {
        int result = new SecureContainer().chall1("367479-893698");

        assertThat(result).isEqualTo(495);
    }

}