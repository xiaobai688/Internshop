public class SquareEquation {

    double a, b, c;
    double root1, root2;
    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getRootOne() throws NoRealRootException, NoSquareEquationException {
        if (a!= 0) {

            double disk = b * b - 4 * a * c;

            if (disk >= 0) {
                root1 = (-b + Math.sqrt(disk)) / (2 * a);
            } else {

                throw new NoRealRootException("没有实根");
            }
        } else {

            throw new NoSquareEquationException("不是二次方程");
        }
        return root1;
    }

    public double getRootTwo() throws NoRealRootException, NoSquareEquationException {
        if (a!= 0) {

            double disk = b*b-4*a*c;

            if (disk >= 0) {
                root2 = (-b-Math.sqrt(disk))/(2*a);
            } else {
                throw new NoRealRootException("没有实根");
            }
        } else {
            throw new NoSquareEquationException("不是二次方程");
        }
        return root2;
    }

    public static void main(String[] args) throws NoRealRootException, NoSquareEquationException {
        SquareEquation equation = new SquareEquation();
        double a=1.0;
        double b=3.0;
        double c=1.0;

        //double rootTwo = equation.getRootTwo(a, b, c);
        //System.out.println(rootTwo);
    }


}

