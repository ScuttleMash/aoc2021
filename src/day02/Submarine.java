package day02;

import java.util.List;

public class Submarine {

    private int horizontalPosition = 0;
    private int depth = 0;

    public Submarine execute(List<Instruction> instructions) {
        instructions.forEach(x -> {
            if (x.isUp()) {
                depth -= x.getDistance();
            } else if (x.isForward()) {
                horizontalPosition += x.getDistance();
            } else if (x.isDown()) {
                depth += x.getDistance();
            }
        });
        return this;
    }

    public int getPosition() {
        return horizontalPosition * depth;
    }
}
