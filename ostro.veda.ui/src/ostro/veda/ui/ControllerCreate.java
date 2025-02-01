package ostro.veda.ui;

public enum ControllerCreate {

    CENTER("center");

    private String type;

    ControllerCreate (String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
