package test;

public class Test {
	
	/**
     	 * 直接插入排序: 时间复杂度复杂度 O(n^2)
     	 *   稳定排序, 在数列相对有序的时候比二分插入块.
	 *   插入排序的工作机制和打牌时, 整理手中牌的做法差不多.
     	 * 1. 第 1 个元素是一个 length 为 1 的有序数列, 第 2 - 第 n 元素为待排序的数列;
     	 * 2. 从第 2 个元素开始, 和前面的有序数列中的元素比较(从后向前), 找到合适的位置, 并插入;
     	 * 3. 直到第 n 个元素插入完毕.
	 * 
	 * 二分法插入排序: 时间复杂度复杂度 O(n^2)
	 *   思想和直接插入一样, 只是找合适的插入位置的方式采用二分法查找, 可以减少比较的次数.
	 *   稳定排序, 当 n 较大时, 对无序数列排序比直接插入要快.
	 * 希尔排序: 实质上是分组插入算法. 改进的直接插入算法, 速度快, 但不是稳定排序.
	 */
	public static void insertSort(int[] d) {
		int t = 0;
		for(int i = 1; i < d.length; i++) {
			if(d[i] < d[i - 1]) {
				t = d[i];
				int j = 0;
				for(j = i - 1; j >= 0 && t < d[j]; j--) {
					d[j + 1] = d[j];
				}
				d[j + 1] = t;
			}
		}
	}
	
	public static void bubbleSort(int[] d) {
		int len = d.length;
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len - i - 1; j++) {
				int a = d[j];
				int b = d[j + 1];
				if(a < b) {
					swap(d, j, j + 1);
				}
			}
		}
	}
	
	/**
	 * 首先要找到一个位置的数使得其左边的数字比它要小，右边的数字比它要大.
     	 * 开始的时候数组为: 5, 3, 9, 2, 6, 1
     	 * 首先从左端下标为 ++i (基准)开始扫描发现 3 小于 5 满足条件继续; 发现下一个 9 大于 5 而此时 i 的下标值为 2,
     	 * 不满足条件退出左端扫描的 while 循环, 并从最右端开始扫描, 发现最右端第一个数字就小于 5, 此时 j 的值为 5,
	 * 而 i 此时是小于 j 的, 交换两位置数据, 即一轮循环后的数据为: 5, 3, 1, 2, 6, 9
     	 * 接着从左端开始继续扫描, 当扫描到大于 5 的值的时候, i 的值变为 4 即 6 所处位置的下标, 当从右端开始扫描时,
	 * 扫描到小于 5 的数字时, j 的值变为 3, 而此时 i 的值大于 j 的值不满足条件退出最外的 while 循环,
	 * 此时数组的数据为: 5, 3, 1, 2, 6, 9
     	 * 然后将第一个数和 j 处下标的数进行互换, 数组变为: 2, 3, 1, 5, 6, 9
     	 * 这样就达到了预期的目标, 即下标为 3 的数据(5)大于其左边的数据且小于其右边的数据
     	 * 然后以 5(下标为 3) 为分割点对两边的数据用同样的原理进行排序.
     	 */
	public static void quickSort(int[] d, int l, int r) {
		int i = l, j = r + 1, m = d[l];
		while(true) {
			while(i++ < r && d[i] < m);
			while(j-- > l && d[j] > m);
			if(i >= j) break;
			swap(d, i, j);
		}
		
		swap(d, l, j);
		
		if(l < j) quickSort(d, l, j);
		if(i < r) quickSort(d, i, r);
	}
	
	private static void swap(int[] d, int i, int j) {
        	int t = d[i];
        	d[i] = d[j];
        	d[j] = t;
	}
	
	public static void main(String[] args) {
		int[] d = {5, 3, 9, 7, 2, 6, 1};
		quickSort(d, 0, d.length - 1);
		// bubbleSort(d);
		// insertSort(d);
		
		for(int i = 0; i < d.length; i++)
			System.out.println(d[i]);
	}
	
}


