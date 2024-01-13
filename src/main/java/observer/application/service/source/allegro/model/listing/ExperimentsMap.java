
package observer.application.service.source.allegro.model.listing;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kapitan-mixer-layout-v2-mweb"
})
@Generated("jsonschema2pojo")
public class ExperimentsMap {

    @JsonProperty("kapitan-mixer-layout-v2-mweb")
    private String kapitanMixerLayoutV2Mweb;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExperimentsMap() {
    }

    /**
     * 
     * @param kapitanMixerLayoutV2Mweb
     */
    public ExperimentsMap(String kapitanMixerLayoutV2Mweb) {
        super();
        this.kapitanMixerLayoutV2Mweb = kapitanMixerLayoutV2Mweb;
    }

    @JsonProperty("kapitan-mixer-layout-v2-mweb")
    public String getKapitanMixerLayoutV2Mweb() {
        return kapitanMixerLayoutV2Mweb;
    }

    @JsonProperty("kapitan-mixer-layout-v2-mweb")
    public void setKapitanMixerLayoutV2Mweb(String kapitanMixerLayoutV2Mweb) {
        this.kapitanMixerLayoutV2Mweb = kapitanMixerLayoutV2Mweb;
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
