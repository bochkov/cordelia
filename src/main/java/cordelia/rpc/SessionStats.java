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

public final class SessionStats extends AbsReq {

    public SessionStats() {
        this(9);
    }

    public SessionStats(Integer tag) {
        super(tag, "session-stats");
    }
}
