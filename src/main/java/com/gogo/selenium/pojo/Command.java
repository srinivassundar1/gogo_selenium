
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
        "elementType",
    "select",
    "input",
    "button",
    "waitPageLoad"
})
public class Command {

    @JsonProperty("elementType")
    private String elementType;
    @JsonProperty("select")
    private Select select;
    @JsonProperty("input")
    private Input input;
    @JsonProperty("button")
    private Button button;
    @JsonProperty("waitPageLoad")
    private Integer waitPageLoad;
    @JsonProperty("pageName")
    private String pageName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("elementType")
    public String getElementType() {
        return elementType;
    }

    @JsonProperty("elementType")
    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    @JsonProperty("select")
    public Select getSelect() {
        return select;
    }

    @JsonProperty("select")
    public void setSelect(Select select) {
        this.select = select;
    }

    @JsonProperty("input")
    public Input getInput() {
        return input;
    }

    @JsonProperty("input")
    public void setInput(Input input) {
        this.input = input;
    }

    @JsonProperty("button")
    public Button getButton() {
        return button;
    }

    @JsonProperty("button")
    public void setButton(Button button) {
        this.button = button;
    }

    @JsonProperty("waitPageLoad")
    public Integer getWaitPageLoad() {
        return waitPageLoad;
    }

    @JsonProperty("waitPageLoad")
    public void setWaitPageLoad(Integer waitPageLoad) {
        this.waitPageLoad = waitPageLoad;
    }

    @JsonProperty("pageName")
    public String getPageName() {
        return pageName;
    }

    @JsonProperty("pageName")
    public void setPageName(String pageName) {
        this.pageName = pageName;
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
