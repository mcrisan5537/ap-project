package app.model;

public class ImageLinks {
    private String small, regular, full, raw;

    public Builder builder() {
        return new Builder(this);
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public static class Builder {
        private final ImageLinks links;
        private Builder(ImageLinks links) {
            this.links = links;
        }

        public Builder small(String url) {
            links.setSmall(url);
            return this;
        }

        public Builder regular(String url) {
            links.setRegular(url);
            return this;
        }

        public Builder full(String url) {
            links.setFull(url);
            return this;
        }

        public Builder raw(String url) {
            links.setRaw(url);
            return this;
        }

        public ImageLinks build() {
            return links;
        }
    }

}
