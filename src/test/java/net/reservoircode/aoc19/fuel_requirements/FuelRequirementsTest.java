package net.reservoircode.aoc19.fuel_requirements;

import net.reservoircode.aoc18.maze_of_twisty_trampolines.MazeOfTwistyTrampolines;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FuelRequirementsTest {

    @Test
    public void for_chall_1_should_find_with_set_1() {
        int fuelSum = new FuelRequirements().chall1(new int[] {12, 14, 1969, 100756});

        assertThat(fuelSum).isEqualTo(34241);
    }

    @Test
    public void for_chall_1_should_find_with_final_set() {
        int fuelSum = new FuelRequirements().chall1(new int[] {138486, 133535, 66101, 98143, 56639, 120814, 142212, 92654, 100061, 104095, 55169, 94082, 76014, 81109, 106237, 111930, 138463, 145843, 142133, 71154, 112809, 136465, 142342, 68794, 131804, 146345, 107935, 98577, 127456, 89612, 95710, 149792, 136982, 92773, 92303, 114637, 107447, 111815, 149603, 106822, 78811, 114120, 148773, 90259, 101612, 82220, 139301, 91121, 99366, 84070, 120713, 59311, 120435, 56106, 127426, 110465, 76167, 81199, 116298, 110064, 125674, 135698, 86792, 114228, 119794, 76683, 125698, 103450, 142435, 142297, 122593, 96177, 104287, 121379, 54729, 108057, 127334, 91718, 67009, 93304, 66907, 133910, 145775, 119241, 117492, 56351, 96171, 50449, 137815, 149308, 119003, 60320, 66853, 56648, 52003, 115137, 124759, 73799, 94731, 147480});

        assertThat(fuelSum).isEqualTo(3515171);
    }
}