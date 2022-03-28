package nu.hex.story.manager.core.domain.atlas.impl;

import java.util.ArrayList;
import java.util.List;
import nu.hex.story.manager.core.domain.atlas.Location;
import nu.hex.story.manager.core.domain.image.Illustration;

public class DefaultLocation implements Location {

    private Long id;
    private String name;
    private Double longitude;
    private Double latitude;
    private String description;
    private final List<Illustration> illustrations = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Double getLongitude() {
        return longitude;
    }

    @Override
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public Double getLatitude() {
        return latitude;
    }

    @Override
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public List<Illustration> getIllustrations() {
        return illustrations;
    }

    @Override
    public void setIllustrations(List<Illustration> illustrations) {
        this.illustrations.clear();
        this.illustrations.addAll(illustrations);
    }

    @Override
    public void addIllustration(Illustration illustration) {
        this.illustrations.add(illustration);
    }

    @Override
    public String toString() {
        return getName();
    }
}
