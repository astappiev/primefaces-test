package org.primefaces.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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
    private String[] selectedViaCheckbox;
    private String[] selectedViaMenu;
    private String[] selectedViaAutocomplete;
    private List<String> selectedViaAutocompleteList;

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

        selectedViaCheckbox = new String[]{"BMW"};
        selectedViaMenu = new String[]{"Toyota"};
        selectedViaAutocomplete = new String[]{"Tesla"};
        selectedViaAutocompleteList = new ArrayList<>(Collections.singletonList("Tesla"));
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

    public String[] getSelectedViaCheckbox() {
        return selectedViaCheckbox;
    }

    public void setSelectedViaCheckbox(String[] selectedViaCheckbox) {
        this.selectedViaCheckbox = selectedViaCheckbox;
    }

    public String[] getSelectedViaMenu() {
        return selectedViaMenu;
    }

    public void setSelectedViaMenu(String[] selectedViaMenu) {
        this.selectedViaMenu = selectedViaMenu;
    }

    public String[] getSelectedViaAutocomplete() {
        return selectedViaAutocomplete;
    }

    public void setSelectedViaAutocomplete(String[] selectedViaAutocomplete) {
        this.selectedViaAutocomplete = selectedViaAutocomplete;
    }

    public List<String> getSelectedViaAutocompleteList() {
        return selectedViaAutocompleteList;
    }

    public void setSelectedViaAutocompleteList(List<String> selectedViaAutocompleteList) {
        this.selectedViaAutocompleteList = selectedViaAutocompleteList;
    }
}
