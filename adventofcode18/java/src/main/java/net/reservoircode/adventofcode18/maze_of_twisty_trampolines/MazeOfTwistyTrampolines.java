package net.reservoircode.adventofcode18.maze_of_twisty_trampolines;

public class MazeOfTwistyTrampolines {

    public Integer chall1(Integer... array) {
        Integer steps = 0;
        Integer position = 0;

        while (position <= array.length - 1) {
            if (array[position] == 0) {
                array[position] = 1;
            } else {
                Integer nextPosition = array[position];
                array[position] += 1;
                position = position + nextPosition;
            }
            steps++;
        }
        return steps;
    }

    public Integer chall2(Integer... array) {
        Integer steps = 0;
        Integer position = 0;

        while (position <= array.length - 1) {
            if (array[position] == 0) {
                array[position] = 1;
            } else {
                Integer nextPosition = array[position];
                if (array[position] < 3) {
                    array[position] += 1;
                } else {
                    array[position] -= 1;
                }
                position = position + nextPosition;
            }
            steps++;
        }
        return steps;
    }

}
