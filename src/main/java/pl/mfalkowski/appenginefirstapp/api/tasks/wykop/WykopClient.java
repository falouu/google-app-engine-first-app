package pl.mfalkowski.appenginefirstapp.api.tasks.wykop;

import pl.mfalkowski.appenginefirstapp.api.tasks.wykop.entity.TagIndexResponse;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class WykopClient {
    private final WebTarget wykopApiTarget;
    private final WykopProperties properties;

    public WykopClient(Client client, WykopProperties properties) {
        this.wykopApiTarget = client.target(properties.getWykopApiUrl());
        this.properties = properties;
    }

    public TagIndexResponse getLatestEntriesForTag(String tag) {
        TagIndexResponse response = wykopApiTarget.path("/tag/index/spacex/appkey,{appKey},page,1")
            .resolveTemplate("appKey", properties.getWykopAppKey())
            .request()
            .get(TagIndexResponse.class);

        if (response.getError() != null) {
            throw new RuntimeException("Errors in wykop response!");
        }
        return response;
    }
}
