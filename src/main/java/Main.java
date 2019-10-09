import com.google.gson.Gson;
import model.ToDoList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        LocalDateTime t;
//        LocalDateTime date = LocalDateTime.parse("2019-12-30T15:00");
//        System.out.println(date);

//        ArrayList<ToDoList> toDoLists = new ArrayList<>();
//        toDoLists.add(new ToDoList(5,"aaaaaa","bbbbb","ccccc",LocalDateTime.parse("2019-12-30T15:00"), 7));
//        String jsonInString = new Gson().toJson(toDoLists);
//        System.out.println(jsonInString);
        Gson gson = new Gson();
        String json = "{'id':94,'title':'jjj','description':'dd','action':'Today','time':{'date':{'year':2011,'month':11,'day':11},'time':{'hour':11,'minute':11,'second':0,'nano':0}},'userId':13}";
        ToDoList toDoList = gson.fromJson(json, ToDoList.class);
        System.out.println(toDoList);

    }
}
