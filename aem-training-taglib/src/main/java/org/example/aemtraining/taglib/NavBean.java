package org.example.aemtraining.taglib;

import com.day.cq.wcm.api.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ihar_Zhavarankau on 6/25/2014.
 */
public class NavBean {

    private List<Page> firstLevel = new ArrayList<Page>();

    private List<Page> secondLevel = new ArrayList<Page>();

    private Page currentFirstLevel;

    public List<Page> getFirstLevel() {
        return firstLevel;
    }

    public void setFirstLevel(List<Page> firstLevel) {
        this.firstLevel = firstLevel;
    }

    public List<Page> getSecondLevel() {
        return secondLevel;
    }

    public void setSecondLevel(List<Page> secondLevel) {
        this.secondLevel = secondLevel;
    }

    public Page getCurrentFirstLevel() {
        return currentFirstLevel;
    }

    public void setCurrentFirstLevel(Page currentFirstLevel) {
        this.currentFirstLevel = currentFirstLevel;
    }
}
