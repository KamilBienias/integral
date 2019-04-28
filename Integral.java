import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Integral {

    @XmlElement(name = "left-end-of-interval")
    private double leftEnd;
    @XmlElement(name = "right-end-of-interval")
    private double rigthEnd;
    @XmlElement(name = "number-of-parts-on-interval")
    private int division;
    @XmlElement(name = "coefficients-from-a0-to-higher")
    private double[] coefficients;
    @XmlElement(name = "value-of-integral")
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
        return  "Left end of interval=" + leftEnd +
                "\n, rigth end of interval=" + rigthEnd +
                "\n, number od parts in interval division=" + division +
                "\n, coefficients from a0 to higher=" + Arrays.toString(coefficients) +
                "\n, value of integral=" + integral;
    }
}
