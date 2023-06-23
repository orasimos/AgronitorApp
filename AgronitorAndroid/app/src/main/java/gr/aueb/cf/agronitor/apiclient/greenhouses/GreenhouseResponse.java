package gr.aueb.cf.agronitor.apiclient.greenhouses;

import java.util.List;

import gr.aueb.cf.agronitor.models.Greenhouse;

public class GreenhouseResponse {
    List<Greenhouse> greenhouseList;

    public GreenhouseResponse(List<Greenhouse> greenhouseList) {
        this.greenhouseList = greenhouseList;
    }

//    public GreenhouseResponse() {
//    }

    public List<Greenhouse> getGreenhouseList() {
        return greenhouseList;
    }

    public void setGreenhouseList(List<Greenhouse> greenhouseList) {
        this.greenhouseList = greenhouseList;
    }
}
