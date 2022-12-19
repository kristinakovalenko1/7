import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class SaveLoad {


    /**
     * Реализация метода Save (и резервное копирование)
     */
    public void Save(String filename, ArrayList list) throws IOException {
        String tm2 = getNameCopyFile();
        File f1 = new File(filename);
        FileWriter outStreamf = new FileWriter(tm2+filename);
        File f2 = new File(tm2+filename);
        FileWriter outStream = new FileWriter(filename);
        copyFile(f1,f2);
        BufferedWriter bw = new BufferedWriter(outStream);
        for (Triangle triangle : (ArrayList<Triangle>)list) {
                try {
                    bw.write(String.valueOf(triangle.getA()));
                    bw.write(System.lineSeparator());
                    bw.write(String.valueOf(triangle.getB()));
                    bw.write(System.lineSeparator());
                    bw.write(String.valueOf(triangle.getC()));
                    bw.write(System.lineSeparator());
                    bw.write(String.valueOf(triangle.getPerimeter()));
                    bw.write(System.lineSeparator());
                    bw.write(String.valueOf(triangle.getSquare()));
                    bw.write(System.lineSeparator());
                    bw.write(String.valueOf(triangle.getAngles()[0]));
                    bw.write(System.lineSeparator());
                    bw.write(String.valueOf(triangle.getAngles()[1]));
                    bw.write(System.lineSeparator());
                    bw.write(String.valueOf(triangle.getAngles()[2]));
                    bw.write(System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        bw.close();
        tm2 = getNameCopyFile();
        f2 = new File(tm2+filename);
        outStreamf = new FileWriter(tm2+filename);
        outStreamf.close();
        copyFile(f1,f2);
        outStream.close();
    }

    /**
     * Реализация метода Load
     */
    public void Load(String filename, ArrayList list) throws IOException {
        this.Clear(list);
        Scanner scanner = new Scanner(new FileReader(filename));
        double a = -1;
        double b = -1;
        double c = -1;
        while (scanner.hasNextLine()) {
            a = Double.parseDouble(scanner.nextLine());
            b = Double.parseDouble(scanner.nextLine());
            c = Double.parseDouble(scanner.nextLine());
            list.add(new Triangle(a, b, c));
        }
        scanner.close();
    }

    /**
     * Реализация метода Clear
     */

    public void Clear(ArrayList list) {
        list.clear();
    }
    /**
     * Реализация сериализации
     */
    public void Serialize(String filename, ArrayList list) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Реализация десериализации
     */

    public void Deserialize(String filename, ArrayList list) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            list = (ArrayList<Triangle>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    /**
     * Реализация сериализации с помощью библиотеки fastjson
     */

    public void sFastJSON(String filename, ArrayList list) throws IOException {
        FileWriter outStream = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(outStream);
        bw.write(JSON.toJSONString(list));
        bw.close();
        outStream.close();
    }

    /**
     * Реализация десериализации с помощью библиотеки fastjson
     */

    public void dFastJSON(String filename, ArrayList list) throws IOException {
        Scanner scanner = new Scanner(new FileReader(filename));
        this.Clear(list);
        ArrayList<JSONObject> JSONlist = JSON.parseObject(scanner.nextLine(), ArrayList.class);
        for (JSONObject st : JSONlist) {
                TriangleInfo t = new TriangleInfo();
                t.add(new Triangle(st.getDoubleValue("a"), st.getDoubleValue("b"),st.getDoubleValue("c")));

        }
        scanner.close();
    }

    public String getNameCopyFile(){
        LocalDateTime tm = LocalDateTime.now();
        String tm2 = ""+tm;
        //tm2 = tm2.replace("-", "_");
        tm2 = tm2.replace(".", "_");
        tm2 = tm2.replace(":", "-");
        //tm2 = tm2.substring(0, tm2.lastIndexOf('_'));
        return tm2;
    }

    private static void copyFile(File source, File dest) throws IOException {
        FileChannel sourceChannel;
        FileChannel destChannel;
        sourceChannel = new FileInputStream(source).getChannel();
        destChannel = new FileOutputStream(dest).getChannel();
        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());

    }
}