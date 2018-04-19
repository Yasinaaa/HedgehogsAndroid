package ru.android.hedgehogs.network.response_object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by yasina on 19.04.18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoRO {

    private int id;
    private String name;

    private String title, currentSizeType, originalSizeType;
    private byte[] image;
    private int imageTemp, quality;
    private double currentSize, originalSize;
    private String videoDuration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrentSizeType() {
        return currentSizeType;
    }

    public void setCurrentSizeType(String currentSizeType) {
        this.currentSizeType = currentSizeType;
    }

    public String getOriginalSizeType() {
        return originalSizeType;
    }

    public void setOriginalSizeType(String originalSizeType) {
        this.originalSizeType = originalSizeType;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getImageTemp() {
        return imageTemp;
    }

    public void setImageTemp(int imageTemp) {
        this.imageTemp = imageTemp;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public double getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(double currentSize) {
        this.currentSize = currentSize;
    }

    public double getOriginalSize() {
        return originalSize;
    }

    public void setOriginalSize(double originalSize) {
        this.originalSize = originalSize;
    }

    public String getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(String videoDuration) {
        this.videoDuration = videoDuration;
    }

}
