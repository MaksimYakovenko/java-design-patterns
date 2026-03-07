import java.util.ArrayList;
import java.util.List;

public class Equation {
    protected double b;
    protected double c;
    protected List<Double> coefficients;

    public Equation(double b, double c) {
        this.b = b;
        this.c = c;
        this.coefficients = new ArrayList<>();
        this.coefficients.add(b);
        this.coefficients.add(c);
    }

    public List<Double> solve() {
        List<Double> solutions = new ArrayList<>();

        if (Math.abs(b) < 1e-10) {
            if (Math.abs(c) < 1e-10) {
                solutions.add(Double.POSITIVE_INFINITY);
            }
            return solutions;
        }

        solutions.add(-c / b);
        return solutions;
    }

    public boolean hasInfiniteSolutions() {
        List<Double> solutions = solve();
        return !solutions.isEmpty() && solutions.get(0).equals(Double.POSITIVE_INFINITY);
    }

    public int getSolutionCount() {
        List<Double> solutions = solve();
        if (!solutions.isEmpty() && solutions.get(0).equals(Double.POSITIVE_INFINITY)) {
            return Integer.MAX_VALUE;
        }
        return solutions.size();
    }

    public List<Double> getCoefficients() {
        return coefficients;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (Math.abs(b) > 1e-10) {
            sb.append(String.format("%.2fx", b));
        }
        if (Math.abs(c) > 1e-10) {
            if (c > 0 && sb.length() > 0) {
                sb.append(" + ");
            } else if (c < 0) {
                sb.append(" - ");
                sb.append(String.format("%.2f", Math.abs(c)));
            } else {
                sb.append(String.format("%.2f", c));
            }
            if (c > 0) {
                sb.append(String.format("%.2f", c));
            }
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        sb.append(" = 0");
        return sb.toString();
    }

    public String getCoefficientsString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < coefficients.size(); i++) {
            sb.append(String.format("%.0f", coefficients.get(i)));
            if (i < coefficients.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

