package pl.mfalkowski.appenginefirstapp.api.tasks.wykop.entity;

import java.util.List;

public class TagIndexResponse {
    private Error error;
    private Meta meta;
    private List<Item> items;

    public Error getError() {
        return error;
    }

    public Meta getMeta() {
        return meta;
    }

    public List<Item> getItems() {
        return items;
    }
}
