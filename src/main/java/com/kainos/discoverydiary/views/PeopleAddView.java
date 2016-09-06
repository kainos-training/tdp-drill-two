package com.kainos.discoverydiary.views;

import io.dropwizard.views.View;

import java.util.List;

public class PeopleAddView extends View {

    private final List<String> errors;

    public PeopleAddView(List<String> errors) {
        super("/Views/people/add.ftl");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}