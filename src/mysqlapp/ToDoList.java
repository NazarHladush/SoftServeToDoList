package mysqlapp;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ToDoList implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String description;
    private String action;
    private String time;

    public ToDoList() {
    }

    public ToDoList(String title, String description, String action) {
        this.title = title;
        this.description = description;
        this.action = action;
    }

    public ToDoList(int id, String title, String description, String action, String time) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.action = action;
        this.time = time;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", action='" + action + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
