package cordelia.client;

import java.io.Serializable;

public final class TestFreeSpaceRes implements Serializable {

    private final String ddd;

    public TestFreeSpaceRes(String ddd) {
        this.ddd = ddd;
    }

    public String ddd() {
        return ddd;
    }
}
