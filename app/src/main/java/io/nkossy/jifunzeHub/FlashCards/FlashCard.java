package io.nkossy.jifunzeHub.FlashCards;

/**
 * Created by nickhq on 2/16/18.
 */

public class FlashCard {
    private String title;
    private String body;

    public FlashCard(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
