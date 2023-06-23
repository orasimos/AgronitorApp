package gr.aueb.cf.agronitor.apiclient.greenhouses;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.cf.agronitor.models.Greenhouse;

public class GreenhouseResponseList {
    private ArrayList<Greenhouse> greenhouseList;

    public GreenhouseResponseList(ArrayList<Greenhouse> greenhouseList) {
        this.greenhouseList = greenhouseList;
    }

    public List<Greenhouse> getGreenhouseList() {
        return greenhouseList;
    }

    public void setGreenhouseList(ArrayList<Greenhouse> greenhouseList) {
        this.greenhouseList = greenhouseList;
    }
}
