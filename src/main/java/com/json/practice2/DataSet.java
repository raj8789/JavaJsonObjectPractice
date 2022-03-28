package com.json.practice2;

import java.util.List;

public class DataSet {
   private List <Data> data;
    private List<Include> included;

    public List<Include> getIncluded() {
        return included;
    }

    public void setIncluded(List<Include> included) {
        this.included = included;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
