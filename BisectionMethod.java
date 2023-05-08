public class BisectionMethod {
    public static void main(String[] args) {
        double a = 0; // đầu đoạn [a, b]
        double b = 1; // cuối đoạn [a, b]
        double tol = 0.00001; // độ chính xác mong muốn
        int maxIter = 100; // số lần lặp tối đa

        double c = (a + b) / 2; // điểm giữa của đoạn [a, b]
        System.out.println(c);

        double fc = f(c); // giá trị của hàm số tại điểm giữa

        int iter = 0; // số lần lặp hiện tại

        while (Math.abs(fc) < tol && iter < maxIter) {
            System.out.println(fc);
            if (fc > 0) {
                // nghiệm nằm trong đoạn [a, c]
                b = c;
            }else if(fc<0) {
                // nghiệm nằm trong đoạn [c, b]
                a = c;
            }

            c = (a + b) / 2;
            fc = f(c);

            iter++;
            System.out.println(c);


        }

        if (iter == maxIter) {
            System.out.println("Không tìm thấy nghiệm sau " + maxIter + " lần lặp.");
        } else {
            System.out.println("Nghiệm của hàm số trên đoạn [0, 1] là: " + c);
            System.out.println("Giá trị của hàm số tại nghiệm là: " + fc);
        }
    }

    public static double f(double x) {
        return 3*x-Math.exp(x);
    }
}
