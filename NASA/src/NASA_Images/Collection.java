
package NASA_Images;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Collection {

    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
