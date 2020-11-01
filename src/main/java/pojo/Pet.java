package pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pet {

    int id;
    Map<Integer, String> category;
    String name;
    List<String> photoUrl;
    List<Map<Integer, String>> tags;
    String status;

    public String getPetInfo(){

        StringBuffer sb = new StringBuffer();
        sb.append("{ \"id\":"+id+"");
        return "";
    }
}

