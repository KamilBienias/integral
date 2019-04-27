import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegralOfPolynominal {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nThe program calculates definite integral from the polynomial in the given range.");
        System.out.println("\nEnter the ends of the interval on which the polynomial is specified (left <right)");
        double left = 0;
        double right = 0;
        boolean isIntervalError = true;
        while (isIntervalError) {
            try {
                System.out.print("Left end = ");
                left = scanner.nextDouble();
                System.out.print("Right end = ");
                right = scanner.nextDouble();
                if(left >= right) {
                    throw new IllegalArgumentException();
                }
            isIntervalError = false;
            }catch (IllegalArgumentException e){
                System.out.println("The left end must be less than the right one");
                scanner.nextLine();
            }catch (InputMismatchException e) {
                System.out.println("It is in not a number");
                scanner.nextLine();
            }
        }

        System.out.println("\nEnter the number of sections to be divided (the more the more precisely): ");
        int division = 0;
        boolean isDivisionError = true;
        while (isDivisionError) {
            try {
                division = scanner.nextInt();//the section will be divided into so many parts
                if(division < 1 || division > Integer.MAX_VALUE){
                    throw new IllegalArgumentException();
                }
                isDivisionError = false;
            }catch (IllegalArgumentException e){
                System.out.println("The number of parts must be greater than 0, but less than " + Integer.MAX_VALUE);
                scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("It is not an integer. The number of parts must be greater than 0, but less than " + Integer.MAX_VALUE);
                scanner.nextLine();
            }
        }
        double diameterOfDivision = (right - left) / division;//the length of each part is called the diameter of the division
        System.out.println("\nSo you will divide the interval into " + division + " parts,");
        System.out.println("each with a length " + diameterOfDivision);

        System.out.print("Give the polynomial degree: ");
        int degree = 0;
        boolean isDegreeError = true;
        while (isDegreeError) {
            try {
                degree = scanner.nextInt();
                if(degree < 0){
                    throw new IllegalArgumentException();
                }
                isDegreeError = false;
            }catch (IllegalArgumentException e){
                System.out.println("Degree must be at least 0");
                scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("It is not an integer");
                scanner.nextLine();
            }
        }

        System.out.print("W(x)= ");
        for (int i=degree ; i >= 1; i--)//writes the polynomial form of the given degree
        {
            System.out.print("a" + i + "*x^" + i + " + ");
        }
        System.out.println("a0");

        System.out.println("Enter polynomial coefficients (they can be with a comma):");
        double[] coefficients = new double[degree+1];
        for (int j=degree ; j >= 0; j--)
        {
            System.out.print("a" + j + " = ");
            coefficients[j] = scanner.nextDouble();
        }
        double[] arguments = new double[division];//array of arguments that will be inserted into the function
        double[] values = new double[division];//array of function values ​​for split arguments
        double[] fieldOfRectangle = new double[division];//array of fields of small rectangles
        double sum = 0;//sum of function values ​​for split arguments

        //calculating values ​​for arguments and adding these values
        for (int i = 0; i < division; i++)
        {
            arguments[i] = left + i * diameterOfDivision;
            values[i]=0;//function value for the argument declared above
            for (int k=0; k<=degree; k++)
            {
                double temporaryValue;
                temporaryValue = coefficients[k] * Math.pow(arguments[i], k);
                values[i] = values[i] + temporaryValue;
            }
            fieldOfRectangle[i] = values[i] * diameterOfDivision;
            sum = sum + fieldOfRectangle[i];
        }

        System.out.println("Definite integral on the integral " + left + " to " + right);
        System.out.print("from the function y = ");
        for(int i=degree; i>0; i--)
        {
            System.out.print(coefficients[i] + "*x^" + i + " + ");
        }
        System.out.println(coefficients[0]);
        System.out.println("is equal: " + sum);

        scanner.close();
    }
}
