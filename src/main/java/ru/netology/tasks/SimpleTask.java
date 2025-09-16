package ru.netology.tasks;

public class SimpleTask extends Task {
    protected String title;

    public SimpleTask(int id, String title) {
        super(id);
        this.title = title;
    }

    @Override
    public boolean matches(String query) {
        if (title.contains(query)) {
            return true;
        } else {
            return false;
        }
    }

    public String getTitle() {
        return title;
    }
}