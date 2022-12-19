public class EquilateralTriangle extends Triangle  {
    Triangle triangle;

    public EquilateralTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

    public EquilateralTriangle() {
    }

    /**
     * Проверка на равносторонний треугольник
     **/
    public boolean isTriangleEquilateral() {
        if (triangle.isReal()) {
            if (triangle.getA() == triangle.getB() && triangle.getB() == triangle.getC()) ;
            {
                return true;
            }
        } else return false;

    }

    /**
     * Метод вывода сведений о треугольнике
     **/

    @Override
    public String toString() {
        if (isTriangleEquilateral()) {
            String str = triangle.toString() + ". It's equilateral triangle. ";
            return str;
        } else triangle.toString();
        String str = "It's not equilateral triangle.";
        return str;
    }

}