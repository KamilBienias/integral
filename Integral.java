import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Integral {

    @XmlElement(name = "leftEndOfInterval")
    private double leftEnd;
    @XmlElement(name = "rightEndOfInterval")
    private double rigthEnd;
    @XmlElement(name = "numberOfPartsOnInterval")
    private int division;
    @XmlElement(name = "degree")
    private int degree;
    @XmlElement(name = "coefficientsFrom_a0_to_an")
    private double[] coefficients;
    @XmlElement(name = "valueOfIntegral")
    private double integral;

    //a non-argument constructor is needed to create an xml file
    public Integral() {
    }

    public Integral(double leftEnd, double rigthEnd, int division, int degree, double[] coefficients, double integral) {
        this.leftEnd = leftEnd;
        this.rigthEnd = rigthEnd;
        this.division = division;
        this.degree = degree;
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

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
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
        return  "left end of interval= " + leftEnd +
                "\nrigth end of interval= " + rigthEnd +
                "\nnumber od parts in interval division= " + division +
                "\ndegree= " + degree +
                "\ncoefficients from a0 to an= " + Arrays.toString(coefficients) +
                "\nvalue of integral= " + integral;
    }
}
