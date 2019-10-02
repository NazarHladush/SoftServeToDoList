package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ToDoList implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String description;
    private String action;
    private Timestamp time;
    private int userId;

    public ToDoList() {
    }

    public ToDoList(String title, String description, String action, int userId) {
        this.title = title;
        this.description = description;
        this.action = action;
        this.userId = userId;
    }

    public ToDoList(int id, String title, String description, String action, Timestamp time, int userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.action = action;
        this.time = time;
        this.userId = userId;
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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
public String toString() {
        return "ToDoList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", action='" + action + '\'' +
                ", time=" + time +
                ", userId=" + userId +
                '}';
    }
}
