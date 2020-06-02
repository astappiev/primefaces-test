package org.primefaces.test;

import java.io.Serializable;
import java.util.*;
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
    private Map<String, List<String>> valueWrapper;

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
        List<String> selectedList = new ArrayList<>(Arrays.asList("Hyundai", "Mercedes"));

        valueWrapper = new HashMap<>();
        valueWrapper.put("cars", selectedList);
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

    public Map<String, List<String>> getValueWrapper() {
        return valueWrapper;
    }

    public void setValueWrapper(Map<String, List<String>> valueWrapper) {
        this.valueWrapper = valueWrapper;
    }
}
