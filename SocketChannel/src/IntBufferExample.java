// 1. Allocate a intbuffer of size 10, fill it, convert it to int array and then use this array to create another intbuffer using wrap method. Check if the initial and final inibuffers are equal.(2022_14_Prakash)
import java.nio.IntBuffer;
import java.util.Arrays;

public class IntBufferExample {

    public static void main(String[] args) {

        // 1. Allocate an IntBuffer of size 10
        IntBuffer buffer1 = IntBuffer.allocate(10);

        // 2. Fill the buffer
        for (int i = 0; i < buffer1.capacity(); i++) {
            buffer1.put(i * 10);
        }

        // Prepare buffer for reading
        buffer1.flip();

        // 3. Convert IntBuffer to int array
        int[] intArray = new int[buffer1.remaining()];
        buffer1.get(intArray);

        // 4. Create another IntBuffer using wrap()
        IntBuffer buffer2 = IntBuffer.wrap(intArray);

        // 5. Check if both buffers are equal
        boolean isEqual = buffer1.equals(buffer2);

        // Display results
        System.out.println("First IntBuffer  : " + Arrays.toString(intArray));
        System.out.println("Second IntBuffer : " + buffer2);
        System.out.println("Are both buffers equal? " + isEqual);
    }
}
