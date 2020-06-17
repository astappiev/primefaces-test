package org.primefaces.test;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@ViewScoped
public class TestView implements Serializable {
    private static final Logger log = LogManager.getLogger(TestView.class);

    private List<String> list;

    @PostConstruct  
    public void init() {
        list = List.of("one", "two", "three");
    }

    public void onSubmit() {
        log.info("onSubmit()");
    }

    public List<String> getList() {
        log.info("getList()");
        return list;
    }

    public void setList(final List<String> list) {
        this.list = list;
    }
}
