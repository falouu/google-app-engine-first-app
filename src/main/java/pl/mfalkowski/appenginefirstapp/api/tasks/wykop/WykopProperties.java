package pl.mfalkowski.appenginefirstapp.api.tasks.wykop;

import com.google.appengine.repackaged.com.google.common.base.Preconditions;

import static com.google.appengine.repackaged.com.google.common.base.Preconditions.checkNotNull;

public class WykopProperties {
    private final String wykopApiUrl;
    private final String wykopAppKey;

    private WykopProperties(Builder builder) {
        checkNotNull(builder.wykopAppKey);
        checkNotNull(builder.wykopApiUrl);

        this.wykopApiUrl = builder.wykopApiUrl;
        this.wykopAppKey = builder.wykopAppKey;
    }

    public String getWykopApiUrl() {
        return wykopApiUrl;
    }

    public String getWykopAppKey() {
        return wykopAppKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String wykopApiUrl = "http://a.wykop.pl";
        private String wykopAppKey;

        private Builder() {
        }

        public Builder withWykopApiUrl(String wykopApiUrl) {
            this.wykopApiUrl = wykopApiUrl;
            return this;
        }

        public Builder withWykopAppKey(String appKey) {
            this.wykopAppKey = appKey;
            return this;
        }

        public WykopProperties build() {
            return new WykopProperties(this);
        }
    }
}
