import java.io.Serializable;

public class Triangle implements Serializable {
    double a;
    double b;
    double c;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }


    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод проверки треугольника на существование
     **/
    public boolean isReal() {
        if (a + b > c && a + c > b && b + c > a)
            return true;
        else return false;
    }

    /**
     * Получение периметра треугольника
     **/
    public double getPerimeter() {
        if (isReal()) {
            return a + b + c;
        }
        return 0;
    }

    /**
     * Получение площади треугольника
     **/
    public double getSquare() {
        if (isReal()) {
            double p = getPerimeter() / 2.0;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return 0;
    }

    /**
     * Получение углов треугольника
     **/
    public double[] getAngles() {
        double[] angles = new double[3];
        if (isReal()) {

            double lenMax = Math.max(c, Math.max(a, b));
            double h = (2 * getSquare()) / lenMax;
            if (lenMax == c) {
                angles[0] = (h / a) * (180 / Math.PI);
                angles[1] = (h / b) * (180 / Math.PI);
                angles[2] = 180 - angles[0] - angles[1];
            } else if (lenMax == b) {
                angles[0] = (h / c) * (180 / Math.PI);
                angles[1] = (h / a) * (180 / Math.PI);
                angles[2] = 180 - angles[0] - angles[1];
            } else if (lenMax == a) {
                angles[0] = (h / c) * (180 / Math.PI);
                angles[1] = (h / b) * (180 / Math.PI);
                angles[2] = 180 - angles[0] - angles[1];
            }
        } else {
            angles[0] = 0;
            angles[1] = 0;
            angles[2] = 0;
        }
        return angles;
    }

    /**
     * Вывод сведений о треугольнике
     **/
    @Override
    public String toString() {
        if (isReal()) {
            String str = "The triangle is real. It's sides are: a= " + this.getA() + " b= " + this.getB() + " c= " + this.getC() + ". Perimeter is " + this.getPerimeter() + ". Square is " + this.getSquare() + ". Angles are " + this.getAngles()[0] + " " + this.getAngles()[1] + " " + this.getAngles()[2] + ".";
            return str;
        } else {
            String str = " Triangle doesn't exist!";
            return str;
        }
    }
}