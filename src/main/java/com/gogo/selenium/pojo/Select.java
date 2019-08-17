
package com.gogo.selenium.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "locator",
    "option"
})
public class Select {

    @JsonProperty("locator")
    private Locator locator;
    @JsonProperty("option")
    private Option option;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("locator")
    public Locator getLocator() {
        return locator;
    }

    @JsonProperty("locator")
    public void setLocator(Locator locator) {
        this.locator = locator;
    }

    @JsonProperty("option")
    public Option getOption() {
        return option;
    }

    @JsonProperty("option")
    public void setOption(Option option) {
        this.option = option;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
