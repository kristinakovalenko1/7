import java.util.ArrayList;
import java.util.List;

public class EquilateralTriangleTest {

    public ArrayList<EquilateralTriangle> getEquilateralTriangleList() {
        return equilateralTriangleList;
    }

    public void setEquilateralTriangleList(ArrayList<EquilateralTriangle> equilateralTriangleList) {
        this.equilateralTriangleList = equilateralTriangleList;
    }

    private ArrayList<EquilateralTriangle> equilateralTriangleList = new ArrayList<>();

    public void add(EquilateralTriangle triangle) {
        this.equilateralTriangleList.add(triangle);
    }

    /**
     * Нахождение самого большого треугольника
     **/
    public int getTheMaxEquilateralTriangle() {
        int maxIndex = 0;
        for (int i = 1; i < this.equilateralTriangleList.size() - 1; i++) {
            if (this.equilateralTriangleList.get(maxIndex).getTriangle().getPerimeter() < this.equilateralTriangleList.get(i).getTriangle().getPerimeter()) {
                maxIndex = i;
                i++;
            }
        }
        return maxIndex;
    }

    /**
     * Вывод сведений о самом большом равностроннем треугольнике
     ***/
    @Override
    public String toString() {
        String str = "The max equilateral triangle: " + equilateralTriangleList.get(getTheMaxEquilateralTriangle()).toString();
        return str;
    }


}