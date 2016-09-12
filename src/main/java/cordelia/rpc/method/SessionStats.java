package cordelia.rpc.method;

import cordelia.rpc.Request;

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

public final class SessionStats extends Request {

    public static final String METHOD = "session-stats";

    public SessionStats() {
        this(null);
    }

    public SessionStats(Integer tag) {
        super(METHOD, tag);
    }
}
