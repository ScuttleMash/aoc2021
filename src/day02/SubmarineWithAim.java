package day02;

import java.util.List;

public class SubmarineWithAim {

    private int horizontalPosition = 0;
    private int depth = 0;
    private int aim = 0;

    public SubmarineWithAim execute(List<Instruction> instructions) {
        instructions.forEach(x -> {
            if (x.isUp()) {
                aim -= x.getDistance();
            } else if (x.isForward()) {
                horizontalPosition += x.getDistance();
                depth += aim * x.getDistance();
            } else if (x.isDown()) {
                aim += x.getDistance();
            }
        });
        return this;
    }

    public int getPosition() {
        return horizontalPosition * depth;
    }
}
