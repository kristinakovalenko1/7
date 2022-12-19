import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Triangle triangle = new Triangle(3, 4, 5);
        Triangle triangle1 = new Triangle(3, 3, 5);
        Triangle triangle2 = new Triangle(3, 6, 5);
        Triangle triangle3 = new Triangle(3, 3, 4);
        Triangle triangle4 = new Triangle(6, 8, 10);
        System.out.println(triangle);
        System.out.println(triangle1);
        TriangleInfo triangleInfo = new TriangleInfo();
        ArrayList<Triangle> triangles = new ArrayList<>();
        triangles.add(triangle);
        triangles.add(triangle1);
        triangles.add(triangle2);
        triangles.add(triangle3);
        triangles.add(triangle4);
        triangleInfo.setTriangleList(triangles);
        System.out.println(triangleInfo);

        EquilateralTriangle equilateralTriangle = new EquilateralTriangle(triangle);
        EquilateralTriangle equilateralTriangle1 = new EquilateralTriangle(triangle1);
        System.out.println(equilateralTriangle);
        System.out.println(equilateralTriangle1);


        EquilateralTriangle equilateralTriangle2 = new EquilateralTriangle(new Triangle(3, 3, 3));
        EquilateralTriangle equilateralTriangle3 = new EquilateralTriangle(new Triangle(5, 5, 5));
        EquilateralTriangle equilateralTriangle4 = new EquilateralTriangle(new Triangle(6, 6, 6));
        EquilateralTriangle equilateralTriangle5 = new EquilateralTriangle(new Triangle(9, 9, 9));
        EquilateralTriangle equilateralTriangle6 = new EquilateralTriangle(new Triangle(8, 8, 8));

        System.out.println(equilateralTriangle2);
        System.out.println(equilateralTriangle3);
        System.out.println(equilateralTriangle4);
        System.out.println(equilateralTriangle5);
        System.out.println(equilateralTriangle6);
        ArrayList<EquilateralTriangle> equilateralTriangleArrayList = new ArrayList<>();
        equilateralTriangleArrayList.add(equilateralTriangle2);
        equilateralTriangleArrayList.add(equilateralTriangle3);
        equilateralTriangleArrayList.add(equilateralTriangle4);
        equilateralTriangleArrayList.add(equilateralTriangle5);
        equilateralTriangleArrayList.add(equilateralTriangle6);
        EquilateralTriangleTest equilateralTriangleTest = new EquilateralTriangleTest();
        equilateralTriangleTest.setEquilateralTriangleList(equilateralTriangleArrayList);
        System.out.println(equilateralTriangleTest);

        ArrayList<Triangle> tr = triangleInfo.getTriangleList();


        long timeStart = System.currentTimeMillis(), t1, t2, t3, t4, t5;
        SaveLoad f = new SaveLoad();
        t1 = System.currentTimeMillis() - timeStart;

        timeStart = System.currentTimeMillis();
        f.Save("Triangle.txt", tr);
        f.Clear(tr);
        f.Load("TriangleForLoad.txt", tr);
        f.Save("Triangle2.txt", tr);
        t2 = System.currentTimeMillis() - timeStart;

        timeStart = System.currentTimeMillis();
        f.Serialize("TriangleSerialize.txt", tr);
        f.Deserialize("TriangleSerialize.txt", tr);
        t3 = System.currentTimeMillis() - timeStart;

        timeStart = System.currentTimeMillis();
        f.sFastJSON("TriangleFJSON.json", tr);
        f.Clear(tr);
        f.dFastJSON("TriangleFJSON.json", tr);
        t4 = System.currentTimeMillis() - timeStart;

        System.out.println("Initial Data Generation:	" + t1 + " ms");
        System.out.println("Text format Save/load:		" + t2 + " ms");
        System.out.println("Java serialization/des:		" + t3 + " ms");
        System.out.println("FastJackson serialization/des:	" + t4 + " ms");

    }
}
