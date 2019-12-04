package net.reservoircode.aoc19.program_alarm;

public class ProgramAlarm {

    public int[] chall1(int[] intCode) {
        for (int i = 0; i < intCode.length; i += 4) {
            if (i + 4 <= intCode.length) {
                int opcode = intCode[i];
                if (opcode == 99) {
                    break;
                }
                int inputA = intCode[intCode[i + 1]];
                int inputB = intCode[intCode[i + 2]];
                int position = intCode[i + 3];
                intCode[position] = (opcode == 1) ? inputA + inputB : (opcode == 2) ? inputA * inputB : intCode[position];
            }
        }
        return intCode;
    }
}
