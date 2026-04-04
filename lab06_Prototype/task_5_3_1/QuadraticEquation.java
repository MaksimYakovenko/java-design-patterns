import java.util.ArrayList;
import java.util.List;

// Клас для квадратного рівняння ax² + bx + c = 0
public class QuadraticEquation extends Equation {
    protected double a;

    public QuadraticEquation(double a, double b, double c) {
        super(b, c);
        this.a = a;
        this.coefficients = new ArrayList<>();
        this.coefficients.add(a);
        this.coefficients.add(b);
        this.coefficients.add(c);
    }

    // Конструктор копіювання
    protected QuadraticEquation(QuadraticEquation other) {
        super(other);
        this.a = other.a;
        this.coefficients = new ArrayList<>(other.coefficients);
    }

    @Override
    public QuadraticEquation clone() {
        try {
            QuadraticEquation cloned = (QuadraticEquation) super.clone();
            // Глибоке копіювання для змінюваних полів
            cloned.coefficients = new ArrayList<>(this.coefficients);
            return cloned;
        } catch (CloneNotSupportedException e) {
            // Альтернативний спосіб через конструктор копіювання
            return new QuadraticEquation(this);
        }
    }

    @Override
    public List<Double> solve() {
        List<Double> solutions = new ArrayList<>();

        if (Math.abs(a) < 1e-10) {
            Equation linear = new Equation(b, c);
            return linear.solve();
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant < -1e-10) {
            return solutions;
        }

        if (Math.abs(discriminant) < 1e-10) {
            solutions.add(-b / (2 * a));
            return solutions;
        }

        double sqrtD = Math.sqrt(discriminant);
        solutions.add((-b + sqrtD) / (2 * a));
        solutions.add((-b - sqrtD) / (2 * a));

        return solutions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (Math.abs(a) > 1e-10) {
            sb.append(String.format("%.2fx²", a));
        }

        if (Math.abs(b) > 1e-10) {
            if (b > 0 && sb.length() > 0) {
                sb.append(" + ");
            } else if (b < 0) {
                sb.append(" - ");
                sb.append(String.format("%.2fx", Math.abs(b)));
            } else {
                sb.append(String.format("%.2fx", b));
            }
            if (b > 0) {
                sb.append(String.format("%.2fx", b));
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

