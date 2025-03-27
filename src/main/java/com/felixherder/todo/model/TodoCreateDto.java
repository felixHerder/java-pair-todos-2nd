package com.felixherder.todo.model;

public class TodoCreateDto {
    private String title;
    private String content;

    public TodoCreateDto(String title, String content) {
        this.title = title;
        this.content = content;

    }

    public Todo mapToTodo(){
        Todo todo = new Todo();
        todo.setTitle(this.title);
        todo.setContent(this.content);

        return todo;
    }
}
