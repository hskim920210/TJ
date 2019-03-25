
public class Array_23 {

	public static void main(String[] args) {
		// ������ �迭�� ����
		int[][] arr = {{1,2,3},{4,5,6}};
		
		for( int i = 0 ; i < arr.length ; i++ ) {
			for( int j = 0 ; j < arr[i].length ; j++ ) {
				System.out.printf("arr[%d][%d] = %d\n", i, j, arr[i][j]);
			}
		}
		
		// ������ �迭�� ���� ���縦 �����ϴ� �ڵ�
		// 1. ���� �ܺ��� �迭�� ���� (�������� ������ �迭�� ����. �����⸸ ����)
		int[][] arr_copy = arr.clone();
		// 2. ������ �������� �迭�� ��ȸ�ϸ� ���� 1���� �迭�� �ٽ� �ѹ� ����
		for ( int i = 0 ; i < arr_copy.length ; i ++ ) {
			arr_copy[i] = arr_copy[i].clone();
		}
		
		System.out.println("======================================");
		
		for( int i = 0 ; i < arr.length ; i++ ) {
			for( int j = 0 ; j < arr[i].length ; j++ ) {
				System.out.printf("arr[%d][%d] = %d\n", i, j, arr[i][j]);
				System.out.printf("arr_copy[%d][%d] = %d\n", i, j, arr_copy[i][j]);
			}
		}
		
		// ���� ���縦 ������ ������ �迭�� ��� ����� �迭(arr_copy)�� ���� �����ص� �����迭(arr)���� �������� ����.
		arr_copy[0][1] = 22222;
		
		System.out.println("======================================");
				
				for( int i = 0 ; i < arr.length ; i++ ) {
					for( int j = 0 ; j < arr[i].length ; j++ ) {
						System.out.printf("arr[%d][%d] = %d\n", i, j, arr[i][j]);
						System.out.printf("arr_copy[%d][%d] = %d\n", i, j, arr_copy[i][j]);
					}
				}
		
	}

}