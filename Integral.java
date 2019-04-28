import java.util.Arrays;

public class Integral {

    private double leftEnd;
    private double rigthEnd;
    private int division;
    private double[] coefficients;
    private double integral;

    //a non-argument constructor is needed to create an xml file
    public Integral() {
    }

    public Integral(double leftEnd, double rigthEnd, int division, double[] coefficients, double integral) {
        this.leftEnd = leftEnd;
        this.rigthEnd = rigthEnd;
        this.division = division;
        this.coefficients = coefficients;
        this.integral = integral;
    }

    //getters are needed to xml file
    public double getLeftEnd() {
        return leftEnd;
    }

    public void setLeftEnd(double leftEnd) {
        this.leftEnd = leftEnd;
    }

    public double getRigthEnd() {
        return rigthEnd;
    }

    public void setRigthEnd(double rigthEnd) {
        this.rigthEnd = rigthEnd;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(double[] coefficients) {
        this.coefficients = coefficients;
    }

    public double getIntegral() {
        return integral;
    }

    public void setIntegral(double integral) {
        this.integral = integral;
    }

    @Override
    public String toString() {
        return  "Left end of intervall=" + leftEnd +
                "\n, rigth end of intervall=" + rigthEnd +
                "\n, number od parts in interval division=" + division +
                "\n, coefficients from a0 to higher=" + Arrays.toString(coefficients) +
                "\n, value of integral=" + integral;
    }
}
