package org.primefaces.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TestView implements Serializable {

    private String testString;

    private List<String> cars;
    private String[] selectedArray;
    private List<String> selectedList;

    @PostConstruct
    public void init() {
        testString = "Welcome to PrimeFaces!!!";

        cars = new ArrayList<>();
        cars.add("Chrysler");
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Volkswagen");
        cars.add("Chrysler");
        cars.add("Ford");
        cars.add("Tesla");
        cars.add("Toyota");
        cars.add("Hyundai");
        cars.add("General Motors");

        selectedArray = new String[]{"BMW", "Tesla"};
        selectedList = new ArrayList<>(Arrays.asList("Hyundai", "Mercedes"));
    }

    public List<String> completeCar(String query) {
        String queryLowerCase = query.toLowerCase();
        return cars.stream().filter(c -> c.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }

    public void save() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("save."));
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    public String[] getSelectedArray() {
        return selectedArray;
    }

    public void setSelectedArray(String[] selectedArray) {
        this.selectedArray = selectedArray;
    }

    public List<String> getSelectedList() {
        return selectedList;
    }

    public void setSelectedList(List<String> selectedList) {
        this.selectedList = selectedList;
    }
}
