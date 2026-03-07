public class EquationFactory {
    public static Equation createEquation(double[] coefficients) {
        if (coefficients == null || coefficients.length == 0) {
            throw new IllegalArgumentException("Масив коефіцієнтів не може бути порожнім");
        }

        switch (coefficients.length) {
            case 2:
                return new Equation(coefficients[0], coefficients[1]);

            case 3:
                return new QuadraticEquation(coefficients[0], coefficients[1], coefficients[2]);

            case 5:
                return new BiQuadraticEquation(coefficients[0], coefficients[2], coefficients[4]);

            default:
                throw new IllegalArgumentException(
                    "Непідтримувана кількість коефіцієнтів: " + coefficients.length);
        }
    }
}

