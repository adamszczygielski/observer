package observer.application.service.source.loombard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MetaData {
    String title;
    ArrayList<String> callouts;
    int callouts_count;

    @JsonProperty("title")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("callouts")
    public ArrayList<String> getCallouts() {
        return this.callouts;
    }

    public void setCallouts(ArrayList<String> callouts) {
        this.callouts = callouts;
    }

    @JsonProperty("callouts_count")
    public int getCallouts_count() {
        return this.callouts_count;
    }

    public void setCallouts_count(int callouts_count) {
        this.callouts_count = callouts_count;
    }
}
