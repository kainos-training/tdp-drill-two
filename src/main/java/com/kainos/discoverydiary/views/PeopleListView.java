package com.kainos.discoverydiary.views;

import com.kainos.discoverydiary.models.Person;
import io.dropwizard.views.View;

import java.util.List;

public class PeopleListView extends View {

    private final List<Person> people;

    public PeopleListView(List<Person> people) {
        super("/Views/people/list.ftl");
        this.people = people;
    }

    public List<Person> getPeople() {
        return people;
    }
}