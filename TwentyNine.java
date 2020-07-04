import java.util.ArrayList;

public class TwentyNine {
    // 顺时针打印矩阵

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();

        // 4 个边界
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        // 循环一次转一圈
        while (r1 <= r2 && c1 <= c2) {
            // 从左往右遍历
            for (int i = c1; i <= c2; i++)
                ret.add(matrix[r1][i]);

            // 从上往下遍历
            for (int i = r1 + 1; i <= r2; i++)
                ret.add(matrix[i][c2]);

            // 从右往左遍历
            // 注意单行的情况，所以要加判断
            if (r1 != r2)
                for (int i = c2 - 1; i >= c1; i--)
                    ret.add(matrix[r2][i]);

            // 从下往上遍历
            // 注意单列的情况，所以要加判断
            if (c1 != c2)
                for (int i = r2 - 1; i > r1; i--)
                    ret.add(matrix[i][c1]);

            // 遍历一圈，更新边界
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ret;
    }
}
