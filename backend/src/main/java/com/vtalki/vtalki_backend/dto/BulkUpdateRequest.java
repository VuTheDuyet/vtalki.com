package com.vtalki.vtalki_backend.dto;

import java.util.List;

public class BulkUpdateRequest {
    private List<String> ids;
    private boolean status;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
