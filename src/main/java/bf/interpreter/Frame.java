package bf.interpreter;


import java.util.Arrays;

public class Frame {

    private int[] memorySnapshot;
    private int dataPointer;


    public Frame(int[] fullMemory, int currentDataPointer) {
        this.dataPointer = currentDataPointer;
        this.memorySnapshot = Arrays.copyOf(fullMemory, 20);
    }


    @Override
    public String toString() {
        return "\nFrame {" +
                " pointer " + dataPointer +
                ", memory: " + java.util.Arrays.toString(memorySnapshot) +
                " }";
    }
    public int[] getMemorySnapshot() {
        return memorySnapshot;
    }

    public int getDataPointer() {
        return dataPointer;
    }
}
