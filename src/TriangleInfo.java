import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TriangleInfo implements Serializable {


    public ArrayList<Triangle> getTriangleList() {
        return triangleList;
    }

    public void setTriangleList(ArrayList<Triangle> triangleList) {
        this.triangleList = triangleList;
    }

    private ArrayList<Triangle> triangleList = new ArrayList<>();

    public void add(Triangle triangle) {
        triangleList.add(triangle);
    }

    /**
     * Получение среднего значения площади
     **/
    public double getAverageSquare() {
        double averageSquare = 0;
        for (int i = 0; i < this.triangleList.size(); i++) {
            averageSquare += this.triangleList.get(i).getSquare();
        }
        return averageSquare / this.triangleList.size();
    }

    /**
     * Вывод сведений о среднем значении площади
     **/
    @Override
    public String toString() {
        String str = "The average square: " + getAverageSquare();
        return str;
    }
}