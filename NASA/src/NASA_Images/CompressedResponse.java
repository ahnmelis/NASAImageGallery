package NASA_Images;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompressedResponse {
	@SerializedName("href")
    @Expose
    private String href;
	
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("center")
    @Expose
    private String center;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("secondary_creator")
    @Expose
    private String secondaryCreator;
	public CompressedResponse() {
		
	}
	
	public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSecondaryCreator() {
        return secondaryCreator;
    }

    public void setSecondaryCreator(String secondaryCreator) {
        this.secondaryCreator = secondaryCreator;
    }
	

}
