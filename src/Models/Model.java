package Models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Model extends JSONArray {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private File file;
    private JSONArray allData;

    public Model(File file) {
        setFile(file);
    }

    public JSONArray getAllData() {
        JSONParser parser = new JSONParser();
        try {
            allData = (JSONArray) parser.parse(ReadFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allData;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void WriteToFile(JSONArray data) {
        try {
            FileWriter filewriter = new FileWriter(getFile());
            BufferedWriter bufferedWriter = new BufferedWriter(filewriter);

            bufferedWriter.write(data.toString());

            bufferedWriter.close();
            filewriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FileReader ReadFile() {
        FileReader ret = null;
        try {
            ret = new FileReader(getFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public void addObject(JSONObject object) {
        JSONArray curuntData = getAllData();
        curuntData.add(object);
        WriteToFile(curuntData);
    }

    public void removeObject(int Id) {
        ArrayList<JSONObject> curruntData = getAllData();
        JSONArray newData = new JSONArray();

        for (int i = 0; i < curruntData.size(); i++) {
            if (i == Id)
                continue;
            newData.add(curruntData.get(i));
        }
        WriteToFile(newData);
    }

}
