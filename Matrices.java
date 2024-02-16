package ProductStar_WorkShopMassiv;
import java.util.Arrays;


public class Matrices {
    static <T> T todo() {
        throw new UnsupportedOperationException("����� �� ����������");
    }

    /**
     * ������ ����� n
     */
    public static class Vector {
        private final int[] items;

        /**
         * ������� ������� ������ ����� n
         */
        public Vector(int n) {
            this.items = new int[n];
        }

        /**
         * ������� ������ c ��������� ����������.
         */
        public Vector(int[] items) {
            this.items = items;
        }

        /**
         * ���������� ������ ������ � ������ ��������.
         *
         * @param other ������, ������� ������ ���� ������ � ������ ��������; ������
         *              ����� �� �� �����, ��� � ������ ������
         * @return ����� ������, �������������� ����� ������� � ������� ��������
         */
        public Vector add(Vector other) throws IllegalAccessException {
            if (other.items.length != this.items.length) {
                throw new IllegalAccessException();
            }
            Vector result = new Vector(this.items.length);
            for (int i = 0; i < this.items.length; i++) {
                result.items[i] = this.items[i] + other.items[i];
            }
            return result;
        }

        /**
         * �������� ������ ������ �� ������� �������.
         *
         * @param other ������, ������� ������ ���� ������ �� ������� �������; ������
         *              ����� �� �� �����, ��� � ������ ������
         * @return ����� ������, �������������� �������� ������� � ������� ��������
         */
        public Vector subtract(Vector other) throws IllegalAccessException {
            if (other.items.length != this.items.length) {
                throw new IllegalAccessException();
            }
            Vector result = new Vector(this.items.length);
            for (int i = 0; i < this.items.length; i++) {
                result.items[i] = this.items[i] - other.items[i];
            }
            return result;
        }

        /**
         * ��������� ��������� ������������ ������� ������� � ������ ��������.
         *
         * @param other ������, � ������� ������ ���� ��������� ��������� ������������;
         *              ������ ����� �� �� �����, ��� � ������ ������
         * @return ��������� ������������ ������� � ������� ��������
         */
        public int dotProduct(Vector other) throws IllegalAccessException {
            if (other.items.length != this.items.length) {
                throw new IllegalAccessException();
            }
            int result = 0;
            for (int i = 0; i < other.items.length; i++) {
                result += this.items[i] * other.items[i];
            }
            return result;
        }

        /**
         * �������� ������ ������ �� ������.
         *
         * @param scalar ��������� ��������, �� ������� ������ ���� ������� ������ ������
         * @return ����� ������, �������������� ��������� ��������� ������� ������� �� ������
         */
        public Vector scalarMultiply(int scalar) {
            Vector result = new Vector(this.items.length);
            for (int i = 0; i < this.items.length; i++) {
                result.items[i] = scalar * this.items[i];
            }
            return result;
        }


        /**
         * ��������� ����� (�����) ������� �������.
         */
        public double length() {
            return items.length;
        }


        @Override
        public String toString() {
            return Arrays.toString(items);
        }
    }

    /**
     * ������������ ������� (m x n)
     */
    public static class Matrix {
        private final int nRows;
        private final int nCols;
        private final int[][] rows;

        /**
         * ������� ������� (nRows x nCols)
         */
        public Matrix(int nRows, int nCols) {
            this.nRows = nRows;
            this.nCols = nCols;
            this.rows = new int[nRows][nCols];
        }

        /**
         * ������� ������� � ������� ��������� � ������ ������������� ����� �� ��������.
         */
        @Override
        public String toString() {
            int[] colWidths = new int[nCols];
            for (int col = 0; col < nCols; col++) {
                int maxWidth = 0;
                for (int row = 0; row < nRows; row++) {
                    int width = Integer.toString(rows[row][col]).length();
                    maxWidth = Math.max(maxWidth, width);
                }
                colWidths[col] = maxWidth;
            }

            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < nRows; row++) {
                for (int col = 0; col < nCols; col++) {
                    String cell = String.format("%" + colWidths[col] + "d", rows[row][col]);
                    sb.append(cell);
                    if (col < nCols - 1) {
                        sb.append(" ");
                    }
                }
                if (row < nRows - 1) {
                    sb.append("\n");
                }
            }
            return sb.toString();
        }

        /**
         * ���������� ������� ������� � ������ ��������.
         *
         * @param other ������ �������, ������ ����� ����� �� �����������, ��� �
         *              ������� �������
         * @return ����� �������, ���������� ����������� ��������
         */


        public Matrix add(Matrix other) throws IllegalAccessException {
            if (this.rows.length != other.rows.length) {
                throw new IllegalAccessException("������� ������ ���� ����������� �������");
            }
            Matrix result = new Matrix(nRows, nCols);
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {
                    result.rows[i][j] = this.rows[i][j] + other.rows[i][j];
                }
            }
            return result;
        }


        /**
         * �������� ������ ������� �� ������� �������.
         *
         * @param other ������ �������, ������ ����� ����� �� �����������, ��� �
         *              ������� �������
         * @return ����� �������, ���������� ����������� ���������
         */
        public Matrix subtract(Matrix other) throws IllegalAccessException {
            if (this.rows.length != other.rows.length) {
                throw new IllegalAccessException("������� ������ ���� ����������� �������");
            }
            Matrix result = new Matrix(nRows, nCols);
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {
                    result.rows[i][j] = this.rows[i][j] - other.rows[i][j];
                }
            }
            return result;
        }


    /**
     * �������� ������� ������� �� ������ �������.
     *
     * @param other ������ �������, ���������� ����� ������� ������ ���� �����
     *              ���������� �������� ������� �������
     * @return ����� �������, ���������� ����������� ���������
     */
    public Matrix multiply(Matrix other) throws IllegalAccessException {
        if (this.rows.length != other.rows.length) {
            throw new IllegalAccessException("������� ������ ���� ����������� �������");
        }
        Matrix result = new Matrix(nRows,nCols);
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                result.rows[i][j] = this.rows[i][j]*other.rows[i][j];
            }
        }
        return result;
    }

    /**
     * �������� ������� ������� �� ������.
     *
     * @param scalar ��������� �������� ��� ��������� �������
     * @return ����� �������, ���������� ����������� ��������� �� ������
     */
    public Matrix scalarMultiply(int scalar) {
        Matrix result = new Matrix(nRows, nCols);
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                result.rows[i][j] = this.rows[i][j] * scalar;
            }
        }
        return result;
    }

    /**
     * ������������� ������� �������.
     *
     * @return ����� �������, ���������� ����������������� ������� ������� �������
     */
    public Matrix transpose() {
        Matrix result = new Matrix(this.nRows, this.nCols);
        for (int i = 0; i<this.nRows;i++){
            for (int j = 0; j<this.nCols; j++){
                result.rows[j][i] = rows[i][j];
            }
        }
        return result;
    }

    /**
     * ��������� ������������ ������� �������.
     *
     * @return �������� ������������ �������
     */
    public int determinant() throws IllegalAccessException {
        if (nCols!=nRows){
            throw new IllegalAccessException ("������� �� ����������");
        }
        else if (nRows == 1 ){
            return rows[0][0];
        }
        return 0;
    }

    /**
     * ���������� ��������� ������������ ������� matrix.
     * �������� ���������� ���������� �� ������ ������ �������.
     *
     * @param matrix ���������� �������, ��� ������� ����� ��������� ������������
     * @return ������������ ������� matrix
     */
    private static int determinant(int[][] matrix) {
        // ������� ������ ��� ������� 1x1
        if (matrix.length == 1) {
            return matrix[0][0];
        }

        // ������� ������ ��� ������� 2x2
        if (matrix.length == 2) {
            return todo();
        }

        int result = 0;
        // �������� �� ��������� ������ ������ �������
        for (int i = 0; i < matrix.length; i++) {
            // �������� ������� ��� ���������������
            int[][] smallerMatrix = new int[matrix.length - 1][matrix.length - 1];
            todo(); // ���������� smallerMatrix ������� ���������� �� matrix

            // ���������� ��������������� ����������� �������
            int subDeterminant = determinant(smallerMatrix);

            // ����������� ����� ��� �������� i ����������
            int sign = (i % 2 == 0) ? 1 : -1;

            // ���������� ���������� � ������ �������� i ����������, ��� ����� � ���������������
            result += sign * matrix[0][i] * subDeterminant;
        }
        return result;
    }

}

    public static void main(String[] args) throws IllegalAccessException {
        // ������ �������� �������� ������� ����� 3
        Vector zeroVector = new Vector(3);
        System.out.println("������� ������ ����� 3: " + zeroVector);

        // ������ �������� ������� � ��������� ����������
        int[] items = {1, 2, 3};
        Vector vectorA = new Vector(items);
        System.out.println("������ A: " + vectorA);

        // ������ �������� ���� ��������
        int[] itemsB = {4, 5, 6};
        Vector vectorB = new Vector(itemsB);
        System.out.println("������ B: " + vectorB);
        Vector sumVector = vectorA.add(vectorB);
        System.out.println("����� �������� A � B: " + sumVector);

        // ������ ��������� ���� ��������
        Vector diffVector = vectorA.subtract(vectorB);
        System.out.println("�������� �������� A � B: " + diffVector);

        // ������ ���������� ������������ ���� ��������
        int dotProduct = vectorA.dotProduct(vectorB);
        System.out.println("��������� ������������ �������� A � B: " + dotProduct);

        // ������ ��������� ������� �� ������
        int scalar = 2;
        Vector scalarProduct = vectorA.scalarMultiply(scalar);
        System.out.println("��������� ������� A �� ������ 2: " + scalarProduct);

        // ������ ���������� ����� (�����) �������
        double length = vectorA.length();
        System.out.println("����� (�����) ������� A: " + length);

        // �������� ������� A 2x2
        Matrix A = new Matrix(2, 2);
        A.rows[0] = new int[]{1, 2};
        A.rows[1] = new int[]{3, 4};
        System.out.println("Matrix A:");
        System.out.println(A.toString());

        // �������� ������� B 2x2
        Matrix B = new Matrix(2, 2);
        B.rows[0] = new int[]{2, 0};
        B.rows[1] = new int[]{1, 2};
        System.out.println("Matrix B:");
        System.out.println(B.toString());

        // �������� ������ A � B
        Matrix C = A.add(B);
        System.out.println("Matrix A + B:");
        System.out.println(C.toString());

        // ��������� ������ B �� A
        Matrix D = A.subtract(B);
        System.out.println("Matrix A - B:");
        System.out.println(D.toString());

        // ��������� ������ A � B
        Matrix E = A.multiply(B);
        System.out.println("Matrix A * B:");
        System.out.println(E.toString());

        // ��������� ������� A �� ������
        int scalar3 = 3;
        Matrix F = A.scalarMultiply(scalar3);
        System.out.println("Matrix A * " + scalar3 + ":");
        System.out.println(F.toString());

        // ���������������� ������� A
        Matrix G = A.transpose();
        System.out.println("Matrix A Transpose:");
        System.out.println(G.toString());

        // �������� ���������� ������� 3x3
        Matrix H = new Matrix(3, 3);
        H.rows[0] = new int[]{4, 3, 2};
        H.rows[1] = new int[]{1, 3, 1};
        H.rows[2] = new int[]{2, 1, 4};
        System.out.println("Matrix H:");
        System.out.println(H.toString());

        // ���������� ������������ ������� H
        int det = H.determinant();
        System.out.println("Determinant of Matrix H:");
        System.out.println(det);

    }
}
