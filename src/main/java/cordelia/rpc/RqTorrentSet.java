package cordelia.rpc;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@ReqMethod("torrent-set")
public final class RqTorrentSet implements RqArguments {

    private Integer bandwidthPriority;
    private Long downloadLimit;
    private Boolean downloadLimited;
    @JsonProperty("files-unwanted")
    private List<Integer> filesUnwanted;
    @JsonProperty("files-wanted")
    private List<Integer> filesWanted;
    private String group;
    private Boolean honorsSessionLimits;
    private List<Object> ids;
    private List<String> labels;
    private String location;
    @JsonProperty("peer-limit")
    private Integer peerLimit;
    @JsonProperty("priority-high")
    private List<Integer> priorityHigh;
    @JsonProperty("priority-low")
    private List<Integer> priorityLow;
    @JsonProperty("priority-normal")
    private List<Integer> priorityNormal;
    private Integer queuePosition;
    private Integer seedIdleLimit;
    private Integer seedIdleMode;
    private Float seedRatioLimit;
    private Integer seedRatioMode;
    private Boolean sequentialDownload;
    private String trackerList;
    private Long uploadLimit;
    private Boolean uploadLimited;

}
