package com.app.maybedrink.model;

public class HomeItem {
    private String name;
    private int id, imageID, notificationCount;

    public HomeItem() {
        super();
    }

    public HomeItem(String name, int id, int imageID, int notificationCount) {
        this.name = name;
        this.id = id;
        this.imageID = imageID;
        this.notificationCount = notificationCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getNotificationCount() {
        return notificationCount;
    }

    public void setNotificationCount(int notificationCount) {
        this.notificationCount = notificationCount;
    }

    @Override
    public String toString() {
        return "HomeItem{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", imageID=" + imageID +
                ", notificationCount=" + notificationCount +
                '}';
    }
}
