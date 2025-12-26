package observer.application.service.source.loombard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {
    String formatted;
    String numbers;
    String decimals;
    int myint;

    @JsonProperty("formatted")
    public String getFormatted() {
        return this.formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    @JsonProperty("numbers")
    public String getNumbers() {
        return this.numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    @JsonProperty("decimals")
    public String getDecimals() {
        return this.decimals;
    }

    public void setDecimals(String decimals) {
        this.decimals = decimals;
    }

    @JsonProperty("int")
    public int getMyint() {
        return this.myint;
    }

    public void setMyint(int myint) {
        this.myint = myint;
    }
}
