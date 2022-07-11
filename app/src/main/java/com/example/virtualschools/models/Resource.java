
package com.example.virtualschools.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Generated("jsonschema2pojo")

@Parcel
public class Resource {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("createdat")
    @Expose
    private String createdat;
    @SerializedName("updatedat")
    @Expose
    private String updatedat;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("access")
    @Expose
    private String access;
    @SerializedName("subjectid")
    @Expose
    private Integer subjectid;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Resource() {
    }

    /**
     * 
     * @param createdat
     * @param access
     * @param name
     * @param description
     * @param id
     * @param type
     * @param userid
     * @param url
     * @param subjectid
     * @param updatedat
     */
    public Resource(Integer id, String name, String description, String createdat, String updatedat, String url, String type, String userid, String access, Integer subjectid) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdat = createdat;
        this.updatedat = updatedat;
        this.url = url;
        this.type = type;
        this.userid = userid;
        this.access = access;
        this.subjectid = subjectid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }

    public String getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(String updatedat) {
        this.updatedat = updatedat;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

}
