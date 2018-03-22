package ru.android.hedgehogs.main.videos;

/**
 * Created by yasina on 22.03.18.
 */

public class Video {

    private int id;
    private String title, currentSizeType, originalSizeType;
    private byte[] image;
    private int imageTemp, quality;
    private double currentSize, originalSize;
    private String videoDuration;

    public Video(int id, String title, String currentSizeType,
                 String originalSizeType, byte[] image, int imageTemp,
                 int quality, double currentSize, double originalSize,
                 String videoDuration) {
        this.id = id;
        this.title = title;
        this.currentSizeType = currentSizeType;
        this.originalSizeType = originalSizeType;
        this.image = image;
        this.imageTemp = imageTemp;
        this.quality = quality;
        this.currentSize = currentSize;
        this.originalSize = originalSize;
        this.videoDuration = videoDuration;
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
