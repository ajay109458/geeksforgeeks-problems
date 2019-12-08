package utils;

public class HeapNode implements Comparable<HeapNode>{
	public int val;
	public int row;
	public int col;

	public HeapNode(int val, int row, int col) {
		this.val = val;
		this.row = row;
		this.col = col;
	}

	@Override
	public int compareTo(HeapNode o) {
		
		if (this.val < o.val) {
			return -1;
		} else if (this.val > o.val) {
			return 1;
		} 
		
		return 0;
	}
}
