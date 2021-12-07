package day02;

public class Instruction {

    public static final int UP = 1;
    public static final int FORWARD = 2;
    public static final int DOWN = 3;

    private int direction;
    private int distance;

    public Instruction(String rawInstruction) {
        String[] x = rawInstruction.split(" ");
        this.direction = parseDirection(x[0]);
        this.distance = Integer.parseInt(x[1]);
    }

    public boolean isUp() {
        return direction == UP;
    }

    public boolean isForward() {
        return direction == FORWARD;
    }

    public boolean isDown() {
        return direction == DOWN;
    }

    public int getDistance() {
        return distance;
    }

    private int parseDirection(String direction) {
        switch(direction.charAt(0)) {
            case 'u':
                return UP;
            case 'f':
                return FORWARD;
            case 'd':
                return DOWN;
            default:
                throw new RuntimeException("Could not parse direction");
        }
    }

}
