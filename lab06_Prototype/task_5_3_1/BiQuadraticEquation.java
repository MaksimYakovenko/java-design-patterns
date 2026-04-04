import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BiQuadraticEquation extends QuadraticEquation {

    public BiQuadraticEquation(double a, double b, double c) {
        super(a, b, c);
        this.coefficients = new ArrayList<>();
        this.coefficients.add(a);
        this.coefficients.add(0.0);
        this.coefficients.add(b);
        this.coefficients.add(0.0);
        this.coefficients.add(c);
    }

    protected BiQuadraticEquation(BiQuadraticEquation other) {
        super(other.a, other.b, other.c);
        this.coefficients = new ArrayList<>(other.coefficients);
    }

    @Override
    public BiQuadraticEquation clone() {
        try {
            BiQuadraticEquation cloned = (BiQuadraticEquation) super.clone();
            cloned.coefficients = new ArrayList<>(this.coefficients);
            return cloned;
        } catch (CloneNotSupportedException e) {
            // Альтернативний спосіб через конструктор копіювання
            return new BiQuadraticEquation(this);
        }
    }

    @Override
    public List<Double> solve() {
        List<Double> solutions = new ArrayList<>();

        if (Math.abs(a) < 1e-10) {
            QuadraticEquation quadratic = new QuadraticEquation(b, 0, c);
            return quadratic.solve();
        }
        QuadraticEquation quadratic = new QuadraticEquation(a, b, c);
        List<Double> tSolutions = quadratic.solve();

        if (!tSolutions.isEmpty() && tSolutions.get(0).equals(Double.POSITIVE_INFINITY)) {
            solutions.add(Double.POSITIVE_INFINITY);
            return solutions;
        }

        for (Double t : tSolutions) {
            if (t > 1e-10) {
                solutions.add(Math.sqrt(t));
                solutions.add(-Math.sqrt(t));
            } else if (Math.abs(t) < 1e-10) {
                if (solutions.isEmpty() || Math.abs(solutions.get(solutions.size() - 1)) > 1e-10) {
                    solutions.add(0.0);
                }
            }
        }

        Collections.sort(solutions);

        return solutions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (Math.abs(a) > 1e-10) {
            sb.append(String.format("%.2fx⁴", a));
        }

        if (Math.abs(b) > 1e-10) {
            if (b > 0 && sb.length() > 0) {
                sb.append(" + ");
            } else if (b < 0) {
                sb.append(" - ");
                sb.append(String.format("%.2fx²", Math.abs(b)));
            } else {
                sb.append(String.format("%.2fx²", b));
            }
            if (b > 0) {
                sb.append(String.format("%.2fx²", b));
            }
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
}

