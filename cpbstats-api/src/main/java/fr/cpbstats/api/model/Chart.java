package fr.cpbstats.api.model;

import java.util.ArrayList;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * The {@link Chart} class.
 * 
 * @author rebourgi
 * 
 */
@ApiModel
public class Chart {

    /** The data. */
    @ApiModelProperty(value = "Data")
    private List<String> data = new ArrayList<String>();

    /** The labels. */
    @ApiModelProperty(value = "Labels")
    private List<String> labels = new ArrayList<String>();

    /**
     * Return the Chart data.
     * 
     * @return the data
     */
    public List<String> getData() {
        return data;
    }

    /**
     * Set the Chart data.
     * 
     * @param data
     *            the data to set
     */
    public void setData(List<String> data) {
        this.data = data;
    }

    /**
     * Return the Chart labels.
     * 
     * @return the labels
     */
    public List<String> getLabels() {
        return labels;
    }

    /**
     * Set the Chart labels.
     * 
     * @param labels
     *            the labels to set
     */
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

}
