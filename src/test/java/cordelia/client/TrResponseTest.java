package cordelia.client;

import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class TrResponseTest {

    private static final String SUCCESS = "success";
    private static final String FAIL = "error";

    @Test
    public void result() {
        TrResponse resp = new TrResponse("-1", SUCCESS, Collections.emptyMap());
        Assert.assertEquals(SUCCESS, resp.result());
    }

    @Test
    public void successTrue() {
        TrResponse resp = new TrResponse("12", SUCCESS, Collections.emptyMap());
        Assert.assertTrue(resp.success());
    }

    @Test
    public void successFalse() {
        TrResponse resp = new TrResponse("12", FAIL, Collections.emptyMap());
        Assert.assertFalse(resp.success());
    }

    @Test
    public void arguments() {
        TrResponse resp = new TrResponse(
                "5",
                FAIL,
                new MapOf<>(
                        new MapEntry<>("test", "test")
                )
        );
        Assert.assertNotNull(resp.arguments());
    }

    @Test
    public void get() {
        TrResponse resp = new TrResponse(
                "7",
                SUCCESS,
                new MapOf<>(
                        new MapEntry<>("test1", "test1Val")
                )
        );
        Assert.assertNull(resp.get("test0"));
        Assert.assertEquals("test1Val", resp.get("test1"));
    }

    @Test
    public void testGetOrDefault() {
        TrResponse resp = new TrResponse(
                "7",
                SUCCESS,
                new MapOf<>(
                        new MapEntry<>("test", "testVal")
                )
        );
        Assert.assertNotNull(resp.get("test2", "test2Val"));
        Assert.assertEquals("testVal", resp.get("test"));
    }

    @Test
    public void tag() {
        TrResponse resp = new TrResponse("12", FAIL, Collections.emptyMap());
        Assert.assertEquals("12", resp.tag());
    }

    @Test
    public void testToString() {
        TrResponse resp = new TrResponse("122", FAIL, Collections.emptyMap());
        Assert.assertNotNull(resp.toString());
        Assert.assertNotEquals("", resp.toString());
    }
}