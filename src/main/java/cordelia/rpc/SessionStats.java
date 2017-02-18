package cordelia.rpc;

import java.io.Serializable;

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

public final class SessionStats implements Serializable {

    private final String method = "session-stats";
    private final Integer tag;

    public SessionStats() {
        this(null);
    }

    public SessionStats(Integer tag) {
        this.tag = tag;
    }
}
