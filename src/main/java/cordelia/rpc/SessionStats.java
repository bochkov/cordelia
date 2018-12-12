package cordelia.rpc;

/*
   Response arguments:

   "activeTorrentCount"       | number
   "downloadSpeed"            | number
   "pausedTorrentCount"       | number
   "torrentCount"             | number
   "uploadSpeed"              | number
   ---------------------------+-------------------------------+
   "cumulative-stats"         | object, containing:           |
                              +------------------+------------+
                              | uploadedBytes    | number     |
                              | downloadedBytes  | number     |
                              | filesAdded       | number     |
                              | sessionCount     | number     |
                              | secondsActive    | number     |
   ---------------------------+-------------------------------+
   "current-stats"            | object, containing:           |
                              +------------------+------------+
                              | uploadedBytes    | number     |
                              | downloadedBytes  | number     |
                              | filesAdded       | number     |
                              | sessionCount     | number     |
                              | secondsActive    | number     |
   ---------------------------+-------------------------------+
 */

public final class SessionStats implements Req {

    private final String method;
    private final Integer tag;

    public SessionStats(Integer tag) {
        this.tag = tag;
        this.method = "session-stats";
    }

    @Override
    public String method() {
        return method;
    }

    @Override
    public Integer tag() {
        return tag;
    }
}
