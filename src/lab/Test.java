package lab;

public class Test {
	public static int CHUNK_SIZE = 10000;
	
	public static void main(String[] args) {
		int count = 0;
		
		afterChunk(count, 0);
		afterChunk(count, 10000);
		afterChunk(count, 3);
		afterChunk(count, 90000);
		afterChunk(count, 100000);
	}
	
	
	public static void afterChunk(int count, int read) {
        count += read;
        if (count % (CHUNK_SIZE * 10) == 0 || (count % CHUNK_SIZE != 0)) {
          System.out.println("i should log " + count + " " + read);
        }
    }
}
